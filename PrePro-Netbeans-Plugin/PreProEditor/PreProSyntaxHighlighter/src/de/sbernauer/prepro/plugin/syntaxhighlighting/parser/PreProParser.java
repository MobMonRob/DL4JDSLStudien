// $ANTLR 3.5.2 PrePro.g 2018-12-31 13:52:26

package de.sbernauer.prepro.plugin.syntaxhighlighting.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PreProParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMA", "CROSSPRODUCT", "DEBUG", 
		"DIV", "EQUALS", "EXPORT", "FUNCTION", "IDENTIFIER", "IMPORT", "LEFTBRACE", 
		"LEFTPAREN", "MAIN", "MINUS", "MUL", "NUMERIC_LITERAL", "PLUS", "PRINT", 
		"RETURN", "RETURNS", "RIGHTBRACE", "RIGHTPAREN", "SEMICOLON", "STRING_LITERAL", 
		"TYPE", "WS"
	};
	public static final int EOF=-1;
	public static final int COMMA=4;
	public static final int CROSSPRODUCT=5;
	public static final int DEBUG=6;
	public static final int DIV=7;
	public static final int EQUALS=8;
	public static final int EXPORT=9;
	public static final int FUNCTION=10;
	public static final int IDENTIFIER=11;
	public static final int IMPORT=12;
	public static final int LEFTBRACE=13;
	public static final int LEFTPAREN=14;
	public static final int MAIN=15;
	public static final int MINUS=16;
	public static final int MUL=17;
	public static final int NUMERIC_LITERAL=18;
	public static final int PLUS=19;
	public static final int PRINT=20;
	public static final int RETURN=21;
	public static final int RETURNS=22;
	public static final int RIGHTBRACE=23;
	public static final int RIGHTPAREN=24;
	public static final int SEMICOLON=25;
	public static final int STRING_LITERAL=26;
	public static final int TYPE=27;
	public static final int WS=28;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public PreProParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public PreProParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return PreProParser.tokenNames; }
	@Override public String getGrammarFileName() { return "PrePro.g"; }


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



	// $ANTLR start "prepro"
	// PrePro.g:42:1: prepro : ( mainFunction | function )* EOF ;
	public final void prepro() throws RecognitionException {
		try {
			// PrePro.g:42:7: ( ( mainFunction | function )* EOF )
			// PrePro.g:42:9: ( mainFunction | function )* EOF
			{
			// PrePro.g:42:9: ( mainFunction | function )*
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==FUNCTION) ) {
					int LA1_2 = input.LA(2);
					if ( (LA1_2==MAIN) ) {
						alt1=1;
					}
					else if ( (LA1_2==IDENTIFIER) ) {
						alt1=2;
					}

				}

				switch (alt1) {
				case 1 :
					// PrePro.g:42:10: mainFunction
					{
					pushFollow(FOLLOW_mainFunction_in_prepro37);
					mainFunction();
					state._fsp--;

					}
					break;
				case 2 :
					// PrePro.g:42:25: function
					{
					pushFollow(FOLLOW_function_in_prepro41);
					function();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			match(input,EOF,FOLLOW_EOF_in_prepro45); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "prepro"



	// $ANTLR start "mainFunction"
	// PrePro.g:44:1: mainFunction : FUNCTION MAIN LEFTPAREN RIGHTPAREN LEFTBRACE IMPORT functionArguments SEMICOLON ( statement )* EXPORT exportDefinitions SEMICOLON RIGHTBRACE ;
	public final void mainFunction() throws RecognitionException {
		try {
			// PrePro.g:44:13: ( FUNCTION MAIN LEFTPAREN RIGHTPAREN LEFTBRACE IMPORT functionArguments SEMICOLON ( statement )* EXPORT exportDefinitions SEMICOLON RIGHTBRACE )
			// PrePro.g:44:15: FUNCTION MAIN LEFTPAREN RIGHTPAREN LEFTBRACE IMPORT functionArguments SEMICOLON ( statement )* EXPORT exportDefinitions SEMICOLON RIGHTBRACE
			{
			match(input,FUNCTION,FOLLOW_FUNCTION_in_mainFunction52); 
			match(input,MAIN,FOLLOW_MAIN_in_mainFunction54); 
			match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_mainFunction56); 
			match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_mainFunction58); 
			match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_mainFunction60); 
			match(input,IMPORT,FOLLOW_IMPORT_in_mainFunction62); 
			pushFollow(FOLLOW_functionArguments_in_mainFunction64);
			functionArguments();
			state._fsp--;

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mainFunction66); 
			// PrePro.g:46:1: ( statement )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==DEBUG||LA2_0==IDENTIFIER||LA2_0==LEFTPAREN||LA2_0==PRINT||LA2_0==TYPE) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// PrePro.g:46:1: statement
					{
					pushFollow(FOLLOW_statement_in_mainFunction68);
					statement();
					state._fsp--;

					}
					break;

				default :
					break loop2;
				}
			}

			match(input,EXPORT,FOLLOW_EXPORT_in_mainFunction71); 
			pushFollow(FOLLOW_exportDefinitions_in_mainFunction73);
			exportDefinitions();
			state._fsp--;

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mainFunction75); 
			match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_mainFunction77); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "mainFunction"



	// $ANTLR start "exportDefinitions"
	// PrePro.g:50:1: exportDefinitions : IDENTIFIER ( COMMA IDENTIFIER )* ;
	public final void exportDefinitions() throws RecognitionException {
		try {
			// PrePro.g:50:18: ( IDENTIFIER ( COMMA IDENTIFIER )* )
			// PrePro.g:50:20: IDENTIFIER ( COMMA IDENTIFIER )*
			{
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_exportDefinitions84); 
			// PrePro.g:50:31: ( COMMA IDENTIFIER )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==COMMA) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// PrePro.g:50:32: COMMA IDENTIFIER
					{
					match(input,COMMA,FOLLOW_COMMA_in_exportDefinitions87); 
					match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_exportDefinitions89); 
					}
					break;

				default :
					break loop3;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exportDefinitions"



	// $ANTLR start "function"
	// PrePro.g:52:1: function : FUNCTION IDENTIFIER LEFTPAREN functionArguments RIGHTPAREN ( RETURNS TYPE )? LEFTBRACE ( statement )* ( RETURN expression SEMICOLON )? RIGHTBRACE ;
	public final void function() throws RecognitionException {
		try {
			// PrePro.g:52:9: ( FUNCTION IDENTIFIER LEFTPAREN functionArguments RIGHTPAREN ( RETURNS TYPE )? LEFTBRACE ( statement )* ( RETURN expression SEMICOLON )? RIGHTBRACE )
			// PrePro.g:52:11: FUNCTION IDENTIFIER LEFTPAREN functionArguments RIGHTPAREN ( RETURNS TYPE )? LEFTBRACE ( statement )* ( RETURN expression SEMICOLON )? RIGHTBRACE
			{
			match(input,FUNCTION,FOLLOW_FUNCTION_in_function98); 
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function100); 
			match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_function102); 
			pushFollow(FOLLOW_functionArguments_in_function104);
			functionArguments();
			state._fsp--;

			match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_function106); 
			// PrePro.g:53:2: ( RETURNS TYPE )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==RETURNS) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// PrePro.g:53:2: RETURNS TYPE
					{
					match(input,RETURNS,FOLLOW_RETURNS_in_function109); 
					match(input,TYPE,FOLLOW_TYPE_in_function111); 
					}
					break;

			}

			match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_function115); 
			// PrePro.g:55:1: ( statement )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==DEBUG||LA5_0==IDENTIFIER||LA5_0==LEFTPAREN||LA5_0==PRINT||LA5_0==TYPE) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// PrePro.g:55:1: statement
					{
					pushFollow(FOLLOW_statement_in_function117);
					statement();
					state._fsp--;

					}
					break;

				default :
					break loop5;
				}
			}

			// PrePro.g:56:2: ( RETURN expression SEMICOLON )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==RETURN) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// PrePro.g:56:2: RETURN expression SEMICOLON
					{
					match(input,RETURN,FOLLOW_RETURN_in_function121); 
					pushFollow(FOLLOW_expression_in_function123);
					expression();
					state._fsp--;

					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_function125); 
					}
					break;

			}

			match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_function129); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "function"



	// $ANTLR start "functionArguments"
	// PrePro.g:59:1: functionArguments : ( TYPE IDENTIFIER ( COMMA TYPE IDENTIFIER )* )? ;
	public final void functionArguments() throws RecognitionException {
		try {
			// PrePro.g:59:18: ( ( TYPE IDENTIFIER ( COMMA TYPE IDENTIFIER )* )? )
			// PrePro.g:59:20: ( TYPE IDENTIFIER ( COMMA TYPE IDENTIFIER )* )?
			{
			// PrePro.g:59:20: ( TYPE IDENTIFIER ( COMMA TYPE IDENTIFIER )* )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==TYPE) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// PrePro.g:59:21: TYPE IDENTIFIER ( COMMA TYPE IDENTIFIER )*
					{
					match(input,TYPE,FOLLOW_TYPE_in_functionArguments137); 
					match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionArguments139); 
					// PrePro.g:59:37: ( COMMA TYPE IDENTIFIER )*
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==COMMA) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// PrePro.g:59:38: COMMA TYPE IDENTIFIER
							{
							match(input,COMMA,FOLLOW_COMMA_in_functionArguments142); 
							match(input,TYPE,FOLLOW_TYPE_in_functionArguments144); 
							match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionArguments146); 
							}
							break;

						default :
							break loop7;
						}
					}

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "functionArguments"



	// $ANTLR start "statement"
	// PrePro.g:61:1: statement : ( assignStatement | printStatement | debugStatement | expression ) SEMICOLON ;
	public final void statement() throws RecognitionException {
		try {
			// PrePro.g:61:10: ( ( assignStatement | printStatement | debugStatement | expression ) SEMICOLON )
			// PrePro.g:61:12: ( assignStatement | printStatement | debugStatement | expression ) SEMICOLON
			{
			// PrePro.g:61:12: ( assignStatement | printStatement | debugStatement | expression )
			int alt9=4;
			switch ( input.LA(1) ) {
			case TYPE:
				{
				alt9=1;
				}
				break;
			case IDENTIFIER:
				{
				int LA9_2 = input.LA(2);
				if ( (LA9_2==EQUALS) ) {
					alt9=1;
				}
				else if ( (LA9_2==CROSSPRODUCT||LA9_2==DIV||LA9_2==LEFTPAREN||(LA9_2 >= MINUS && LA9_2 <= MUL)||LA9_2==PLUS||LA9_2==SEMICOLON) ) {
					alt9=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case PRINT:
				{
				alt9=2;
				}
				break;
			case DEBUG:
				{
				alt9=3;
				}
				break;
			case LEFTPAREN:
				{
				alt9=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// PrePro.g:61:13: assignStatement
					{
					pushFollow(FOLLOW_assignStatement_in_statement158);
					assignStatement();
					state._fsp--;

					}
					break;
				case 2 :
					// PrePro.g:61:31: printStatement
					{
					pushFollow(FOLLOW_printStatement_in_statement162);
					printStatement();
					state._fsp--;

					}
					break;
				case 3 :
					// PrePro.g:61:48: debugStatement
					{
					pushFollow(FOLLOW_debugStatement_in_statement166);
					debugStatement();
					state._fsp--;

					}
					break;
				case 4 :
					// PrePro.g:61:65: expression
					{
					pushFollow(FOLLOW_expression_in_statement170);
					expression();
					state._fsp--;

					}
					break;

			}

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement173); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statement"



	// $ANTLR start "assignStatement"
	// PrePro.g:63:1: assignStatement : ( TYPE )? IDENTIFIER EQUALS expression ;
	public final void assignStatement() throws RecognitionException {
		try {
			// PrePro.g:63:16: ( ( TYPE )? IDENTIFIER EQUALS expression )
			// PrePro.g:63:18: ( TYPE )? IDENTIFIER EQUALS expression
			{
			// PrePro.g:63:18: ( TYPE )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==TYPE) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// PrePro.g:63:18: TYPE
					{
					match(input,TYPE,FOLLOW_TYPE_in_assignStatement180); 
					}
					break;

			}

			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assignStatement183); 
			match(input,EQUALS,FOLLOW_EQUALS_in_assignStatement185); 
			pushFollow(FOLLOW_expression_in_assignStatement187);
			expression();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assignStatement"



	// $ANTLR start "functionCallStatement"
	// PrePro.g:65:1: functionCallStatement : IDENTIFIER LEFTPAREN ( expression ( COMMA expression )* )? RIGHTPAREN ;
	public final void functionCallStatement() throws RecognitionException {
		try {
			// PrePro.g:65:22: ( IDENTIFIER LEFTPAREN ( expression ( COMMA expression )* )? RIGHTPAREN )
			// PrePro.g:65:24: IDENTIFIER LEFTPAREN ( expression ( COMMA expression )* )? RIGHTPAREN
			{
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionCallStatement194); 
			match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_functionCallStatement196); 
			// PrePro.g:65:45: ( expression ( COMMA expression )* )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==IDENTIFIER||LA12_0==LEFTPAREN) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// PrePro.g:65:46: expression ( COMMA expression )*
					{
					pushFollow(FOLLOW_expression_in_functionCallStatement199);
					expression();
					state._fsp--;

					// PrePro.g:65:57: ( COMMA expression )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==COMMA) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// PrePro.g:65:58: COMMA expression
							{
							match(input,COMMA,FOLLOW_COMMA_in_functionCallStatement202); 
							pushFollow(FOLLOW_expression_in_functionCallStatement204);
							expression();
							state._fsp--;

							}
							break;

						default :
							break loop11;
						}
					}

					}
					break;

			}

			match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_functionCallStatement210); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "functionCallStatement"



	// $ANTLR start "printStatement"
	// PrePro.g:67:1: printStatement : PRINT ( expression | STRING_LITERAL ) ;
	public final void printStatement() throws RecognitionException {
		try {
			// PrePro.g:67:15: ( PRINT ( expression | STRING_LITERAL ) )
			// PrePro.g:67:17: PRINT ( expression | STRING_LITERAL )
			{
			match(input,PRINT,FOLLOW_PRINT_in_printStatement217); 
			// PrePro.g:67:23: ( expression | STRING_LITERAL )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==IDENTIFIER||LA13_0==LEFTPAREN) ) {
				alt13=1;
			}
			else if ( (LA13_0==STRING_LITERAL) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// PrePro.g:67:24: expression
					{
					pushFollow(FOLLOW_expression_in_printStatement220);
					expression();
					state._fsp--;

					}
					break;
				case 2 :
					// PrePro.g:67:37: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_printStatement224); 
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "printStatement"



	// $ANTLR start "debugStatement"
	// PrePro.g:69:1: debugStatement : DEBUG ;
	public final void debugStatement() throws RecognitionException {
		try {
			// PrePro.g:69:15: ( DEBUG )
			// PrePro.g:69:17: DEBUG
			{
			match(input,DEBUG,FOLLOW_DEBUG_in_debugStatement232); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "debugStatement"



	// $ANTLR start "expression"
	// PrePro.g:71:1: expression : term ( ( PLUS term ) | ( MINUS term ) )* ;
	public final void expression() throws RecognitionException {
		try {
			// PrePro.g:71:11: ( term ( ( PLUS term ) | ( MINUS term ) )* )
			// PrePro.g:71:13: term ( ( PLUS term ) | ( MINUS term ) )*
			{
			pushFollow(FOLLOW_term_in_expression239);
			term();
			state._fsp--;

			// PrePro.g:71:18: ( ( PLUS term ) | ( MINUS term ) )*
			loop14:
			while (true) {
				int alt14=3;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==PLUS) ) {
					alt14=1;
				}
				else if ( (LA14_0==MINUS) ) {
					alt14=2;
				}

				switch (alt14) {
				case 1 :
					// PrePro.g:71:19: ( PLUS term )
					{
					// PrePro.g:71:19: ( PLUS term )
					// PrePro.g:71:20: PLUS term
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression243); 
					pushFollow(FOLLOW_term_in_expression245);
					term();
					state._fsp--;

					}

					}
					break;
				case 2 :
					// PrePro.g:71:33: ( MINUS term )
					{
					// PrePro.g:71:33: ( MINUS term )
					// PrePro.g:71:34: MINUS term
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression251); 
					pushFollow(FOLLOW_term_in_expression253);
					term();
					state._fsp--;

					}

					}
					break;

				default :
					break loop14;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "term"
	// PrePro.g:73:1: term : factor ( ( MUL factor ) | ( DIV factor ) | ( CROSSPRODUCT factor ) )* ;
	public final void term() throws RecognitionException {
		try {
			// PrePro.g:73:5: ( factor ( ( MUL factor ) | ( DIV factor ) | ( CROSSPRODUCT factor ) )* )
			// PrePro.g:73:7: factor ( ( MUL factor ) | ( DIV factor ) | ( CROSSPRODUCT factor ) )*
			{
			pushFollow(FOLLOW_factor_in_term263);
			factor();
			state._fsp--;

			// PrePro.g:73:14: ( ( MUL factor ) | ( DIV factor ) | ( CROSSPRODUCT factor ) )*
			loop15:
			while (true) {
				int alt15=4;
				switch ( input.LA(1) ) {
				case MUL:
					{
					alt15=1;
					}
					break;
				case DIV:
					{
					alt15=2;
					}
					break;
				case CROSSPRODUCT:
					{
					alt15=3;
					}
					break;
				}
				switch (alt15) {
				case 1 :
					// PrePro.g:73:15: ( MUL factor )
					{
					// PrePro.g:73:15: ( MUL factor )
					// PrePro.g:73:16: MUL factor
					{
					match(input,MUL,FOLLOW_MUL_in_term267); 
					pushFollow(FOLLOW_factor_in_term269);
					factor();
					state._fsp--;

					}

					}
					break;
				case 2 :
					// PrePro.g:73:30: ( DIV factor )
					{
					// PrePro.g:73:30: ( DIV factor )
					// PrePro.g:73:31: DIV factor
					{
					match(input,DIV,FOLLOW_DIV_in_term275); 
					pushFollow(FOLLOW_factor_in_term277);
					factor();
					state._fsp--;

					}

					}
					break;
				case 3 :
					// PrePro.g:73:45: ( CROSSPRODUCT factor )
					{
					// PrePro.g:73:45: ( CROSSPRODUCT factor )
					// PrePro.g:73:46: CROSSPRODUCT factor
					{
					match(input,CROSSPRODUCT,FOLLOW_CROSSPRODUCT_in_term283); 
					pushFollow(FOLLOW_factor_in_term285);
					factor();
					state._fsp--;

					}

					}
					break;

				default :
					break loop15;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "term"



	// $ANTLR start "factor"
	// PrePro.g:75:1: factor : ( IDENTIFIER | functionCallStatement | ( LEFTPAREN expression RIGHTPAREN ) );
	public final void factor() throws RecognitionException {
		try {
			// PrePro.g:75:7: ( IDENTIFIER | functionCallStatement | ( LEFTPAREN expression RIGHTPAREN ) )
			int alt16=3;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==IDENTIFIER) ) {
				int LA16_1 = input.LA(2);
				if ( (LA16_1==LEFTPAREN) ) {
					alt16=2;
				}
				else if ( ((LA16_1 >= COMMA && LA16_1 <= CROSSPRODUCT)||LA16_1==DIV||(LA16_1 >= MINUS && LA16_1 <= MUL)||LA16_1==PLUS||(LA16_1 >= RIGHTPAREN && LA16_1 <= SEMICOLON)) ) {
					alt16=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 16, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA16_0==LEFTPAREN) ) {
				alt16=3;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// PrePro.g:75:9: IDENTIFIER
					{
					match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_factor295); 
					}
					break;
				case 2 :
					// PrePro.g:75:22: functionCallStatement
					{
					pushFollow(FOLLOW_functionCallStatement_in_factor299);
					functionCallStatement();
					state._fsp--;

					}
					break;
				case 3 :
					// PrePro.g:75:46: ( LEFTPAREN expression RIGHTPAREN )
					{
					// PrePro.g:75:46: ( LEFTPAREN expression RIGHTPAREN )
					// PrePro.g:75:47: LEFTPAREN expression RIGHTPAREN
					{
					match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_factor304); 
					pushFollow(FOLLOW_expression_in_factor306);
					expression();
					state._fsp--;

					match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_factor308); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "factor"

	// Delegated rules



	public static final BitSet FOLLOW_mainFunction_in_prepro37 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_function_in_prepro41 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_EOF_in_prepro45 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_in_mainFunction52 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_MAIN_in_mainFunction54 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LEFTPAREN_in_mainFunction56 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_mainFunction58 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_LEFTBRACE_in_mainFunction60 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_IMPORT_in_mainFunction62 = new BitSet(new long[]{0x000000000A000000L});
	public static final BitSet FOLLOW_functionArguments_in_mainFunction64 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_mainFunction66 = new BitSet(new long[]{0x0000000008104A40L});
	public static final BitSet FOLLOW_statement_in_mainFunction68 = new BitSet(new long[]{0x0000000008104A40L});
	public static final BitSet FOLLOW_EXPORT_in_mainFunction71 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_exportDefinitions_in_mainFunction73 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_mainFunction75 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_RIGHTBRACE_in_mainFunction77 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_exportDefinitions84 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_COMMA_in_exportDefinitions87 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_IDENTIFIER_in_exportDefinitions89 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_FUNCTION_in_function98 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_IDENTIFIER_in_function100 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LEFTPAREN_in_function102 = new BitSet(new long[]{0x0000000009000000L});
	public static final BitSet FOLLOW_functionArguments_in_function104 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_function106 = new BitSet(new long[]{0x0000000000402000L});
	public static final BitSet FOLLOW_RETURNS_in_function109 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_TYPE_in_function111 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_LEFTBRACE_in_function115 = new BitSet(new long[]{0x0000000008B04840L});
	public static final BitSet FOLLOW_statement_in_function117 = new BitSet(new long[]{0x0000000008B04840L});
	public static final BitSet FOLLOW_RETURN_in_function121 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_expression_in_function123 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_function125 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_RIGHTBRACE_in_function129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_in_functionArguments137 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_IDENTIFIER_in_functionArguments139 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_COMMA_in_functionArguments142 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_TYPE_in_functionArguments144 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_IDENTIFIER_in_functionArguments146 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_assignStatement_in_statement158 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_printStatement_in_statement162 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_debugStatement_in_statement166 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_expression_in_statement170 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_statement173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_in_assignStatement180 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_IDENTIFIER_in_assignStatement183 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_EQUALS_in_assignStatement185 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_expression_in_assignStatement187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_functionCallStatement194 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LEFTPAREN_in_functionCallStatement196 = new BitSet(new long[]{0x0000000001004800L});
	public static final BitSet FOLLOW_expression_in_functionCallStatement199 = new BitSet(new long[]{0x0000000001000010L});
	public static final BitSet FOLLOW_COMMA_in_functionCallStatement202 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_expression_in_functionCallStatement204 = new BitSet(new long[]{0x0000000001000010L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_functionCallStatement210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_printStatement217 = new BitSet(new long[]{0x0000000004004800L});
	public static final BitSet FOLLOW_expression_in_printStatement220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_printStatement224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEBUG_in_debugStatement232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_expression239 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_PLUS_in_expression243 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_term_in_expression245 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_MINUS_in_expression251 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_term_in_expression253 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_factor_in_term263 = new BitSet(new long[]{0x00000000000200A2L});
	public static final BitSet FOLLOW_MUL_in_term267 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_factor_in_term269 = new BitSet(new long[]{0x00000000000200A2L});
	public static final BitSet FOLLOW_DIV_in_term275 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_factor_in_term277 = new BitSet(new long[]{0x00000000000200A2L});
	public static final BitSet FOLLOW_CROSSPRODUCT_in_term283 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_factor_in_term285 = new BitSet(new long[]{0x00000000000200A2L});
	public static final BitSet FOLLOW_IDENTIFIER_in_factor295 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_functionCallStatement_in_factor299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTPAREN_in_factor304 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_expression_in_factor306 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_factor308 = new BitSet(new long[]{0x0000000000000002L});
}
