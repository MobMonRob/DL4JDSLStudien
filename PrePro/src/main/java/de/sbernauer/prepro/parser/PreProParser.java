// Generated from src/main/java/de/sbernauer/prepro/parser/PrePro.g4 by ANTLR 4.7.1

package de.sbernauer.prepro.parser;

import java.util.Arrays;

import org.nd4j.linalg.factory.Nd4j;

import de.sbernauer.prepro.nodes.*;
import de.sbernauer.prepro.nodes.statement.*;
import de.sbernauer.prepro.nodes.expression.*;
import de.sbernauer.prepro.nodes.expression.arithmetic.*;
import de.sbernauer.prepro.nodes.function.*;
import de.sbernauer.prepro.nodes.debugging.*;
import de.sbernauer.prepro.variables.*;



import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PreProParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, WS=23, BLOCK_COMMENT=24, 
		LINE_COMMENT=25, TYPE=26, IDENTIFIER=27, STRING_LITERAL=28, NUMERIC_LITERAL=29;
	public static final int
		RULE_prepro = 0, RULE_mainFunction = 1, RULE_importDefinitions = 2, RULE_exportDefinitions = 3, 
		RULE_function = 4, RULE_functionArguments = 5, RULE_statement = 6, RULE_assignStatement = 7, 
		RULE_functionCallStatement = 8, RULE_printStatement = 9, RULE_debugStatement = 10, 
		RULE_expression = 11, RULE_term = 12, RULE_factor = 13;
	public static final String[] ruleNames = {
		"prepro", "mainFunction", "importDefinitions", "exportDefinitions", "function", 
		"functionArguments", "statement", "assignStatement", "functionCallStatement", 
		"printStatement", "debugStatement", "expression", "term", "factor"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'function'", "'main'", "'('", "')'", "'{'", "'import'", "';'", 
		"'export'", "'}'", "'optional'", "','", "'returns'", "'return'", "'='", 
		"'print'", "'debug'", "'+'", "'-'", "'*'", "'X'", "'/'", "'exists'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "WS", 
		"BLOCK_COMMENT", "LINE_COMMENT", "TYPE", "IDENTIFIER", "STRING_LITERAL", 
		"NUMERIC_LITERAL"
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

	@Override
	public String getGrammarFileName() { return "PrePro.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	private NodeFactory nodeFactory = new NodeFactory();

	public PreProParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PreproContext extends ParserRuleContext {
		public MainNode result;
		public MainFunctionContext mainFunction;
		public FunctionContext function;
		public TerminalNode EOF() { return getToken(PreProParser.EOF, 0); }
		public List<MainFunctionContext> mainFunction() {
			return getRuleContexts(MainFunctionContext.class);
		}
		public MainFunctionContext mainFunction(int i) {
			return getRuleContext(MainFunctionContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public PreproContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prepro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).enterPrepro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).exitPrepro(this);
		}
	}

	public final PreproContext prepro() throws RecognitionException {
		PreproContext _localctx = new PreproContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prepro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 nodeFactory.startFunctionList();
			                                      MainFunctionNode mainFunctionNode;
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				setState(35);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(29);
					((PreproContext)_localctx).mainFunction = mainFunction();
					 nodeFactory.addFunction(((PreproContext)_localctx).mainFunction.result); 
					}
					break;
				case 2:
					{
					setState(32);
					((PreproContext)_localctx).function = function();
					 nodeFactory.addFunction(((PreproContext)_localctx).function.result); 
					}
					break;
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			match(EOF);
			 ((PreproContext)_localctx).result =  new MainNode(nodeFactory.getFunctionsAsArray()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainFunctionContext extends ParserRuleContext {
		public MainFunctionNode result;
		public ImportDefinitionsContext importDefinitions;
		public StatementContext statement;
		public ExportDefinitionsContext exportDefinitions;
		public ImportDefinitionsContext importDefinitions() {
			return getRuleContext(ImportDefinitionsContext.class,0);
		}
		public ExportDefinitionsContext exportDefinitions() {
			return getRuleContext(ExportDefinitionsContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).enterMainFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).exitMainFunction(this);
		}
	}

	public final MainFunctionContext mainFunction() throws RecognitionException {
		MainFunctionContext _localctx = new MainFunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(T__0);
			 nodeFactory.startStatementList(); 
			setState(45);
			match(T__1);
			setState(46);
			match(T__2);
			setState(47);
			match(T__3);
			setState(48);
			match(T__4);
			setState(49);
			match(T__5);
			setState(50);
			((MainFunctionContext)_localctx).importDefinitions = importDefinitions();
			setState(51);
			match(T__6);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__14) | (1L << T__15) | (1L << T__21) | (1L << TYPE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(52);
				((MainFunctionContext)_localctx).statement = statement();
				 nodeFactory.addStatement(((MainFunctionContext)_localctx).statement.result, (((MainFunctionContext)_localctx).statement!=null?(((MainFunctionContext)_localctx).statement.start):null).getLine()); 
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(T__7);
			setState(61);
			((MainFunctionContext)_localctx).exportDefinitions = exportDefinitions();
			setState(62);
			match(T__6);
			setState(63);
			match(T__8);
			 ((MainFunctionContext)_localctx).result =  new MainFunctionNode("main", ((MainFunctionContext)_localctx).importDefinitions.result, ((MainFunctionContext)_localctx).exportDefinitions.result, new StatementListNode(nodeFactory.getStatementsAsArray())); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportDefinitionsContext extends ParserRuleContext {
		public List<ImportDefinition> result;
		public Token TYPE;
		public Token IDENTIFIER;
		public List<TerminalNode> TYPE() { return getTokens(PreProParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(PreProParser.TYPE, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(PreProParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PreProParser.IDENTIFIER, i);
		}
		public ImportDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDefinitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).enterImportDefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).exitImportDefinitions(this);
		}
	}

	public final ImportDefinitionsContext importDefinitions() throws RecognitionException {
		ImportDefinitionsContext _localctx = new ImportDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDefinitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ImportDefinitionsContext)_localctx).result =  new ArrayList<>(); 
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9 || _la==TYPE) {
				{
				setState(74);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TYPE:
					{
					setState(67);
					((ImportDefinitionsContext)_localctx).TYPE = match(TYPE);
					setState(68);
					((ImportDefinitionsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
					 _localctx.result.add(nodeFactory.createImportDefinition((((ImportDefinitionsContext)_localctx).TYPE!=null?((ImportDefinitionsContext)_localctx).TYPE.getText():null), (((ImportDefinitionsContext)_localctx).IDENTIFIER!=null?((ImportDefinitionsContext)_localctx).IDENTIFIER.getText():null), false)); 
					}
					break;
				case T__9:
					{
					setState(70);
					match(T__9);
					setState(71);
					((ImportDefinitionsContext)_localctx).TYPE = match(TYPE);
					setState(72);
					((ImportDefinitionsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
					 _localctx.result.add(nodeFactory.createImportDefinition((((ImportDefinitionsContext)_localctx).TYPE!=null?((ImportDefinitionsContext)_localctx).TYPE.getText():null), (((ImportDefinitionsContext)_localctx).IDENTIFIER!=null?((ImportDefinitionsContext)_localctx).IDENTIFIER.getText():null), true)); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(85);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						setState(76);
						match(T__10);
						setState(77);
						((ImportDefinitionsContext)_localctx).TYPE = match(TYPE);
						setState(78);
						((ImportDefinitionsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
						 _localctx.result.add(nodeFactory.createImportDefinition((((ImportDefinitionsContext)_localctx).TYPE!=null?((ImportDefinitionsContext)_localctx).TYPE.getText():null), (((ImportDefinitionsContext)_localctx).IDENTIFIER!=null?((ImportDefinitionsContext)_localctx).IDENTIFIER.getText():null), false)); 
						}
						break;
					case 2:
						{
						setState(80);
						match(T__10);
						setState(81);
						match(T__9);
						setState(82);
						((ImportDefinitionsContext)_localctx).TYPE = match(TYPE);
						setState(83);
						((ImportDefinitionsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
						 _localctx.result.add(nodeFactory.createImportDefinition((((ImportDefinitionsContext)_localctx).TYPE!=null?((ImportDefinitionsContext)_localctx).TYPE.getText():null), (((ImportDefinitionsContext)_localctx).IDENTIFIER!=null?((ImportDefinitionsContext)_localctx).IDENTIFIER.getText():null), true)); 
						}
						break;
					}
					}
					}
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExportDefinitionsContext extends ParserRuleContext {
		public List<String> result;
		public Token IDENTIFIER;
		public List<TerminalNode> IDENTIFIER() { return getTokens(PreProParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PreProParser.IDENTIFIER, i);
		}
		public ExportDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exportDefinitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).enterExportDefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).exitExportDefinitions(this);
		}
	}

	public final ExportDefinitionsContext exportDefinitions() throws RecognitionException {
		ExportDefinitionsContext _localctx = new ExportDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_exportDefinitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ExportDefinitionsContext)_localctx).result =  new ArrayList<>(); 
			setState(95);
			((ExportDefinitionsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 _localctx.result.add((((ExportDefinitionsContext)_localctx).IDENTIFIER!=null?((ExportDefinitionsContext)_localctx).IDENTIFIER.getText():null)); 
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(97);
				match(T__10);
				setState(98);
				((ExportDefinitionsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 _localctx.result.add((((ExportDefinitionsContext)_localctx).IDENTIFIER!=null?((ExportDefinitionsContext)_localctx).IDENTIFIER.getText():null)); 
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public FunctionNode result;
		public Token IDENTIFIER;
		public FunctionArgumentsContext functionArguments;
		public Token returnType;
		public StatementContext statement;
		public ExpressionContext returnExpression;
		public TerminalNode IDENTIFIER() { return getToken(PreProParser.IDENTIFIER, 0); }
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode TYPE() { return getToken(PreProParser.TYPE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__0);
			 nodeFactory.startStatementList(); 
			setState(107);
			((FunctionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(108);
			match(T__2);
			setState(109);
			((FunctionContext)_localctx).functionArguments = functionArguments();
			setState(110);
			match(T__3);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(111);
				match(T__11);
				setState(112);
				((FunctionContext)_localctx).returnType = match(TYPE);
				}
			}

			setState(115);
			match(T__4);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__14) | (1L << T__15) | (1L << T__21) | (1L << TYPE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(116);
				((FunctionContext)_localctx).statement = statement();
				 nodeFactory.addStatement(((FunctionContext)_localctx).statement.result, (((FunctionContext)_localctx).statement!=null?(((FunctionContext)_localctx).statement.start):null).getLine()); 
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(124);
				match(T__12);
				setState(125);
				((FunctionContext)_localctx).returnExpression = expression();
				setState(126);
				match(T__6);
				}
			}

			setState(130);
			match(T__8);
			 List<ParameterDefinition> functionArguments = (_localctx.functionArguments == null) ? null : ((FunctionContext)_localctx).functionArguments.result;
			                                      ExpressionNode returnExpression = (_localctx.returnExpression == null) ? null : ((FunctionContext)_localctx).returnExpression.result;
			                                      ((FunctionContext)_localctx).result =  new FunctionNode((((FunctionContext)_localctx).IDENTIFIER!=null?((FunctionContext)_localctx).IDENTIFIER.getText():null), (((FunctionContext)_localctx).returnType!=null?((FunctionContext)_localctx).returnType.getText():null),
			                                      functionArguments, new StatementListNode(nodeFactory.getStatementsAsArray()),
			                                      returnExpression); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgumentsContext extends ParserRuleContext {
		public List<ParameterDefinition> result;
		public Token TYPE;
		public Token IDENTIFIER;
		public List<TerminalNode> TYPE() { return getTokens(PreProParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(PreProParser.TYPE, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(PreProParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PreProParser.IDENTIFIER, i);
		}
		public FunctionArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).enterFunctionArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).exitFunctionArguments(this);
		}
	}

	public final FunctionArgumentsContext functionArguments() throws RecognitionException {
		FunctionArgumentsContext _localctx = new FunctionArgumentsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((FunctionArgumentsContext)_localctx).result =  new ArrayList<>(); 
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(134);
				((FunctionArgumentsContext)_localctx).TYPE = match(TYPE);
				setState(135);
				((FunctionArgumentsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 _localctx.result.add(nodeFactory.createParameterDefinition((((FunctionArgumentsContext)_localctx).TYPE!=null?((FunctionArgumentsContext)_localctx).TYPE.getText():null), (((FunctionArgumentsContext)_localctx).IDENTIFIER!=null?((FunctionArgumentsContext)_localctx).IDENTIFIER.getText():null))); 
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(137);
					match(T__10);
					setState(138);
					((FunctionArgumentsContext)_localctx).TYPE = match(TYPE);
					setState(139);
					((FunctionArgumentsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
					 _localctx.result.add(nodeFactory.createParameterDefinition((((FunctionArgumentsContext)_localctx).TYPE!=null?((FunctionArgumentsContext)_localctx).TYPE.getText():null), (((FunctionArgumentsContext)_localctx).IDENTIFIER!=null?((FunctionArgumentsContext)_localctx).IDENTIFIER.getText():null))); 
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementNode result;
		public AssignStatementContext assignStatement;
		public ExpressionContext expression;
		public PrintStatementContext printStatement;
		public DebugStatementContext debugStatement;
		public AssignStatementContext assignStatement() {
			return getRuleContext(AssignStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public DebugStatementContext debugStatement() {
			return getRuleContext(DebugStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(148);
				((StatementContext)_localctx).assignStatement = assignStatement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).assignStatement.result; 
				}
				break;
			case 2:
				{
				setState(151);
				((StatementContext)_localctx).expression = expression();
				 ((StatementContext)_localctx).result =  new NopStatementNode(((StatementContext)_localctx).expression.result); 
				}
				break;
			case 3:
				{
				setState(154);
				((StatementContext)_localctx).printStatement = printStatement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).printStatement.result; 
				}
				break;
			case 4:
				{
				setState(157);
				((StatementContext)_localctx).debugStatement = debugStatement();
				 ((StatementContext)_localctx).result =  new DebugNode((((StatementContext)_localctx).debugStatement!=null?(((StatementContext)_localctx).debugStatement.start):null).getLine()); 
				}
				break;
			}
			setState(162);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignStatementContext extends ParserRuleContext {
		public AssignStatementNode result;
		public Token TYPE;
		public Token i;
		public ExpressionContext e;
		public TerminalNode IDENTIFIER() { return getToken(PreProParser.IDENTIFIER, 0); }
		public TerminalNode TYPE() { return getToken(PreProParser.TYPE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).enterAssignStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).exitAssignStatement(this);
		}
	}

	public final AssignStatementContext assignStatement() throws RecognitionException {
		AssignStatementContext _localctx = new AssignStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(164);
				((AssignStatementContext)_localctx).TYPE = match(TYPE);
				}
			}

			setState(167);
			((AssignStatementContext)_localctx).i = match(IDENTIFIER);
			setState(168);
			match(T__13);
			{
			setState(169);
			((AssignStatementContext)_localctx).e = expression();
			 ((AssignStatementContext)_localctx).result =  new AssignStatementNode((((AssignStatementContext)_localctx).i!=null?((AssignStatementContext)_localctx).i.getText():null), (((AssignStatementContext)_localctx).TYPE!=null?((AssignStatementContext)_localctx).TYPE.getText():null), ((AssignStatementContext)_localctx).e.result); 
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallStatementContext extends ParserRuleContext {
		public FunctionCallNode result;
		public Token IDENTIFIER;
		public ExpressionContext expression;
		public TerminalNode IDENTIFIER() { return getToken(PreProParser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionCallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).enterFunctionCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).exitFunctionCallStatement(this);
		}
	}

	public final FunctionCallStatementContext functionCallStatement() throws RecognitionException {
		FunctionCallStatementContext _localctx = new FunctionCallStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionCallStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			((FunctionCallStatementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(173);
			match(T__2);
			 List<ExpressionNode> expressionList = new ArrayList<>(); 
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__21) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(175);
				((FunctionCallStatementContext)_localctx).expression = expression();
				 expressionList.add(((FunctionCallStatementContext)_localctx).expression.result); 
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(177);
					match(T__10);
					setState(178);
					((FunctionCallStatementContext)_localctx).expression = expression();
					 expressionList.add(((FunctionCallStatementContext)_localctx).expression.result); 
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(188);
			match(T__3);
			 ((FunctionCallStatementContext)_localctx).result =  new FunctionCallNode((((FunctionCallStatementContext)_localctx).IDENTIFIER!=null?((FunctionCallStatementContext)_localctx).IDENTIFIER.getText():null), expressionList); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementContext extends ParserRuleContext {
		public PrintStatementNode result;
		public ExpressionContext expression;
		public Token STRING_LITERAL;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(PreProParser.STRING_LITERAL, 0); }
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).exitPrintStatement(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(T__14);
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__21:
			case IDENTIFIER:
				{
				setState(192);
				((PrintStatementContext)_localctx).expression = expression();
				 ((PrintStatementContext)_localctx).result =  new PrintStatementNode(((PrintStatementContext)_localctx).expression.result); 
				}
				break;
			case STRING_LITERAL:
				{
				setState(195);
				((PrintStatementContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
				 ((PrintStatementContext)_localctx).result =  new PrintStatementNode((((PrintStatementContext)_localctx).STRING_LITERAL!=null?((PrintStatementContext)_localctx).STRING_LITERAL.getText():null).substring(1, (((PrintStatementContext)_localctx).STRING_LITERAL!=null?((PrintStatementContext)_localctx).STRING_LITERAL.getText():null).length() - 1)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DebugStatementContext extends ParserRuleContext {
		public Token d;
		public DebugStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_debugStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).enterDebugStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).exitDebugStatement(this);
		}
	}

	public final DebugStatementContext debugStatement() throws RecognitionException {
		DebugStatementContext _localctx = new DebugStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_debugStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			((DebugStatementContext)_localctx).d = match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionNode result;
		public TermContext term;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			((ExpressionContext)_localctx).term = term();
			 ((ExpressionContext)_localctx).result =  ((ExpressionContext)_localctx).term.result; 
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16 || _la==T__17) {
				{
				setState(213);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__16:
					{
					{
					setState(203);
					match(T__16);
					setState(204);
					((ExpressionContext)_localctx).term = term();
					}
					 ((ExpressionContext)_localctx).result =  new AddNode(_localctx.result, ((ExpressionContext)_localctx).term.result); 
					}
					break;
				case T__17:
					{
					{
					setState(208);
					match(T__17);
					setState(209);
					((ExpressionContext)_localctx).term = term();
					}
					 ((ExpressionContext)_localctx).result =  new SubNode(_localctx.result, ((ExpressionContext)_localctx).term.result); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public ExpressionNode result;
		public FactorContext factor;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			((TermContext)_localctx).factor = factor();
			 ((TermContext)_localctx).result =  ((TermContext)_localctx).factor.result; 
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) {
				{
				setState(235);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__18:
					{
					{
					setState(220);
					match(T__18);
					setState(221);
					((TermContext)_localctx).factor = factor();
					}
					 ((TermContext)_localctx).result =  new MulNode(_localctx.result, ((TermContext)_localctx).factor.result); 
					}
					break;
				case T__19:
					{
					{
					setState(225);
					match(T__19);
					setState(226);
					((TermContext)_localctx).factor = factor();
					}
					 ((TermContext)_localctx).result =  new CrossProductNode(_localctx.result, ((TermContext)_localctx).factor.result); 
					}
					break;
				case T__20:
					{
					{
					setState(230);
					match(T__20);
					setState(231);
					((TermContext)_localctx).factor = factor();
					}
					 ((TermContext)_localctx).result =  new DivNode(_localctx.result, ((TermContext)_localctx).factor.result); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public ExpressionNode result;
		public Token IDENTIFIER;
		public FunctionCallStatementContext functionCallStatement;
		public ExpressionContext expression;
		public TerminalNode IDENTIFIER() { return getToken(PreProParser.IDENTIFIER, 0); }
		public FunctionCallStatementContext functionCallStatement() {
			return getRuleContext(FunctionCallStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_factor);
		try {
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				((FactorContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 ((FactorContext)_localctx).result =  new VariableConstantNode((((FactorContext)_localctx).IDENTIFIER!=null?((FactorContext)_localctx).IDENTIFIER.getText():null)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				match(T__21);
				setState(243);
				match(T__2);
				setState(244);
				((FactorContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(245);
				match(T__3);
				 ((FactorContext)_localctx).result =  new ExistsNode((((FactorContext)_localctx).IDENTIFIER!=null?((FactorContext)_localctx).IDENTIFIER.getText():null)); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				((FactorContext)_localctx).functionCallStatement = functionCallStatement();
				 ((FactorContext)_localctx).result =  ((FactorContext)_localctx).functionCallStatement.result; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(250);
				match(T__2);
				setState(251);
				((FactorContext)_localctx).expression = expression();
				setState(252);
				match(T__3);
				 ((FactorContext)_localctx).result =  ((FactorContext)_localctx).expression.result; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u0104\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\7\2&\n\2\f\2\16\2)\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4M\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4X\n\4\7\4Z\n\4\f\4\16\4]\13\4\5\4_\n\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5"+
		"g\n\5\f\5\16\5j\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6t\n\6\3\6\3\6"+
		"\3\6\3\6\7\6z\n\6\f\6\16\6}\13\6\3\6\3\6\3\6\3\6\5\6\u0083\n\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0090\n\7\f\7\16\7\u0093\13\7"+
		"\5\7\u0095\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a3"+
		"\n\b\3\b\3\b\3\t\5\t\u00a8\n\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\7\n\u00b8\n\n\f\n\16\n\u00bb\13\n\5\n\u00bd\n\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00c8\n\13\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00d8\n\r\f\r\16\r\u00db\13"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\7\16\u00ee\n\16\f\16\16\16\u00f1\13\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0102"+
		"\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\2\2\u0111\2\36"+
		"\3\2\2\2\4-\3\2\2\2\6D\3\2\2\2\b`\3\2\2\2\nk\3\2\2\2\f\u0087\3\2\2\2\16"+
		"\u00a2\3\2\2\2\20\u00a7\3\2\2\2\22\u00ae\3\2\2\2\24\u00c1\3\2\2\2\26\u00c9"+
		"\3\2\2\2\30\u00cb\3\2\2\2\32\u00dc\3\2\2\2\34\u0101\3\2\2\2\36\'\b\2\1"+
		"\2\37 \5\4\3\2 !\b\2\1\2!&\3\2\2\2\"#\5\n\6\2#$\b\2\1\2$&\3\2\2\2%\37"+
		"\3\2\2\2%\"\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'\3\2\2"+
		"\2*+\7\2\2\3+,\b\2\1\2,\3\3\2\2\2-.\7\3\2\2./\b\3\1\2/\60\7\4\2\2\60\61"+
		"\7\5\2\2\61\62\7\6\2\2\62\63\7\7\2\2\63\64\7\b\2\2\64\65\5\6\4\2\65;\7"+
		"\t\2\2\66\67\5\16\b\2\678\b\3\1\28:\3\2\2\29\66\3\2\2\2:=\3\2\2\2;9\3"+
		"\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\7\n\2\2?@\5\b\5\2@A\7\t\2\2AB\7"+
		"\13\2\2BC\b\3\1\2C\5\3\2\2\2D^\b\4\1\2EF\7\34\2\2FG\7\35\2\2GM\b\4\1\2"+
		"HI\7\f\2\2IJ\7\34\2\2JK\7\35\2\2KM\b\4\1\2LE\3\2\2\2LH\3\2\2\2M[\3\2\2"+
		"\2NO\7\r\2\2OP\7\34\2\2PQ\7\35\2\2QX\b\4\1\2RS\7\r\2\2ST\7\f\2\2TU\7\34"+
		"\2\2UV\7\35\2\2VX\b\4\1\2WN\3\2\2\2WR\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z]\3"+
		"\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\_\3\2\2\2][\3\2\2\2^L\3\2\2\2^_\3\2\2\2_"+
		"\7\3\2\2\2`a\b\5\1\2ab\7\35\2\2bh\b\5\1\2cd\7\r\2\2de\7\35\2\2eg\b\5\1"+
		"\2fc\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\t\3\2\2\2jh\3\2\2\2kl\7\3"+
		"\2\2lm\b\6\1\2mn\7\35\2\2no\7\5\2\2op\5\f\7\2ps\7\6\2\2qr\7\16\2\2rt\7"+
		"\34\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2\2u{\7\7\2\2vw\5\16\b\2wx\b\6\1\2x"+
		"z\3\2\2\2yv\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\u0082\3\2\2\2}{\3\2"+
		"\2\2~\177\7\17\2\2\177\u0080\5\30\r\2\u0080\u0081\7\t\2\2\u0081\u0083"+
		"\3\2\2\2\u0082~\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0085\7\13\2\2\u0085\u0086\b\6\1\2\u0086\13\3\2\2\2\u0087\u0094\b\7\1"+
		"\2\u0088\u0089\7\34\2\2\u0089\u008a\7\35\2\2\u008a\u0091\b\7\1\2\u008b"+
		"\u008c\7\r\2\2\u008c\u008d\7\34\2\2\u008d\u008e\7\35\2\2\u008e\u0090\b"+
		"\7\1\2\u008f\u008b\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0088\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\r\3\2\2\2\u0096\u0097\5\20\t\2\u0097\u0098"+
		"\b\b\1\2\u0098\u00a3\3\2\2\2\u0099\u009a\5\30\r\2\u009a\u009b\b\b\1\2"+
		"\u009b\u00a3\3\2\2\2\u009c\u009d\5\24\13\2\u009d\u009e\b\b\1\2\u009e\u00a3"+
		"\3\2\2\2\u009f\u00a0\5\26\f\2\u00a0\u00a1\b\b\1\2\u00a1\u00a3\3\2\2\2"+
		"\u00a2\u0096\3\2\2\2\u00a2\u0099\3\2\2\2\u00a2\u009c\3\2\2\2\u00a2\u009f"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\7\t\2\2\u00a5\17\3\2\2\2\u00a6"+
		"\u00a8\7\34\2\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3"+
		"\2\2\2\u00a9\u00aa\7\35\2\2\u00aa\u00ab\7\20\2\2\u00ab\u00ac\5\30\r\2"+
		"\u00ac\u00ad\b\t\1\2\u00ad\21\3\2\2\2\u00ae\u00af\7\35\2\2\u00af\u00b0"+
		"\7\5\2\2\u00b0\u00bc\b\n\1\2\u00b1\u00b2\5\30\r\2\u00b2\u00b9\b\n\1\2"+
		"\u00b3\u00b4\7\r\2\2\u00b4\u00b5\5\30\r\2\u00b5\u00b6\b\n\1\2\u00b6\u00b8"+
		"\3\2\2\2\u00b7\u00b3\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00b1\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\7\6\2\2\u00bf"+
		"\u00c0\b\n\1\2\u00c0\23\3\2\2\2\u00c1\u00c7\7\21\2\2\u00c2\u00c3\5\30"+
		"\r\2\u00c3\u00c4\b\13\1\2\u00c4\u00c8\3\2\2\2\u00c5\u00c6\7\36\2\2\u00c6"+
		"\u00c8\b\13\1\2\u00c7\u00c2\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\25\3\2\2"+
		"\2\u00c9\u00ca\7\22\2\2\u00ca\27\3\2\2\2\u00cb\u00cc\5\32\16\2\u00cc\u00d9"+
		"\b\r\1\2\u00cd\u00ce\7\23\2\2\u00ce\u00cf\5\32\16\2\u00cf\u00d0\3\2\2"+
		"\2\u00d0\u00d1\b\r\1\2\u00d1\u00d8\3\2\2\2\u00d2\u00d3\7\24\2\2\u00d3"+
		"\u00d4\5\32\16\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\b\r\1\2\u00d6\u00d8\3"+
		"\2\2\2\u00d7\u00cd\3\2\2\2\u00d7\u00d2\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\31\3\2\2\2\u00db\u00d9\3\2\2"+
		"\2\u00dc\u00dd\5\34\17\2\u00dd\u00ef\b\16\1\2\u00de\u00df\7\25\2\2\u00df"+
		"\u00e0\5\34\17\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\b\16\1\2\u00e2\u00ee"+
		"\3\2\2\2\u00e3\u00e4\7\26\2\2\u00e4\u00e5\5\34\17\2\u00e5\u00e6\3\2\2"+
		"\2\u00e6\u00e7\b\16\1\2\u00e7\u00ee\3\2\2\2\u00e8\u00e9\7\27\2\2\u00e9"+
		"\u00ea\5\34\17\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\b\16\1\2\u00ec\u00ee"+
		"\3\2\2\2\u00ed\u00de\3\2\2\2\u00ed\u00e3\3\2\2\2\u00ed\u00e8\3\2\2\2\u00ee"+
		"\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\33\3\2\2"+
		"\2\u00f1\u00ef\3\2\2\2\u00f2\u00f3\7\35\2\2\u00f3\u0102\b\17\1\2\u00f4"+
		"\u00f5\7\30\2\2\u00f5\u00f6\7\5\2\2\u00f6\u00f7\7\35\2\2\u00f7\u00f8\7"+
		"\6\2\2\u00f8\u0102\b\17\1\2\u00f9\u00fa\5\22\n\2\u00fa\u00fb\b\17\1\2"+
		"\u00fb\u0102\3\2\2\2\u00fc\u00fd\7\5\2\2\u00fd\u00fe\5\30\r\2\u00fe\u00ff"+
		"\7\6\2\2\u00ff\u0100\b\17\1\2\u0100\u0102\3\2\2\2\u0101\u00f2\3\2\2\2"+
		"\u0101\u00f4\3\2\2\2\u0101\u00f9\3\2\2\2\u0101\u00fc\3\2\2\2\u0102\35"+
		"\3\2\2\2\31%\';LW[^hs{\u0082\u0091\u0094\u00a2\u00a7\u00b9\u00bc\u00c7"+
		"\u00d7\u00d9\u00ed\u00ef\u0101";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}