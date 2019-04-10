grammar PrePro;

@parser::header
{
package de.sbernauer.prepro.parser;

import java.util.Arrays;

import org.nd4j.linalg.factory.Nd4j;

import de.sbernauer.prepro.nodes.*;
import de.sbernauer.prepro.nodes.statement.*;
import de.sbernauer.prepro.nodes.expression.*;
import de.sbernauer.prepro.nodes.expression.arithmetic.*;
import de.sbernauer.prepro.nodes.function.*;
import de.sbernauer.prepro.nodes.debugging.*;
import de.sbernauer.prepro.nodes.expression.logic.*;
import de.sbernauer.prepro.variables.*;

}

@lexer::header
{
package de.sbernauer.prepro.parser;

}

@parser::members
{
private NodeFactory nodeFactory = new NodeFactory();
}

// parser

prepro returns [MainNode result]:
(                                   { nodeFactory.startFunctionList(); }
    mainFunction                    { nodeFactory.addFunction($mainFunction.result); }
    | function                      { nodeFactory.addFunction($function.result); }
)*                                  { $result = new MainNode(nodeFactory.getFunctionsAsArray()); }
|
(                                   { nodeFactory.startFunctionList(); nodeFactory.startStatementList(); }
    ('import' importDefinitions ';')?
    (
        statement                   { nodeFactory.addStatement($statement.result, $statement.start.getLine()); }
    )*
    ('export' exportDefinitions ';')? { nodeFactory.addFunction(new MainFunctionNode("main", (_localctx.importDefinitions == null ? new ArrayList<>() : $importDefinitions.result), (_localctx.exportDefinitions == null ? new ArrayList<>() : $exportDefinitions.result), new StatementListNode(nodeFactory.getStatementsAsArray()))); }
    (
        function                    { nodeFactory.addFunction($function.result); }
    )*
)                                   { $result = new MainNode(nodeFactory.getFunctionsAsArray()); }
EOF
;

mainFunction returns [MainFunctionNode result]:
'function'                          { nodeFactory.startStatementList(); }
'main'
'('
')'
'{'
'import'
importDefinitions
';'
(
    statement                       { nodeFactory.addStatement($statement.result, $statement.start.getLine()); }
)*
'export'
exportDefinitions
';'
'}'                                 { $result = new MainFunctionNode("main", $importDefinitions.result, $exportDefinitions.result, new StatementListNode(nodeFactory.getStatementsAsArray())); }
;

importDefinitions returns [List<ImportDefinition> result]:
                                    { $result = new ArrayList<>(); }
(
    (
        TYPE IDENTIFIER             { $result.add(nodeFactory.createImportDefinition($TYPE.text, $IDENTIFIER.text, false)); }
        | 'optional' TYPE IDENTIFIER{ $result.add(nodeFactory.createImportDefinition($TYPE.text, $IDENTIFIER.text, true)); }
    )
    (
        (
            ',' TYPE IDENTIFIER     { $result.add(nodeFactory.createImportDefinition($TYPE.text, $IDENTIFIER.text, false)); }
            | ',' 'optional' TYPE IDENTIFIER { $result.add(nodeFactory.createImportDefinition($TYPE.text, $IDENTIFIER.text, true)); }
        )
    )*
)?
;

exportDefinitions returns [List<String> result]:
                                    { $result = new ArrayList<>(); }
IDENTIFIER                          { $result.add($IDENTIFIER.text); }
(
    ','
    IDENTIFIER                      { $result.add($IDENTIFIER.text); }
)*
;


function returns [FunctionNode result]:
'function'                          { nodeFactory.startStatementList(); }
IDENTIFIER
'('
functionArguments
')'
(
    'returns'
    returnType=TYPE
)?
'{'
(
    statement                       { nodeFactory.addStatement($statement.result, $statement.start.getLine()); }
)*
(
'return'
returnExpression=expression
';'
)?
'}'                                 { List<ParameterDefinition> functionArguments = (_localctx.functionArguments == null) ? null : $functionArguments.result;
                                      ExpressionNode returnExpression = (_localctx.returnExpression == null) ? null : $returnExpression.result;
                                      $result = new FunctionNode($IDENTIFIER.text, $returnType.text,
                                      functionArguments, new StatementListNode(nodeFactory.getStatementsAsArray()),
                                      returnExpression); }
;

functionArguments returns [List<ParameterDefinition> result]:
                                    { $result = new ArrayList<>(); }
