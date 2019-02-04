grammar PrePro;

@lexer::header {
package de.sbernauer.prepro.plugin.syntaxhighlighting.parser;
}

@parser::header {
package de.sbernauer.prepro.plugin.syntaxhighlighting.parser;
}

@parser::members {
	public List<SyntaxError> syntaxErrors = new ArrayList<>();

	@Override
    	public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    		String message = super.getErrorMessage(e, tokenNames);
    		SyntaxError syntaxError = new SyntaxError();
    		syntaxError.exception = e;
    		syntaxError.message = message;

                CommonToken token =  (CommonToken) e.token;

                syntaxError.line = e.token.getLine();
                syntaxError.charPositionInLine = e.token.getCharPositionInLine();
                syntaxError.start = token.getStartIndex();

                syntaxError.stop = token.getStopIndex()+1;
                
    		syntaxErrors.add(syntaxError);
    		return message;
    	}

    	public static class SyntaxError {
    		public RecognitionException exception;
    		public String message;
    		public int line;
    		public int charPositionInLine;
                public int start,stop;
    	}
}

prepro options {backtrack=true;}: ((mainFunction | function)* )
| ((IMPORT functionArguments SEMICOLON)? statement* (EXPORT exportDefinitions SEMICOLON)? function*)
EOF;

mainFunction: FUNCTION MAIN LEFTPAREN RIGHTPAREN LEFTBRACE
IMPORT functionArguments SEMICOLON
statement*
EXPORT exportDefinitions SEMICOLON
RIGHTBRACE;

exportDefinitions: IDENTIFIER (COMMA IDENTIFIER)*;

function: FUNCTION IDENTIFIER LEFTPAREN functionArguments RIGHTPAREN
(RETURNS TYPE)?
LEFTBRACE
statement*
(RETURN expression SEMICOLON)?
RIGHTBRACE;

functionArguments: (TYPE IDENTIFIER (COMMA TYPE IDENTIFIER)*)?;

statement: (assignStatement | printStatement | debugStatement | expression) SEMICOLON;

assignStatement: TYPE? IDENTIFIER EQUALS expression;

functionCallStatement: IDENTIFIER LEFTPAREN (expression (COMMA expression)*)? RIGHTPAREN;

printStatement: PRINT (expression | STRING_LITERAL);

debugStatement: DEBUG;

expression: term ((PLUS term) | (MINUS term))*;

term: factor ((MUL factor) | (DIV factor) | (CROSSPRODUCT factor))*;

factor: IDENTIFIER | functionCallStatement | (LEFTPAREN expression RIGHTPAREN) | NUMERIC_LITERAL;

FUNCTION: 'function';
MAIN: 'main';
LEFTPAREN : '(';
RIGHTPAREN : ')';
LEFTBRACE : '{';
RIGHTBRACE : '}';
IMPORT: 'import';
EXPORT: 'export';
SEMICOLON: ';';
COMMA: ',';
RETURN: 'return';
RETURNS: 'returns';
PRINT: 'print';
EQUALS: '=';
DEBUG: 'debug';
PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
CROSSPRODUCT: 'X';

WS: (' ' | '\t' | '\r' | '\n')+ {$channel=HIDDEN;};

TYPE : 'vec3' | 'vec4' | 'mat' | 'mat3' | 'mat4' | 'scal' | 'const';
STRING_LITERAL : '"' (~('"' | '\\' | '\r' | '\n'))* '"';
NUMERIC_LITERAL : '-'? ('0' | '1'..'9' '0'..'9'*) ('.' '0'..'9'*)?;
IDENTIFIER : ('A'..'Z' | 'a'..'z' | '_' | '$') (('A'..'Z' | 'a'..'z' | '_' | '$') | '0'..'9')*;
