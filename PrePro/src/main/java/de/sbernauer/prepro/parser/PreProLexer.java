// Generated from src/main/java/de/sbernauer/prepro/parser/PrePro.g4 by ANTLR 4.7.1

package de.sbernauer.prepro.parser;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PreProLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, WS=28, BLOCK_COMMENT=29, LINE_COMMENT=30, 
		TYPE=31, IDENTIFIER=32, STRING_LITERAL=33, NUMERIC_LITERAL=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "WS", "BLOCK_COMMENT", "LINE_COMMENT", "LETTER", "NON_ZERO_DIGIT", 
		"DIGIT", "STRING_CHAR", "TYPE", "IDENTIFIER", "STRING_LITERAL", "NUMERIC_LITERAL"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'function'", "'main'", "'('", "')'", "'{'", "'import'", "';'", 
		"'export'", "'}'", "'optional'", "','", "'returns'", "'return'", "'='", 
		"'print'", "'debug'", "'+'", "'-'", "'*'", "'X'", "'/'", "'=='", "'<='", 
		"'<'", "'>'", "'>='", "'exists'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "WS", "BLOCK_COMMENT", "LINE_COMMENT", "TYPE", 
		"IDENTIFIER", "STRING_LITERAL", "NUMERIC_LITERAL"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public PreProLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PrePro.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u0120\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\6\35\u00bd\n\35\r\35"+
		"\16\35\u00be\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00c7\n\36\f\36\16\36"+
		"\u00ca\13\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u00d5\n"+
		"\37\f\37\16\37\u00d8\13\37\3\37\3\37\3 \5 \u00dd\n \3!\3!\3\"\3\"\3#\3"+
		"#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\5$\u0101\n$\3%\3%\3%\7%\u0106\n%\f%\16%\u0109\13%\3&"+
		"\3&\7&\u010d\n&\f&\16&\u0110\13&\3&\3&\3\'\5\'\u0115\n\'\3\'\3\'\3\'\7"+
		"\'\u011a\n\'\f\'\16\'\u011d\13\'\5\'\u011f\n\'\3\u00c8\2(\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?\2A\2C\2E"+
		"\2G!I\"K#M$\3\2\b\5\2\13\f\16\17\"\"\4\2\f\f\17\17\6\2&&C\\aac|\3\2\63"+
		";\3\2\62;\6\2\f\f\17\17$$^^\2\u012a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2G\3\2\2\2\2I\3\2"+
		"\2\2\2K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2\5X\3\2\2\2\7]\3\2\2\2\t_\3\2\2\2"+
		"\13a\3\2\2\2\rc\3\2\2\2\17j\3\2\2\2\21l\3\2\2\2\23s\3\2\2\2\25u\3\2\2"+
		"\2\27~\3\2\2\2\31\u0080\3\2\2\2\33\u0088\3\2\2\2\35\u008f\3\2\2\2\37\u0091"+
		"\3\2\2\2!\u0097\3\2\2\2#\u009d\3\2\2\2%\u009f\3\2\2\2\'\u00a1\3\2\2\2"+
		")\u00a3\3\2\2\2+\u00a5\3\2\2\2-\u00a7\3\2\2\2/\u00aa\3\2\2\2\61\u00ad"+
		"\3\2\2\2\63\u00af\3\2\2\2\65\u00b1\3\2\2\2\67\u00b4\3\2\2\29\u00bc\3\2"+
		"\2\2;\u00c2\3\2\2\2=\u00d0\3\2\2\2?\u00dc\3\2\2\2A\u00de\3\2\2\2C\u00e0"+
		"\3\2\2\2E\u00e2\3\2\2\2G\u0100\3\2\2\2I\u0102\3\2\2\2K\u010a\3\2\2\2M"+
		"\u0114\3\2\2\2OP\7h\2\2PQ\7w\2\2QR\7p\2\2RS\7e\2\2ST\7v\2\2TU\7k\2\2U"+
		"V\7q\2\2VW\7p\2\2W\4\3\2\2\2XY\7o\2\2YZ\7c\2\2Z[\7k\2\2[\\\7p\2\2\\\6"+
		"\3\2\2\2]^\7*\2\2^\b\3\2\2\2_`\7+\2\2`\n\3\2\2\2ab\7}\2\2b\f\3\2\2\2c"+
		"d\7k\2\2de\7o\2\2ef\7r\2\2fg\7q\2\2gh\7t\2\2hi\7v\2\2i\16\3\2\2\2jk\7"+
		"=\2\2k\20\3\2\2\2lm\7g\2\2mn\7z\2\2no\7r\2\2op\7q\2\2pq\7t\2\2qr\7v\2"+
		"\2r\22\3\2\2\2st\7\177\2\2t\24\3\2\2\2uv\7q\2\2vw\7r\2\2wx\7v\2\2xy\7"+
		"k\2\2yz\7q\2\2z{\7p\2\2{|\7c\2\2|}\7n\2\2}\26\3\2\2\2~\177\7.\2\2\177"+
		"\30\3\2\2\2\u0080\u0081\7t\2\2\u0081\u0082\7g\2\2\u0082\u0083\7v\2\2\u0083"+
		"\u0084\7w\2\2\u0084\u0085\7t\2\2\u0085\u0086\7p\2\2\u0086\u0087\7u\2\2"+
		"\u0087\32\3\2\2\2\u0088\u0089\7t\2\2\u0089\u008a\7g\2\2\u008a\u008b\7"+
		"v\2\2\u008b\u008c\7w\2\2\u008c\u008d\7t\2\2\u008d\u008e\7p\2\2\u008e\34"+
		"\3\2\2\2\u008f\u0090\7?\2\2\u0090\36\3\2\2\2\u0091\u0092\7r\2\2\u0092"+
		"\u0093\7t\2\2\u0093\u0094\7k\2\2\u0094\u0095\7p\2\2\u0095\u0096\7v\2\2"+
		"\u0096 \3\2\2\2\u0097\u0098\7f\2\2\u0098\u0099\7g\2\2\u0099\u009a\7d\2"+
		"\2\u009a\u009b\7w\2\2\u009b\u009c\7i\2\2\u009c\"\3\2\2\2\u009d\u009e\7"+
		"-\2\2\u009e$\3\2\2\2\u009f\u00a0\7/\2\2\u00a0&\3\2\2\2\u00a1\u00a2\7,"+
		"\2\2\u00a2(\3\2\2\2\u00a3\u00a4\7Z\2\2\u00a4*\3\2\2\2\u00a5\u00a6\7\61"+
		"\2\2\u00a6,\3\2\2\2\u00a7\u00a8\7?\2\2\u00a8\u00a9\7?\2\2\u00a9.\3\2\2"+
		"\2\u00aa\u00ab\7>\2\2\u00ab\u00ac\7?\2\2\u00ac\60\3\2\2\2\u00ad\u00ae"+
		"\7>\2\2\u00ae\62\3\2\2\2\u00af\u00b0\7@\2\2\u00b0\64\3\2\2\2\u00b1\u00b2"+
		"\7@\2\2\u00b2\u00b3\7?\2\2\u00b3\66\3\2\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6"+
		"\7z\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7u\2\2\u00b8\u00b9\7v\2\2\u00b9"+
		"\u00ba\7u\2\2\u00ba8\3\2\2\2\u00bb\u00bd\t\2\2\2\u00bc\u00bb\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00c1\b\35\2\2\u00c1:\3\2\2\2\u00c2\u00c3\7\61\2\2\u00c3\u00c4"+
		"\7,\2\2\u00c4\u00c8\3\2\2\2\u00c5\u00c7\13\2\2\2\u00c6\u00c5\3\2\2\2\u00c7"+
		"\u00ca\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cb\3\2"+
		"\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\7,\2\2\u00cc\u00cd\7\61\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\u00cf\b\36\2\2\u00cf<\3\2\2\2\u00d0\u00d1\7\61\2"+
		"\2\u00d1\u00d2\7\61\2\2\u00d2\u00d6\3\2\2\2\u00d3\u00d5\n\3\2\2\u00d4"+
		"\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2"+
		"\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da\b\37\2\2\u00da"+
		">\3\2\2\2\u00db\u00dd\t\4\2\2\u00dc\u00db\3\2\2\2\u00dd@\3\2\2\2\u00de"+
		"\u00df\t\5\2\2\u00dfB\3\2\2\2\u00e0\u00e1\t\6\2\2\u00e1D\3\2\2\2\u00e2"+
		"\u00e3\n\7\2\2\u00e3F\3\2\2\2\u00e4\u00e5\7x\2\2\u00e5\u00e6\7g\2\2\u00e6"+
		"\u00e7\7e\2\2\u00e7\u0101\7\65\2\2\u00e8\u00e9\7x\2\2\u00e9\u00ea\7g\2"+
		"\2\u00ea\u00eb\7e\2\2\u00eb\u0101\7\66\2\2\u00ec\u00ed\7o\2\2\u00ed\u00ee"+
		"\7c\2\2\u00ee\u0101\7v\2\2\u00ef\u00f0\7o\2\2\u00f0\u00f1\7c\2\2\u00f1"+
		"\u00f2\7v\2\2\u00f2\u0101\7\65\2\2\u00f3\u00f4\7o\2\2\u00f4\u00f5\7c\2"+
		"\2\u00f5\u00f6\7v\2\2\u00f6\u0101\7\66\2\2\u00f7\u00f8\7u\2\2\u00f8\u00f9"+
		"\7e\2\2\u00f9\u00fa\7c\2\2\u00fa\u0101\7n\2\2\u00fb\u00fc\7e\2\2\u00fc"+
		"\u00fd\7q\2\2\u00fd\u00fe\7p\2\2\u00fe\u00ff\7u\2\2\u00ff\u0101\7v\2\2"+
		"\u0100\u00e4\3\2\2\2\u0100\u00e8\3\2\2\2\u0100\u00ec\3\2\2\2\u0100\u00ef"+
		"\3\2\2\2\u0100\u00f3\3\2\2\2\u0100\u00f7\3\2\2\2\u0100\u00fb\3\2\2\2\u0101"+
		"H\3\2\2\2\u0102\u0107\5? \2\u0103\u0106\5? \2\u0104\u0106\5C\"\2\u0105"+
		"\u0103\3\2\2\2\u0105\u0104\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2"+
		"\2\2\u0107\u0108\3\2\2\2\u0108J\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010e"+
		"\7$\2\2\u010b\u010d\5E#\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110\u010e\3\2"+
		"\2\2\u0111\u0112\7$\2\2\u0112L\3\2\2\2\u0113\u0115\7/\2\2\u0114\u0113"+
		"\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u011e\3\2\2\2\u0116\u011f\7\62\2\2"+
		"\u0117\u011b\5A!\2\u0118\u011a\5C\"\2\u0119\u0118\3\2\2\2\u011a\u011d"+
		"\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011f\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011e\u0116\3\2\2\2\u011e\u0117\3\2\2\2\u011fN\3\2\2\2"+
		"\16\2\u00be\u00c8\u00d6\u00dc\u0100\u0105\u0107\u010e\u0114\u011b\u011e"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}