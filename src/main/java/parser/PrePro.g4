grammar PrePro;

@parser::header
{
package parser;

import java.util.Arrays;

import org.nd4j.linalg.factory.Nd4j;

import nodes.*;
import nodes.statement.*;
import nodes.expression.*;
import nodes.expression.arithmetic.*;
import nodes.function.*;
import nodes.debugging.*;
import variables.*;


}

@lexer::header
{
package parser;

}

@parser::members
{
private NodeFactory nodeFactory = new NodeFactory();
}

// parser

prepro returns [MainNode result]
:                                   { nodeFactory.startFunctionList();
                                      MainFunctionNode mainFunctionNode;}
(
    mainFunction                    { nodeFactory.addFunction($mainFunction.result); }
    | function                      { nodeFactory.addFunction($function.result); }
)*
EOF                                 { $result = new MainNode(nodeFactory.getFunctionsAsArray()); }
;

mainFunction returns [MainFunctionNode result]:
'function'                          { nodeFactory.startStatementList(); }
'main'
'('
')'
'{'
'import'
importDefinitions=functionArguments
';'
(
    statement                       { nodeFactory.addStatement($statement.result, $statement.start.getLine()); }
)*
'export'
exportDefinitions
';'
'}'                                 { $result = new MainFunctionNode("main", $importDefinitions.result, $exportDefinitions.result, new StatementListNode(nodeFactory.getStatementsAsArray())); }
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
    TYPE IDENTIFIER                 { $result.add(nodeFactory.createParameterDefiniton($TYPE.text, $IDENTIFIER.text)); }
    (
        ',' TYPE IDENTIFIER         { $result.add(nodeFactory.createParameterDefiniton($TYPE.text, $IDENTIFIER.text)); }
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
'('                                 { nodeFactory.startExpressionList(); }
(
    expression                      { nodeFactory.addExpression($expression.result); }
    (
        ',' expression              { nodeFactory.addExpression($expression.result); }
    )*
)?
')'                                 { $result = new FunctionCallNode($IDENTIFIER.text, nodeFactory.getExpressionsAsList()); }
;

printStatement returns [PrintStatementNode result]:
'print'
(
    expression                      { $result = new PrintStatementNode($expression.result); }
    | STRING_LITERAL                { $result = new PrintStatementNode($STRING_LITERAL.text.substring(1, $STRING_LITERAL.text.length() - 1)); } //cut off leading and trailing "
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
    | ('X' factor)                  { $result = new CrossProductNode($result, $factor.result); }
    | ('/' factor)                  { $result = new DivNode($result, $factor.result); }
)*
;

factor returns [ExpressionNode result]:
IDENTIFIER                          { $result = new VariableConstantNode($IDENTIFIER.text); }
| functionCallStatement             { $result = $functionCallStatement.result; }
| '(' expression ')'                { $result = $expression.result; }
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

TYPE : 'vec3' | 'mat';

IDENTIFIER : LETTER (LETTER | DIGIT)*;
STRING_LITERAL : '"' STRING_CHAR* '"';
NUMERIC_LITERAL : '-'? ('0' | NON_ZERO_DIGIT DIGIT*);