(
    TYPE IDENTIFIER                 { $result.add(nodeFactory.createParameterDefinition($TYPE.text, $IDENTIFIER.text)); }
    (
        ',' TYPE IDENTIFIER         { $result.add(nodeFactory.createParameterDefinition($TYPE.text, $IDENTIFIER.text)); }
    )*
)?
;

statement returns [StatementNode result]:
( assignStatement                   { $result = $assignStatement.result; }
| expression                        { $result = new NopStatementNode($expression.result); }
| printStatement                    { $result = $printStatement.result; }
| debugStatement                    { $result = new DebugNode($debugStatement.start.getLine()); }
)
';'
;

assignStatement returns [AssignStatementNode result]:
TYPE?
i=IDENTIFIER
'='
(
e=expression                        { $result = new AssignStatementNode($i.text, $TYPE.text, $e.result); }
)
;

functionCallStatement returns [FunctionCallNode result]:
IDENTIFIER
'('                                 { List<ExpressionNode> expressionList = new ArrayList<>(); }
(
    expression                      { expressionList.add($expression.result); }
    (
        ',' expression              { expressionList.add($expression.result); }
    )*
)?
')'                                 { $result = new FunctionCallNode($IDENTIFIER.text, expressionList); }
;

printStatement returns [PrintStatementNode result]:
'print'
(
    expression                      { $result = new PrintStatementNode($expression.result); }
    | STRING_LITERAL                { $result = new PrintStatementNode($STRING_LITERAL.text.substring(1, $STRING_LITERAL.text.length() - 1)); } //cut off leading and trailing "
)
;

throwStatement returns [ThrowStatementNode result]:
'throw'
(
    STRING_LITERAL                { $result = new ThrowStatementNode($STRING_LITERAL.text.substring(1, $STRING_LITERAL.text.length() - 1)); } //cut off leading and trailing "
)
;

debugStatement:
d='debug'
;

expression returns [ExpressionNode result]:
term                                { $result = $term.result; }
(
      ('+' term)                    { $result = new AddNode($result, $term.result); }
    | ('-' term)                    { $result = new SubNode($result, $term.result); }
)*
;

term returns [ExpressionNode result]:
factor                              { $result = $factor.result; }
(
      ('*' factor)                  { $result = new MulNode($result, $factor.result); }
    | ('**' factor)                 { $result = new LazyMulNode($result, $factor.result); }
    | ('X' factor)                  { $result = new CrossProductNode($result, $factor.result); }
    | ('/' factor)                  { $result = new DivNode($result, $factor.result); }
    | '==' factor                   { $result = new IsEqualNode($result, $factor.result); }
    | '<=' factor                   { $result = new IsLessOrEqualNode($result, $factor.result); }
    | '<' factor                    { $result = new IsLessNode($result, $factor.result); }
    | '>' factor                    { $result = new IsGreaterNode($result, $factor.result); }
    | '>=' factor                   { $result = new IsGreaterOrEqualNode($result, $factor.result); }
    | '&&' factor                   { $result = new LazyAndNode($result, $factor.result); }
    | '||' factor                   { $result = new LazyOrNode($result, $factor.result); }
)*
;

factor returns [ExpressionNode result]:
IDENTIFIER                          { $result = new VariableConstantNode($IDENTIFIER.text); }
| 'exists' '(' IDENTIFIER ')'       { $result = new ExistsNode($IDENTIFIER.text); }
| functionCallStatement             { $result = $functionCallStatement.result; }
| throwStatement                    { $result = $throwStatement.result; }
| '(' expression ')'                { $result = $expression.result; }
| NUMERIC_LITERAL                   { $result = new ConstantNode(Double.parseDouble($NUMERIC_LITERAL.text)); }
;

// lexer

WS : [ \t\r\n\u000C]+ -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;

fragment LETTER : [A-Z] | [a-z] | '_' | '$';
fragment NON_ZERO_DIGIT : [1-9];
fragment DIGIT : [0-9];
// fragment HEX_DIGIT : [0-9] | [a-f] | [A-F];
// fragment OCT_DIGIT : [0-7];
// fragment BINARY_DIGIT : '0' | '1';
// fragment TAB : '\t';
fragment STRING_CHAR : ~('"' | '\\' | '\r' | '\n');

TYPE : 'vec3' | 'vec4' | 'mat' | 'mat3' | 'mat4' | 'scal' | 'const';

IDENTIFIER : LETTER (LETTER | DIGIT)*;
STRING_LITERAL : '"' STRING_CHAR* '"';
NUMERIC_LITERAL : '-'? ('0' | NON_ZERO_DIGIT DIGIT*) ('.' DIGIT*)?;
