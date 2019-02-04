// $ANTLR 3.5.2 PrePro.g 2019-02-04 10:48:35

package de.sbernauer.prepro.plugin.syntaxhighlighting.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PreProLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public PreProLexer() {} 
	public PreProLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public PreProLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "PrePro.g"; }

	// $ANTLR start "FUNCTION"
	public final void mFUNCTION() throws RecognitionException {
		try {
			int _type = FUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:79:9: ( 'function' )
			// PrePro.g:79:11: 'function'
			{
			match("function"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUNCTION"

	// $ANTLR start "MAIN"
	public final void mMAIN() throws RecognitionException {
		try {
			int _type = MAIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:80:5: ( 'main' )
			// PrePro.g:80:7: 'main'
			{
			match("main"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAIN"

	// $ANTLR start "LEFTPAREN"
	public final void mLEFTPAREN() throws RecognitionException {
		try {
			int _type = LEFTPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:81:11: ( '(' )
			// PrePro.g:81:13: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFTPAREN"

	// $ANTLR start "RIGHTPAREN"
	public final void mRIGHTPAREN() throws RecognitionException {
		try {
			int _type = RIGHTPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:82:12: ( ')' )
			// PrePro.g:82:14: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHTPAREN"

	// $ANTLR start "LEFTBRACE"
	public final void mLEFTBRACE() throws RecognitionException {
		try {
			int _type = LEFTBRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:83:11: ( '{' )
			// PrePro.g:83:13: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFTBRACE"

	// $ANTLR start "RIGHTBRACE"
	public final void mRIGHTBRACE() throws RecognitionException {
		try {
			int _type = RIGHTBRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:84:12: ( '}' )
			// PrePro.g:84:14: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHTBRACE"

	// $ANTLR start "IMPORT"
	public final void mIMPORT() throws RecognitionException {
		try {
			int _type = IMPORT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:85:7: ( 'import' )
			// PrePro.g:85:9: 'import'
			{
			match("import"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IMPORT"

	// $ANTLR start "EXPORT"
	public final void mEXPORT() throws RecognitionException {
		try {
			int _type = EXPORT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:86:7: ( 'export' )
			// PrePro.g:86:9: 'export'
			{
			match("export"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXPORT"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:87:10: ( ';' )
			// PrePro.g:87:12: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:88:6: ( ',' )
			// PrePro.g:88:8: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:89:7: ( 'return' )
			// PrePro.g:89:9: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN"

	// $ANTLR start "RETURNS"
	public final void mRETURNS() throws RecognitionException {
		try {
			int _type = RETURNS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:90:8: ( 'returns' )
			// PrePro.g:90:10: 'returns'
			{
			match("returns"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURNS"

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:91:6: ( 'print' )
			// PrePro.g:91:8: 'print'
			{
			match("print"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINT"

	// $ANTLR start "EQUALS"
	public final void mEQUALS() throws RecognitionException {
		try {
			int _type = EQUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:92:7: ( '=' )
			// PrePro.g:92:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUALS"

	// $ANTLR start "DEBUG"
	public final void mDEBUG() throws RecognitionException {
		try {
			int _type = DEBUG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:93:6: ( 'debug' )
			// PrePro.g:93:8: 'debug'
			{
			match("debug"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEBUG"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:94:5: ( '+' )
			// PrePro.g:94:7: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:95:6: ( '-' )
			// PrePro.g:95:8: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MUL"
	public final void mMUL() throws RecognitionException {
		try {
			int _type = MUL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:96:4: ( '*' )
			// PrePro.g:96:6: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MUL"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:97:4: ( '/' )
			// PrePro.g:97:6: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "CROSSPRODUCT"
	public final void mCROSSPRODUCT() throws RecognitionException {
		try {
			int _type = CROSSPRODUCT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:98:13: ( 'X' )
			// PrePro.g:98:15: 'X'
			{
			match('X'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CROSSPRODUCT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:100:3: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// PrePro.g:100:5: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
			// PrePro.g:100:5: ( ' ' | '\\t' | '\\r' | '\\n' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||LA1_0=='\r'||LA1_0==' ') ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// PrePro.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "TYPE"
	public final void mTYPE() throws RecognitionException {
		try {
			int _type = TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:102:6: ( 'vec3' | 'vec4' | 'mat' | 'mat3' | 'mat4' | 'scal' | 'const' )
			int alt2=7;
			switch ( input.LA(1) ) {
			case 'v':
				{
				int LA2_1 = input.LA(2);
				if ( (LA2_1=='e') ) {
					int LA2_5 = input.LA(3);
					if ( (LA2_5=='c') ) {
						int LA2_7 = input.LA(4);
						if ( (LA2_7=='3') ) {
							alt2=1;
						}
						else if ( (LA2_7=='4') ) {
							alt2=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 7, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'm':
				{
				int LA2_2 = input.LA(2);
				if ( (LA2_2=='a') ) {
					int LA2_6 = input.LA(3);
					if ( (LA2_6=='t') ) {
						switch ( input.LA(4) ) {
						case '3':
							{
							alt2=4;
							}
							break;
						case '4':
							{
							alt2=5;
							}
							break;
						default:
							alt2=3;
						}
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 6, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 's':
				{
				alt2=6;
				}
				break;
			case 'c':
				{
				alt2=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// PrePro.g:102:8: 'vec3'
					{
					match("vec3"); 

					}
					break;
				case 2 :
					// PrePro.g:102:17: 'vec4'
					{
					match("vec4"); 

					}
					break;
				case 3 :
					// PrePro.g:102:26: 'mat'
					{
					match("mat"); 

					}
					break;
				case 4 :
					// PrePro.g:102:34: 'mat3'
					{
					match("mat3"); 

					}
					break;
				case 5 :
					// PrePro.g:102:43: 'mat4'
					{
					match("mat4"); 

					}
					break;
				case 6 :
					// PrePro.g:102:52: 'scal'
					{
					match("scal"); 

					}
					break;
				case 7 :
					// PrePro.g:102:61: 'const'
					{
					match("const"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPE"

	// $ANTLR start "STRING_LITERAL"
	public final void mSTRING_LITERAL() throws RecognitionException {
		try {
			int _type = STRING_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:103:16: ( '\"' (~ ( '\"' | '\\\\' | '\\r' | '\\n' ) )* '\"' )
			// PrePro.g:103:18: '\"' (~ ( '\"' | '\\\\' | '\\r' | '\\n' ) )* '\"'
			{
			match('\"'); 
			// PrePro.g:103:22: (~ ( '\"' | '\\\\' | '\\r' | '\\n' ) )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '[')||(LA3_0 >= ']' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// PrePro.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING_LITERAL"

	// $ANTLR start "NUMERIC_LITERAL"
	public final void mNUMERIC_LITERAL() throws RecognitionException {
		try {
			int _type = NUMERIC_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:104:17: ( ( '-' )? ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( '.' ( '0' .. '9' )* )? )
			// PrePro.g:104:19: ( '-' )? ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( '.' ( '0' .. '9' )* )?
			{
			// PrePro.g:104:19: ( '-' )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='-') ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// PrePro.g:104:19: '-'
					{
					match('-'); 
					}
					break;

			}

			// PrePro.g:104:24: ( '0' | '1' .. '9' ( '0' .. '9' )* )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='0') ) {
				alt6=1;
			}
			else if ( ((LA6_0 >= '1' && LA6_0 <= '9')) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// PrePro.g:104:25: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// PrePro.g:104:31: '1' .. '9' ( '0' .. '9' )*
					{
					matchRange('1','9'); 
					// PrePro.g:104:40: ( '0' .. '9' )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// PrePro.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop5;
						}
					}

					}
					break;

			}

			// PrePro.g:104:51: ( '.' ( '0' .. '9' )* )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='.') ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// PrePro.g:104:52: '.' ( '0' .. '9' )*
					{
					match('.'); 
					// PrePro.g:104:56: ( '0' .. '9' )*
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// PrePro.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
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

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMERIC_LITERAL"

	// $ANTLR start "IDENTIFIER"
	public final void mIDENTIFIER() throws RecognitionException {
		try {
			int _type = IDENTIFIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PrePro.g:105:12: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '$' ) ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '$' ) | '0' .. '9' )* )
			// PrePro.g:105:14: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '$' ) ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '$' ) | '0' .. '9' )*
			{
			if ( input.LA(1)=='$'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// PrePro.g:105:48: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '$' ) | '0' .. '9' )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0=='$'||(LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// PrePro.g:
					{
					if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop9;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENTIFIER"

	@Override
	public void mTokens() throws RecognitionException {
		// PrePro.g:1:8: ( FUNCTION | MAIN | LEFTPAREN | RIGHTPAREN | LEFTBRACE | RIGHTBRACE | IMPORT | EXPORT | SEMICOLON | COMMA | RETURN | RETURNS | PRINT | EQUALS | DEBUG | PLUS | MINUS | MUL | DIV | CROSSPRODUCT | WS | TYPE | STRING_LITERAL | NUMERIC_LITERAL | IDENTIFIER )
		int alt10=25;
		alt10 = dfa10.predict(input);
		switch (alt10) {
			case 1 :
				// PrePro.g:1:10: FUNCTION
				{
				mFUNCTION(); 

				}
				break;
			case 2 :
				// PrePro.g:1:19: MAIN
				{
				mMAIN(); 

				}
				break;
			case 3 :
				// PrePro.g:1:24: LEFTPAREN
				{
				mLEFTPAREN(); 

				}
				break;
			case 4 :
				// PrePro.g:1:34: RIGHTPAREN
				{
				mRIGHTPAREN(); 

				}
				break;
			case 5 :
				// PrePro.g:1:45: LEFTBRACE
				{
				mLEFTBRACE(); 

				}
				break;
			case 6 :
				// PrePro.g:1:55: RIGHTBRACE
				{
				mRIGHTBRACE(); 

				}
				break;
			case 7 :
				// PrePro.g:1:66: IMPORT
				{
				mIMPORT(); 

				}
				break;
			case 8 :
				// PrePro.g:1:73: EXPORT
				{
				mEXPORT(); 

				}
				break;
			case 9 :
				// PrePro.g:1:80: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 10 :
				// PrePro.g:1:90: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 11 :
				// PrePro.g:1:96: RETURN
				{
				mRETURN(); 

				}
				break;
			case 12 :
				// PrePro.g:1:103: RETURNS
				{
				mRETURNS(); 

				}
				break;
			case 13 :
				// PrePro.g:1:111: PRINT
				{
				mPRINT(); 

				}
				break;
			case 14 :
				// PrePro.g:1:117: EQUALS
				{
				mEQUALS(); 

				}
				break;
			case 15 :
				// PrePro.g:1:124: DEBUG
				{
				mDEBUG(); 

				}
				break;
			case 16 :
				// PrePro.g:1:130: PLUS
				{
				mPLUS(); 

				}
				break;
			case 17 :
				// PrePro.g:1:135: MINUS
				{
				mMINUS(); 

				}
				break;
			case 18 :
				// PrePro.g:1:141: MUL
				{
				mMUL(); 

				}
				break;
			case 19 :
				// PrePro.g:1:145: DIV
				{
				mDIV(); 

				}
				break;
			case 20 :
				// PrePro.g:1:149: CROSSPRODUCT
				{
				mCROSSPRODUCT(); 

				}
				break;
			case 21 :
				// PrePro.g:1:162: WS
				{
				mWS(); 

				}
				break;
			case 22 :
				// PrePro.g:1:165: TYPE
				{
				mTYPE(); 

				}
				break;
			case 23 :
				// PrePro.g:1:170: STRING_LITERAL
				{
				mSTRING_LITERAL(); 

				}
				break;
			case 24 :
				// PrePro.g:1:185: NUMERIC_LITERAL
				{
				mNUMERIC_LITERAL(); 

				}
				break;
			case 25 :
				// PrePro.g:1:201: IDENTIFIER
				{
				mIDENTIFIER(); 

				}
				break;

		}
	}


	protected DFA10 dfa10 = new DFA10(this);
	static final String DFA10_eotS =
		"\1\uffff\2\32\4\uffff\2\32\2\uffff\2\32\1\uffff\1\32\1\uffff\1\42\2\uffff"+
		"\1\43\1\uffff\3\32\3\uffff\7\32\2\uffff\5\32\1\66\11\32\1\101\2\66\1\uffff"+
		"\5\32\3\66\2\32\1\uffff\3\32\1\114\1\115\1\66\1\32\1\117\1\120\1\122\2"+
		"\uffff\1\32\2\uffff\1\124\1\uffff\1\125\2\uffff";
	static final String DFA10_eofS =
		"\126\uffff";
	static final String DFA10_minS =
		"\1\11\1\165\1\141\4\uffff\1\155\1\170\2\uffff\1\145\1\162\1\uffff\1\145"+
		"\1\uffff\1\60\2\uffff\1\44\1\uffff\1\145\1\143\1\157\3\uffff\1\156\1\151"+
		"\2\160\1\164\1\151\1\142\2\uffff\1\143\1\141\1\156\1\143\1\156\1\44\2"+
		"\157\1\165\1\156\1\165\1\63\1\154\1\163\1\164\3\44\1\uffff\3\162\1\164"+
		"\1\147\3\44\1\164\1\151\1\uffff\2\164\1\156\3\44\1\157\3\44\2\uffff\1"+
		"\156\2\uffff\1\44\1\uffff\1\44\2\uffff";
	static final String DFA10_maxS =
		"\1\175\1\165\1\141\4\uffff\1\155\1\170\2\uffff\1\145\1\162\1\uffff\1\145"+
		"\1\uffff\1\71\2\uffff\1\172\1\uffff\1\145\1\143\1\157\3\uffff\1\156\1"+
		"\164\2\160\1\164\1\151\1\142\2\uffff\1\143\1\141\1\156\1\143\1\156\1\172"+
		"\2\157\1\165\1\156\1\165\1\64\1\154\1\163\1\164\3\172\1\uffff\3\162\1"+
		"\164\1\147\3\172\1\164\1\151\1\uffff\2\164\1\156\3\172\1\157\3\172\2\uffff"+
		"\1\156\2\uffff\1\172\1\uffff\1\172\2\uffff";
	static final String DFA10_acceptS =
		"\3\uffff\1\3\1\4\1\5\1\6\2\uffff\1\11\1\12\2\uffff\1\16\1\uffff\1\20\1"+
		"\uffff\1\22\1\23\1\uffff\1\25\3\uffff\1\27\1\30\1\31\7\uffff\1\21\1\24"+
		"\22\uffff\1\26\12\uffff\1\2\12\uffff\1\15\1\17\1\uffff\1\7\1\10\1\uffff"+
		"\1\13\1\uffff\1\14\1\1";
	static final String DFA10_specialS =
		"\126\uffff}>";
	static final String[] DFA10_transitionS = {
			"\2\24\2\uffff\1\24\22\uffff\1\24\1\uffff\1\30\1\uffff\1\32\3\uffff\1"+
			"\3\1\4\1\21\1\17\1\12\1\20\1\uffff\1\22\12\31\1\uffff\1\11\1\uffff\1"+
			"\15\3\uffff\27\32\1\23\2\32\4\uffff\1\32\1\uffff\2\32\1\27\1\16\1\10"+
			"\1\1\2\32\1\7\3\32\1\2\2\32\1\14\1\32\1\13\1\26\2\32\1\25\4\32\1\5\1"+
			"\uffff\1\6",
			"\1\33",
			"\1\34",
			"",
			"",
			"",
			"",
			"\1\35",
			"\1\36",
			"",
			"",
			"\1\37",
			"\1\40",
			"",
			"\1\41",
			"",
			"\12\31",
			"",
			"",
			"\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"\1\44",
			"\1\45",
			"\1\46",
			"",
			"",
			"",
			"\1\47",
			"\1\50\12\uffff\1\51",
			"\1\52",
			"\1\53",
			"\1\54",
			"\1\55",
			"\1\56",
			"",
			"",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"\1\32\13\uffff\3\32\1\64\1\65\5\32\7\uffff\32\32\4\uffff\1\32\1\uffff"+
			"\32\32",
			"\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\107",
			"\1\110",
			"",
			"\1\111",
			"\1\112",
			"\1\113",
			"\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\116",
			"\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\22\32\1\121"+
			"\7\32",
			"",
			"",
			"\1\123",
			"",
			"",
			"\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			""
	};

	static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
	static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
	static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
	static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
	static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
	static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
	static final short[][] DFA10_transition;

	static {
		int numStates = DFA10_transitionS.length;
		DFA10_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
		}
	}

	protected class DFA10 extends DFA {

		public DFA10(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 10;
			this.eot = DFA10_eot;
			this.eof = DFA10_eof;
			this.min = DFA10_min;
			this.max = DFA10_max;
			this.accept = DFA10_accept;
			this.special = DFA10_special;
			this.transition = DFA10_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( FUNCTION | MAIN | LEFTPAREN | RIGHTPAREN | LEFTBRACE | RIGHTBRACE | IMPORT | EXPORT | SEMICOLON | COMMA | RETURN | RETURNS | PRINT | EQUALS | DEBUG | PLUS | MINUS | MUL | DIV | CROSSPRODUCT | WS | TYPE | STRING_LITERAL | NUMERIC_LITERAL | IDENTIFIER );";
		}
	}

}
