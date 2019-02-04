// $ANTLR 3.5.2 PrePro.g 2019-02-04 10:48:35

package de.sbernauer.prepro.plugin.syntaxhighlighting.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

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
	// PrePro.g:42:1: prepro options {backtrack=true; } : ( ( ( mainFunction | function )* ) | ( ( IMPORT functionArguments SEMICOLON )? ( statement )* ( EXPORT exportDefinitions SEMICOLON )? ( function )* ) EOF );
	public final void prepro() throws RecognitionException {
		try {
			// PrePro.g:42:33: ( ( ( mainFunction | function )* ) | ( ( IMPORT functionArguments SEMICOLON )? ( statement )* ( EXPORT exportDefinitions SEMICOLON )? ( function )* ) EOF )
			int alt6=2;
			switch ( input.LA(1) ) {
			case FUNCTION:
				{
				int LA6_1 = input.LA(2);
				if ( (synpred1_PrePro()) ) {
					alt6=1;
				}
				else if ( (true) ) {
					alt6=2;
				}

				}
				break;
			case EOF:
				{
				int LA6_2 = input.LA(2);
				if ( (synpred1_PrePro()) ) {
					alt6=1;
				}
				else if ( (true) ) {
					alt6=2;
				}

				}
				break;
			case DEBUG:
			case EXPORT:
			case IDENTIFIER:
			case IMPORT:
			case LEFTPAREN:
			case NUMERIC_LITERAL:
			case PRINT:
			case TYPE:
				{
				alt6=2;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// PrePro.g:42:35: ( ( mainFunction | function )* )
					{
					// PrePro.g:42:35: ( ( mainFunction | function )* )
					// PrePro.g:42:36: ( mainFunction | function )*
					{
					// PrePro.g:42:36: ( mainFunction | function )*
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
							// PrePro.g:42:37: mainFunction
							{
							pushFollow(FOLLOW_mainFunction_in_prepro45);
							mainFunction();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							// PrePro.g:42:52: function
							{
							pushFollow(FOLLOW_function_in_prepro49);
							function();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							break loop1;
						}
					}

					}

					}
					break;
				case 2 :
					// PrePro.g:43:3: ( ( IMPORT functionArguments SEMICOLON )? ( statement )* ( EXPORT exportDefinitions SEMICOLON )? ( function )* ) EOF
					{
					// PrePro.g:43:3: ( ( IMPORT functionArguments SEMICOLON )? ( statement )* ( EXPORT exportDefinitions SEMICOLON )? ( function )* )
					// PrePro.g:43:4: ( IMPORT functionArguments SEMICOLON )? ( statement )* ( EXPORT exportDefinitions SEMICOLON )? ( function )*
					{
					// PrePro.g:43:4: ( IMPORT functionArguments SEMICOLON )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==IMPORT) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// PrePro.g:43:5: IMPORT functionArguments SEMICOLON
							{
							match(input,IMPORT,FOLLOW_IMPORT_in_prepro59); if (state.failed) return;
							pushFollow(FOLLOW_functionArguments_in_prepro61);
							functionArguments();
							state._fsp--;
							if (state.failed) return;
							match(input,SEMICOLON,FOLLOW_SEMICOLON_in_prepro63); if (state.failed) return;
							}
							break;

					}

					// PrePro.g:43:42: ( statement )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==DEBUG||LA3_0==IDENTIFIER||LA3_0==LEFTPAREN||LA3_0==NUMERIC_LITERAL||LA3_0==PRINT||LA3_0==TYPE) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// PrePro.g:43:42: statement
							{
							pushFollow(FOLLOW_statement_in_prepro67);
							statement();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							break loop3;
						}
					}

					// PrePro.g:43:53: ( EXPORT exportDefinitions SEMICOLON )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==EXPORT) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// PrePro.g:43:54: EXPORT exportDefinitions SEMICOLON
							{
							match(input,EXPORT,FOLLOW_EXPORT_in_prepro71); if (state.failed) return;
							pushFollow(FOLLOW_exportDefinitions_in_prepro73);
							exportDefinitions();
							state._fsp--;
							if (state.failed) return;
							match(input,SEMICOLON,FOLLOW_SEMICOLON_in_prepro75); if (state.failed) return;
							}
							break;

					}

					// PrePro.g:43:91: ( function )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==FUNCTION) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// PrePro.g:43:91: function
							{
							pushFollow(FOLLOW_function_in_prepro79);
							function();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							break loop5;
						}
					}

					}

					match(input,EOF,FOLLOW_EOF_in_prepro83); if (state.failed) return;
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
	// $ANTLR end "prepro"



	// $ANTLR start "mainFunction"
	// PrePro.g:46:1: mainFunction : FUNCTION MAIN LEFTPAREN RIGHTPAREN LEFTBRACE IMPORT functionArguments SEMICOLON ( statement )* EXPORT exportDefinitions SEMICOLON RIGHTBRACE ;
	public final void mainFunction() throws RecognitionException {
		try {
			// PrePro.g:46:13: ( FUNCTION MAIN LEFTPAREN RIGHTPAREN LEFTBRACE IMPORT functionArguments SEMICOLON ( statement )* EXPORT exportDefinitions SEMICOLON RIGHTBRACE )
			// PrePro.g:46:15: FUNCTION MAIN LEFTPAREN RIGHTPAREN LEFTBRACE IMPORT functionArguments SEMICOLON ( statement )* EXPORT exportDefinitions SEMICOLON RIGHTBRACE
			{
			match(input,FUNCTION,FOLLOW_FUNCTION_in_mainFunction90); if (state.failed) return;
			match(input,MAIN,FOLLOW_MAIN_in_mainFunction92); if (state.failed) return;
			match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_mainFunction94); if (state.failed) return;
			match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_mainFunction96); if (state.failed) return;
			match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_mainFunction98); if (state.failed) return;
			match(input,IMPORT,FOLLOW_IMPORT_in_mainFunction100); if (state.failed) return;
			pushFollow(FOLLOW_functionArguments_in_mainFunction102);
			functionArguments();
			state._fsp--;
			if (state.failed) return;
			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mainFunction104); if (state.failed) return;
			// PrePro.g:48:1: ( statement )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==DEBUG||LA7_0==IDENTIFIER||LA7_0==LEFTPAREN||LA7_0==NUMERIC_LITERAL||LA7_0==PRINT||LA7_0==TYPE) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// PrePro.g:48:1: statement
					{
					pushFollow(FOLLOW_statement_in_mainFunction106);
					statement();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop7;
				}
			}

			match(input,EXPORT,FOLLOW_EXPORT_in_mainFunction109); if (state.failed) return;
			pushFollow(FOLLOW_exportDefinitions_in_mainFunction111);
			exportDefinitions();
			state._fsp--;
			if (state.failed) return;
			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mainFunction113); if (state.failed) return;
			match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_mainFunction115); if (state.failed) return;
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
	// PrePro.g:52:1: exportDefinitions : IDENTIFIER ( COMMA IDENTIFIER )* ;
	public final void exportDefinitions() throws RecognitionException {
		try {
			// PrePro.g:52:18: ( IDENTIFIER ( COMMA IDENTIFIER )* )
			// PrePro.g:52:20: IDENTIFIER ( COMMA IDENTIFIER )*
			{
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_exportDefinitions122); if (state.failed) return;
			// PrePro.g:52:31: ( COMMA IDENTIFIER )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==COMMA) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// PrePro.g:52:32: COMMA IDENTIFIER
					{
					match(input,COMMA,FOLLOW_COMMA_in_exportDefinitions125); if (state.failed) return;
					match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_exportDefinitions127); if (state.failed) return;
					}
					break;

				default :
					break loop8;
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
	// PrePro.g:54:1: function : FUNCTION IDENTIFIER LEFTPAREN functionArguments RIGHTPAREN ( RETURNS TYPE )? LEFTBRACE ( statement )* ( RETURN expression SEMICOLON )? RIGHTBRACE ;
	public final void function() throws RecognitionException {
		try {
			// PrePro.g:54:9: ( FUNCTION IDENTIFIER LEFTPAREN functionArguments RIGHTPAREN ( RETURNS TYPE )? LEFTBRACE ( statement )* ( RETURN expression SEMICOLON )? RIGHTBRACE )
			// PrePro.g:54:11: FUNCTION IDENTIFIER LEFTPAREN functionArguments RIGHTPAREN ( RETURNS TYPE )? LEFTBRACE ( statement )* ( RETURN expression SEMICOLON )? RIGHTBRACE
			{
			match(input,FUNCTION,FOLLOW_FUNCTION_in_function136); if (state.failed) return;
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function138); if (state.failed) return;
			match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_function140); if (state.failed) return;
			pushFollow(FOLLOW_functionArguments_in_function142);
			functionArguments();
			state._fsp--;
			if (state.failed) return;
			match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_function144); if (state.failed) return;
			// PrePro.g:55:2: ( RETURNS TYPE )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==RETURNS) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// PrePro.g:55:2: RETURNS TYPE
					{
					match(input,RETURNS,FOLLOW_RETURNS_in_function147); if (state.failed) return;
					match(input,TYPE,FOLLOW_TYPE_in_function149); if (state.failed) return;
					}
					break;

			}

			match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_function153); if (state.failed) return;
			// PrePro.g:57:1: ( statement )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==DEBUG||LA10_0==IDENTIFIER||LA10_0==LEFTPAREN||LA10_0==NUMERIC_LITERAL||LA10_0==PRINT||LA10_0==TYPE) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// PrePro.g:57:1: statement
					{
					pushFollow(FOLLOW_statement_in_function155);
					statement();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop10;
				}
			}

			// PrePro.g:58:2: ( RETURN expression SEMICOLON )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==RETURN) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// PrePro.g:58:2: RETURN expression SEMICOLON
					{
					match(input,RETURN,FOLLOW_RETURN_in_function159); if (state.failed) return;
					pushFollow(FOLLOW_expression_in_function161);
					expression();
					state._fsp--;
					if (state.failed) return;
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_function163); if (state.failed) return;
					}
					break;

			}

			match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_function167); if (state.failed) return;
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
	// PrePro.g:61:1: functionArguments : ( TYPE IDENTIFIER ( COMMA TYPE IDENTIFIER )* )? ;
	public final void functionArguments() throws RecognitionException {
		try {
			// PrePro.g:61:18: ( ( TYPE IDENTIFIER ( COMMA TYPE IDENTIFIER )* )? )
			// PrePro.g:61:20: ( TYPE IDENTIFIER ( COMMA TYPE IDENTIFIER )* )?
			{
			// PrePro.g:61:20: ( TYPE IDENTIFIER ( COMMA TYPE IDENTIFIER )* )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==TYPE) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// PrePro.g:61:21: TYPE IDENTIFIER ( COMMA TYPE IDENTIFIER )*
					{
					match(input,TYPE,FOLLOW_TYPE_in_functionArguments175); if (state.failed) return;
					match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionArguments177); if (state.failed) return;
					// PrePro.g:61:37: ( COMMA TYPE IDENTIFIER )*
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0==COMMA) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// PrePro.g:61:38: COMMA TYPE IDENTIFIER
							{
							match(input,COMMA,FOLLOW_COMMA_in_functionArguments180); if (state.failed) return;
							match(input,TYPE,FOLLOW_TYPE_in_functionArguments182); if (state.failed) return;
							match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionArguments184); if (state.failed) return;
							}
							break;

						default :
							break loop12;
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
	// PrePro.g:63:1: statement : ( assignStatement | printStatement | debugStatement | expression ) SEMICOLON ;
	public final void statement() throws RecognitionException {
		try {
			// PrePro.g:63:10: ( ( assignStatement | printStatement | debugStatement | expression ) SEMICOLON )
			// PrePro.g:63:12: ( assignStatement | printStatement | debugStatement | expression ) SEMICOLON
			{
			// PrePro.g:63:12: ( assignStatement | printStatement | debugStatement | expression )
			int alt14=4;
			switch ( input.LA(1) ) {
			case TYPE:
				{
				alt14=1;
				}
				break;
			case IDENTIFIER:
				{
				int LA14_2 = input.LA(2);
				if ( (LA14_2==EQUALS) ) {
					alt14=1;
				}
				else if ( (LA14_2==CROSSPRODUCT||LA14_2==DIV||LA14_2==LEFTPAREN||(LA14_2 >= MINUS && LA14_2 <= MUL)||LA14_2==PLUS||LA14_2==SEMICOLON) ) {
					alt14=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 14, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case PRINT:
				{
				alt14=2;
				}
				break;
			case DEBUG:
				{
				alt14=3;
				}
				break;
			case LEFTPAREN:
			case NUMERIC_LITERAL:
				{
				alt14=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// PrePro.g:63:13: assignStatement
					{
					pushFollow(FOLLOW_assignStatement_in_statement196);
					assignStatement();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PrePro.g:63:31: printStatement
					{
					pushFollow(FOLLOW_printStatement_in_statement200);
					printStatement();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// PrePro.g:63:48: debugStatement
					{
					pushFollow(FOLLOW_debugStatement_in_statement204);
					debugStatement();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 4 :
					// PrePro.g:63:65: expression
					{
					pushFollow(FOLLOW_expression_in_statement208);
					expression();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement211); if (state.failed) return;
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
	// PrePro.g:65:1: assignStatement : ( TYPE )? IDENTIFIER EQUALS expression ;
	public final void assignStatement() throws RecognitionException {
		try {
			// PrePro.g:65:16: ( ( TYPE )? IDENTIFIER EQUALS expression )
			// PrePro.g:65:18: ( TYPE )? IDENTIFIER EQUALS expression
			{
			// PrePro.g:65:18: ( TYPE )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==TYPE) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// PrePro.g:65:18: TYPE
					{
					match(input,TYPE,FOLLOW_TYPE_in_assignStatement218); if (state.failed) return;
					}
					break;

			}

			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assignStatement221); if (state.failed) return;
			match(input,EQUALS,FOLLOW_EQUALS_in_assignStatement223); if (state.failed) return;
			pushFollow(FOLLOW_expression_in_assignStatement225);
			expression();
			state._fsp--;
			if (state.failed) return;
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
	// PrePro.g:67:1: functionCallStatement : IDENTIFIER LEFTPAREN ( expression ( COMMA expression )* )? RIGHTPAREN ;
	public final void functionCallStatement() throws RecognitionException {
		try {
			// PrePro.g:67:22: ( IDENTIFIER LEFTPAREN ( expression ( COMMA expression )* )? RIGHTPAREN )
			// PrePro.g:67:24: IDENTIFIER LEFTPAREN ( expression ( COMMA expression )* )? RIGHTPAREN
			{
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionCallStatement232); if (state.failed) return;
			match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_functionCallStatement234); if (state.failed) return;
			// PrePro.g:67:45: ( expression ( COMMA expression )* )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==IDENTIFIER||LA17_0==LEFTPAREN||LA17_0==NUMERIC_LITERAL) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// PrePro.g:67:46: expression ( COMMA expression )*
					{
					pushFollow(FOLLOW_expression_in_functionCallStatement237);
					expression();
					state._fsp--;
					if (state.failed) return;
					// PrePro.g:67:57: ( COMMA expression )*
					loop16:
					while (true) {
						int alt16=2;
						int LA16_0 = input.LA(1);
						if ( (LA16_0==COMMA) ) {
							alt16=1;
						}

						switch (alt16) {
						case 1 :
							// PrePro.g:67:58: COMMA expression
							{
							match(input,COMMA,FOLLOW_COMMA_in_functionCallStatement240); if (state.failed) return;
							pushFollow(FOLLOW_expression_in_functionCallStatement242);
							expression();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							break loop16;
						}
					}

					}
					break;

			}

			match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_functionCallStatement248); if (state.failed) return;
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
	// PrePro.g:69:1: printStatement : PRINT ( expression | STRING_LITERAL ) ;
	public final void printStatement() throws RecognitionException {
		try {
			// PrePro.g:69:15: ( PRINT ( expression | STRING_LITERAL ) )
			// PrePro.g:69:17: PRINT ( expression | STRING_LITERAL )
			{
			match(input,PRINT,FOLLOW_PRINT_in_printStatement255); if (state.failed) return;
			// PrePro.g:69:23: ( expression | STRING_LITERAL )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==IDENTIFIER||LA18_0==LEFTPAREN||LA18_0==NUMERIC_LITERAL) ) {
				alt18=1;
			}
			else if ( (LA18_0==STRING_LITERAL) ) {
				alt18=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// PrePro.g:69:24: expression
					{
					pushFollow(FOLLOW_expression_in_printStatement258);
					expression();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PrePro.g:69:37: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_printStatement262); if (state.failed) return;
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
	// PrePro.g:71:1: debugStatement : DEBUG ;
	public final void debugStatement() throws RecognitionException {
		try {
			// PrePro.g:71:15: ( DEBUG )
			// PrePro.g:71:17: DEBUG
			{
			match(input,DEBUG,FOLLOW_DEBUG_in_debugStatement270); if (state.failed) return;
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
	// PrePro.g:73:1: expression : term ( ( PLUS term ) | ( MINUS term ) )* ;
	public final void expression() throws RecognitionException {
		try {
			// PrePro.g:73:11: ( term ( ( PLUS term ) | ( MINUS term ) )* )
			// PrePro.g:73:13: term ( ( PLUS term ) | ( MINUS term ) )*
			{
			pushFollow(FOLLOW_term_in_expression277);
			term();
			state._fsp--;
			if (state.failed) return;
			// PrePro.g:73:18: ( ( PLUS term ) | ( MINUS term ) )*
			loop19:
			while (true) {
				int alt19=3;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==PLUS) ) {
					alt19=1;
				}
				else if ( (LA19_0==MINUS) ) {
					alt19=2;
				}

				switch (alt19) {
				case 1 :
					// PrePro.g:73:19: ( PLUS term )
					{
					// PrePro.g:73:19: ( PLUS term )
					// PrePro.g:73:20: PLUS term
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression281); if (state.failed) return;
					pushFollow(FOLLOW_term_in_expression283);
					term();
					state._fsp--;
					if (state.failed) return;
					}

					}
					break;
				case 2 :
					// PrePro.g:73:33: ( MINUS term )
					{
					// PrePro.g:73:33: ( MINUS term )
					// PrePro.g:73:34: MINUS term
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression289); if (state.failed) return;
					pushFollow(FOLLOW_term_in_expression291);
					term();
					state._fsp--;
					if (state.failed) return;
					}

					}
					break;

				default :
					break loop19;
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
	// PrePro.g:75:1: term : factor ( ( MUL factor ) | ( DIV factor ) | ( CROSSPRODUCT factor ) )* ;
	public final void term() throws RecognitionException {
		try {
			// PrePro.g:75:5: ( factor ( ( MUL factor ) | ( DIV factor ) | ( CROSSPRODUCT factor ) )* )
			// PrePro.g:75:7: factor ( ( MUL factor ) | ( DIV factor ) | ( CROSSPRODUCT factor ) )*
			{
			pushFollow(FOLLOW_factor_in_term301);
			factor();
			state._fsp--;
			if (state.failed) return;
			// PrePro.g:75:14: ( ( MUL factor ) | ( DIV factor ) | ( CROSSPRODUCT factor ) )*
			loop20:
			while (true) {
				int alt20=4;
				switch ( input.LA(1) ) {
				case MUL:
					{
					alt20=1;
					}
					break;
				case DIV:
					{
					alt20=2;
					}
					break;
				case CROSSPRODUCT:
					{
					alt20=3;
					}
					break;
				}
				switch (alt20) {
				case 1 :
					// PrePro.g:75:15: ( MUL factor )
					{
					// PrePro.g:75:15: ( MUL factor )
					// PrePro.g:75:16: MUL factor
					{
					match(input,MUL,FOLLOW_MUL_in_term305); if (state.failed) return;
					pushFollow(FOLLOW_factor_in_term307);
					factor();
					state._fsp--;
					if (state.failed) return;
					}

					}
					break;
				case 2 :
					// PrePro.g:75:30: ( DIV factor )
					{
					// PrePro.g:75:30: ( DIV factor )
					// PrePro.g:75:31: DIV factor
					{
					match(input,DIV,FOLLOW_DIV_in_term313); if (state.failed) return;
					pushFollow(FOLLOW_factor_in_term315);
					factor();
					state._fsp--;
					if (state.failed) return;
					}

					}
					break;
				case 3 :
					// PrePro.g:75:45: ( CROSSPRODUCT factor )
					{
					// PrePro.g:75:45: ( CROSSPRODUCT factor )
					// PrePro.g:75:46: CROSSPRODUCT factor
					{
					match(input,CROSSPRODUCT,FOLLOW_CROSSPRODUCT_in_term321); if (state.failed) return;
					pushFollow(FOLLOW_factor_in_term323);
					factor();
					state._fsp--;
					if (state.failed) return;
					}

					}
					break;

				default :
					break loop20;
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
	// PrePro.g:77:1: factor : ( IDENTIFIER | functionCallStatement | ( LEFTPAREN expression RIGHTPAREN ) | NUMERIC_LITERAL );
	public final void factor() throws RecognitionException {
		try {
			// PrePro.g:77:7: ( IDENTIFIER | functionCallStatement | ( LEFTPAREN expression RIGHTPAREN ) | NUMERIC_LITERAL )
			int alt21=4;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
				{
				int LA21_1 = input.LA(2);
				if ( (LA21_1==LEFTPAREN) ) {
					alt21=2;
				}
				else if ( ((LA21_1 >= COMMA && LA21_1 <= CROSSPRODUCT)||LA21_1==DIV||(LA21_1 >= MINUS && LA21_1 <= MUL)||LA21_1==PLUS||(LA21_1 >= RIGHTPAREN && LA21_1 <= SEMICOLON)) ) {
					alt21=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 21, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case LEFTPAREN:
				{
				alt21=3;
				}
				break;
			case NUMERIC_LITERAL:
				{
				alt21=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// PrePro.g:77:9: IDENTIFIER
					{
					match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_factor333); if (state.failed) return;
					}
					break;
				case 2 :
					// PrePro.g:77:22: functionCallStatement
					{
					pushFollow(FOLLOW_functionCallStatement_in_factor337);
					functionCallStatement();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// PrePro.g:77:46: ( LEFTPAREN expression RIGHTPAREN )
					{
					// PrePro.g:77:46: ( LEFTPAREN expression RIGHTPAREN )
					// PrePro.g:77:47: LEFTPAREN expression RIGHTPAREN
					{
					match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_factor342); if (state.failed) return;
					pushFollow(FOLLOW_expression_in_factor344);
					expression();
					state._fsp--;
					if (state.failed) return;
					match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_factor346); if (state.failed) return;
					}

					}
					break;
				case 4 :
					// PrePro.g:77:82: NUMERIC_LITERAL
					{
					match(input,NUMERIC_LITERAL,FOLLOW_NUMERIC_LITERAL_in_factor351); if (state.failed) return;
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

	// $ANTLR start synpred1_PrePro
	public final void synpred1_PrePro_fragment() throws RecognitionException {
		// PrePro.g:42:35: ( ( ( mainFunction | function )* ) )
		// PrePro.g:42:35: ( ( mainFunction | function )* )
		{
		// PrePro.g:42:35: ( ( mainFunction | function )* )
		// PrePro.g:42:36: ( mainFunction | function )*
		{
		// PrePro.g:42:36: ( mainFunction | function )*
		loop22:
		while (true) {
			int alt22=3;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==FUNCTION) ) {
				int LA22_2 = input.LA(2);
				if ( (LA22_2==MAIN) ) {
					alt22=1;
				}
				else if ( (LA22_2==IDENTIFIER) ) {
					alt22=2;
				}

			}

			switch (alt22) {
			case 1 :
				// PrePro.g:42:37: mainFunction
				{
				pushFollow(FOLLOW_mainFunction_in_synpred1_PrePro45);
				mainFunction();
				state._fsp--;
				if (state.failed) return;
				}
				break;
			case 2 :
				// PrePro.g:42:52: function
				{
				pushFollow(FOLLOW_function_in_synpred1_PrePro49);
				function();
				state._fsp--;
				if (state.failed) return;
				}
				break;

			default :
				break loop22;
			}
		}

		}

		}

	}
	// $ANTLR end synpred1_PrePro

	// Delegated rules

	public final boolean synpred1_PrePro() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_PrePro_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_mainFunction_in_prepro45 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_function_in_prepro49 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_IMPORT_in_prepro59 = new BitSet(new long[]{0x000000000A000000L});
	public static final BitSet FOLLOW_functionArguments_in_prepro61 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_prepro63 = new BitSet(new long[]{0x0000000008144E40L});
	public static final BitSet FOLLOW_statement_in_prepro67 = new BitSet(new long[]{0x0000000008144E40L});
	public static final BitSet FOLLOW_EXPORT_in_prepro71 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_exportDefinitions_in_prepro73 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_prepro75 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_function_in_prepro79 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_EOF_in_prepro83 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_in_mainFunction90 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_MAIN_in_mainFunction92 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LEFTPAREN_in_mainFunction94 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_mainFunction96 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_LEFTBRACE_in_mainFunction98 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_IMPORT_in_mainFunction100 = new BitSet(new long[]{0x000000000A000000L});
	public static final BitSet FOLLOW_functionArguments_in_mainFunction102 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_mainFunction104 = new BitSet(new long[]{0x0000000008144A40L});
	public static final BitSet FOLLOW_statement_in_mainFunction106 = new BitSet(new long[]{0x0000000008144A40L});
	public static final BitSet FOLLOW_EXPORT_in_mainFunction109 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_exportDefinitions_in_mainFunction111 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_mainFunction113 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_RIGHTBRACE_in_mainFunction115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_exportDefinitions122 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_COMMA_in_exportDefinitions125 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_IDENTIFIER_in_exportDefinitions127 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_FUNCTION_in_function136 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_IDENTIFIER_in_function138 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LEFTPAREN_in_function140 = new BitSet(new long[]{0x0000000009000000L});
	public static final BitSet FOLLOW_functionArguments_in_function142 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_function144 = new BitSet(new long[]{0x0000000000402000L});
	public static final BitSet FOLLOW_RETURNS_in_function147 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_TYPE_in_function149 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_LEFTBRACE_in_function153 = new BitSet(new long[]{0x0000000008B44840L});
	public static final BitSet FOLLOW_statement_in_function155 = new BitSet(new long[]{0x0000000008B44840L});
	public static final BitSet FOLLOW_RETURN_in_function159 = new BitSet(new long[]{0x0000000000044800L});
	public static final BitSet FOLLOW_expression_in_function161 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_function163 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_RIGHTBRACE_in_function167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_in_functionArguments175 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_IDENTIFIER_in_functionArguments177 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_COMMA_in_functionArguments180 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_TYPE_in_functionArguments182 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_IDENTIFIER_in_functionArguments184 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_assignStatement_in_statement196 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_printStatement_in_statement200 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_debugStatement_in_statement204 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_expression_in_statement208 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_statement211 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_in_assignStatement218 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_IDENTIFIER_in_assignStatement221 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_EQUALS_in_assignStatement223 = new BitSet(new long[]{0x0000000000044800L});
	public static final BitSet FOLLOW_expression_in_assignStatement225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_functionCallStatement232 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LEFTPAREN_in_functionCallStatement234 = new BitSet(new long[]{0x0000000001044800L});
	public static final BitSet FOLLOW_expression_in_functionCallStatement237 = new BitSet(new long[]{0x0000000001000010L});
	public static final BitSet FOLLOW_COMMA_in_functionCallStatement240 = new BitSet(new long[]{0x0000000000044800L});
	public static final BitSet FOLLOW_expression_in_functionCallStatement242 = new BitSet(new long[]{0x0000000001000010L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_functionCallStatement248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_printStatement255 = new BitSet(new long[]{0x0000000004044800L});
	public static final BitSet FOLLOW_expression_in_printStatement258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_printStatement262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEBUG_in_debugStatement270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_expression277 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_PLUS_in_expression281 = new BitSet(new long[]{0x0000000000044800L});
	public static final BitSet FOLLOW_term_in_expression283 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_MINUS_in_expression289 = new BitSet(new long[]{0x0000000000044800L});
	public static final BitSet FOLLOW_term_in_expression291 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_factor_in_term301 = new BitSet(new long[]{0x00000000000200A2L});
	public static final BitSet FOLLOW_MUL_in_term305 = new BitSet(new long[]{0x0000000000044800L});
	public static final BitSet FOLLOW_factor_in_term307 = new BitSet(new long[]{0x00000000000200A2L});
	public static final BitSet FOLLOW_DIV_in_term313 = new BitSet(new long[]{0x0000000000044800L});
	public static final BitSet FOLLOW_factor_in_term315 = new BitSet(new long[]{0x00000000000200A2L});
	public static final BitSet FOLLOW_CROSSPRODUCT_in_term321 = new BitSet(new long[]{0x0000000000044800L});
	public static final BitSet FOLLOW_factor_in_term323 = new BitSet(new long[]{0x00000000000200A2L});
	public static final BitSet FOLLOW_IDENTIFIER_in_factor333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_functionCallStatement_in_factor337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTPAREN_in_factor342 = new BitSet(new long[]{0x0000000000044800L});
	public static final BitSet FOLLOW_expression_in_factor344 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_factor346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMERIC_LITERAL_in_factor351 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mainFunction_in_synpred1_PrePro45 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_function_in_synpred1_PrePro49 = new BitSet(new long[]{0x0000000000000402L});
}
