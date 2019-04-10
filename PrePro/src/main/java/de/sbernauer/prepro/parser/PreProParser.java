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
import de.sbernauer.prepro.nodes.expression.logic.*;
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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		WS=32, BLOCK_COMMENT=33, LINE_COMMENT=34, TYPE=35, IDENTIFIER=36, STRING_LITERAL=37, 
		NUMERIC_LITERAL=38;
	public static final int
		RULE_prepro = 0, RULE_mainFunction = 1, RULE_importDefinitions = 2, RULE_exportDefinitions = 3, 
		RULE_function = 4, RULE_functionArguments = 5, RULE_statement = 6, RULE_assignStatement = 7, 
		RULE_functionCallStatement = 8, RULE_printStatement = 9, RULE_throwStatement = 10, 
		RULE_debugStatement = 11, RULE_expression = 12, RULE_term = 13, RULE_factor = 14;
	public static final String[] ruleNames = {
		"prepro", "mainFunction", "importDefinitions", "exportDefinitions", "function", 
		"functionArguments", "statement", "assignStatement", "functionCallStatement", 
		"printStatement", "throwStatement", "debugStatement", "expression", "term", 
		"factor"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'import'", "';'", "'export'", "'function'", "'main'", "'('", "')'", 
		"'{'", "'}'", "'optional'", "','", "'returns'", "'return'", "'='", "'print'", 
		"'throw'", "'debug'", "'+'", "'-'", "'*'", "'**'", "'X'", "'/'", "'=='", 
		"'<='", "'<'", "'>'", "'>='", "'&&'", "'||'", "'exists'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "WS", "BLOCK_COMMENT", 
		"LINE_COMMENT", "TYPE", "IDENTIFIER", "STRING_LITERAL", "NUMERIC_LITERAL"
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
		public ImportDefinitionsContext importDefinitions;
		public StatementContext statement;
		public ExportDefinitionsContext exportDefinitions;
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
		public TerminalNode EOF() { return getToken(PreProParser.EOF, 0); }
		public ImportDefinitionsContext importDefinitions() {
			return getRuleContext(ImportDefinitionsContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ExportDefinitionsContext exportDefinitions() {
			return getRuleContext(ExportDefinitionsContext.class,0);
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
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					setState(37);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						 nodeFactory.startFunctionList(); 
						setState(31);
						((PreproContext)_localctx).mainFunction = mainFunction();
						 nodeFactory.addFunction(((PreproContext)_localctx).mainFunction.result); 
						}
						break;
					case 2:
						{
						setState(34);
						((PreproContext)_localctx).function = function();
						 nodeFactory.addFunction(((PreproContext)_localctx).function.result); 
						}
						break;
					}
					}
					setState(41);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 ((PreproContext)_localctx).result =  new MainNode(nodeFactory.getFunctionsAsArray()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				 nodeFactory.startFunctionList(); nodeFactory.startStatementList(); 
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(44);
					match(T__0);
					setState(45);
					((PreproContext)_localctx).importDefinitions = importDefinitions();
					setState(46);
					match(T__1);
					}
				}

				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__30) | (1L << TYPE) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
					{
					{
					setState(50);
					((PreproContext)_localctx).statement = statement();
					 nodeFactory.addStatement(((PreproContext)_localctx).statement.result, (((PreproContext)_localctx).statement!=null?(((PreproContext)_localctx).statement.start):null).getLine()); 
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(58);
					match(T__2);
					setState(59);
					((PreproContext)_localctx).exportDefinitions = exportDefinitions();
					setState(60);
					match(T__1);
					}
				}

				 nodeFactory.addFunction(new MainFunctionNode("main", (_localctx.importDefinitions == null ? new ArrayList<>() : ((PreproContext)_localctx).importDefinitions.result), (_localctx.exportDefinitions == null ? new ArrayList<>() : ((PreproContext)_localctx).exportDefinitions.result), new StatementListNode(nodeFactory.getStatementsAsArray()))); 
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(65);
					((PreproContext)_localctx).function = function();
					 nodeFactory.addFunction(((PreproContext)_localctx).function.result); 
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				 ((PreproContext)_localctx).result =  new MainNode(nodeFactory.getFunctionsAsArray()); 
				setState(74);
				match(EOF);
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
			setState(77);
			match(T__3);
			 nodeFactory.startStatementList(); 
			setState(79);
			match(T__4);
			setState(80);
			match(T__5);
			setState(81);
			match(T__6);
			setState(82);
			match(T__7);
			setState(83);
			match(T__0);
			setState(84);
			((MainFunctionContext)_localctx).importDefinitions = importDefinitions();
			setState(85);
			match(T__1);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__30) | (1L << TYPE) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				{
				setState(86);
				((MainFunctionContext)_localctx).statement = statement();
				 nodeFactory.addStatement(((MainFunctionContext)_localctx).statement.result, (((MainFunctionContext)_localctx).statement!=null?(((MainFunctionContext)_localctx).statement.start):null).getLine()); 
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(T__2);
			setState(95);
			((MainFunctionContext)_localctx).exportDefinitions = exportDefinitions();
			setState(96);
			match(T__1);
			setState(97);
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
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9 || _la==TYPE) {
				{
				setState(108);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TYPE:
					{
					setState(101);
					((ImportDefinitionsContext)_localctx).TYPE = match(TYPE);
					setState(102);
					((ImportDefinitionsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
					 _localctx.result.add(nodeFactory.createImportDefinition((((ImportDefinitionsContext)_localctx).TYPE!=null?((ImportDefinitionsContext)_localctx).TYPE.getText():null), (((ImportDefinitionsContext)_localctx).IDENTIFIER!=null?((ImportDefinitionsContext)_localctx).IDENTIFIER.getText():null), false)); 
					}
					break;
				case T__9:
					{
					setState(104);
					match(T__9);
					setState(105);
					((ImportDefinitionsContext)_localctx).TYPE = match(TYPE);
					setState(106);
					((ImportDefinitionsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
					 _localctx.result.add(nodeFactory.createImportDefinition((((ImportDefinitionsContext)_localctx).TYPE!=null?((ImportDefinitionsContext)_localctx).TYPE.getText():null), (((ImportDefinitionsContext)_localctx).IDENTIFIER!=null?((ImportDefinitionsContext)_localctx).IDENTIFIER.getText():null), true)); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(119);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						setState(110);
						match(T__10);
						setState(111);
						((ImportDefinitionsContext)_localctx).TYPE = match(TYPE);
						setState(112);
						((ImportDefinitionsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
						 _localctx.result.add(nodeFactory.createImportDefinition((((ImportDefinitionsContext)_localctx).TYPE!=null?((ImportDefinitionsContext)_localctx).TYPE.getText():null), (((ImportDefinitionsContext)_localctx).IDENTIFIER!=null?((ImportDefinitionsContext)_localctx).IDENTIFIER.getText():null), false)); 
						}
						break;
					case 2:
						{
						setState(114);
						match(T__10);
						setState(115);
						match(T__9);
						setState(116);
						((ImportDefinitionsContext)_localctx).TYPE = match(TYPE);
						setState(117);
						((ImportDefinitionsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
						 _localctx.result.add(nodeFactory.createImportDefinition((((ImportDefinitionsContext)_localctx).TYPE!=null?((ImportDefinitionsContext)_localctx).TYPE.getText():null), (((ImportDefinitionsContext)_localctx).IDENTIFIER!=null?((ImportDefinitionsContext)_localctx).IDENTIFIER.getText():null), true)); 
						}
						break;
					}
					}
					}
					setState(125);
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
			setState(129);
			((ExportDefinitionsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 _localctx.result.add((((ExportDefinitionsContext)_localctx).IDENTIFIER!=null?((ExportDefinitionsContext)_localctx).IDENTIFIER.getText():null)); 
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(131);
				match(T__10);
				setState(132);
				((ExportDefinitionsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 _localctx.result.add((((ExportDefinitionsContext)_localctx).IDENTIFIER!=null?((ExportDefinitionsContext)_localctx).IDENTIFIER.getText():null)); 
				}
				}
				setState(138);
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
			setState(139);
			match(T__3);
			 nodeFactory.startStatementList(); 
			setState(141);
			((FunctionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(142);
			match(T__5);
			setState(143);
			((FunctionContext)_localctx).functionArguments = functionArguments();
			setState(144);
			match(T__6);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(145);
				match(T__11);
				setState(146);
				((FunctionContext)_localctx).returnType = match(TYPE);
				}
			}

			setState(149);
			match(T__7);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__30) | (1L << TYPE) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				{
				setState(150);
				((FunctionContext)_localctx).statement = statement();
				 nodeFactory.addStatement(((FunctionContext)_localctx).statement.result, (((FunctionContext)_localctx).statement!=null?(((FunctionContext)_localctx).statement.start):null).getLine()); 
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(158);
				match(T__12);
				setState(159);
				((FunctionContext)_localctx).returnExpression = expression();
				setState(160);
				match(T__1);
				}
			}

			setState(164);
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
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(168);
				((FunctionArgumentsContext)_localctx).TYPE = match(TYPE);
				setState(169);
				((FunctionArgumentsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 _localctx.result.add(nodeFactory.createParameterDefinition((((FunctionArgumentsContext)_localctx).TYPE!=null?((FunctionArgumentsContext)_localctx).TYPE.getText():null), (((FunctionArgumentsContext)_localctx).IDENTIFIER!=null?((FunctionArgumentsContext)_localctx).IDENTIFIER.getText():null))); 
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(171);
					match(T__10);
					setState(172);
					((FunctionArgumentsContext)_localctx).TYPE = match(TYPE);
					setState(173);
					((FunctionArgumentsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
					 _localctx.result.add(nodeFactory.createParameterDefinition((((FunctionArgumentsContext)_localctx).TYPE!=null?((FunctionArgumentsContext)_localctx).TYPE.getText():null), (((FunctionArgumentsContext)_localctx).IDENTIFIER!=null?((FunctionArgumentsContext)_localctx).IDENTIFIER.getText():null))); 
					}
					}
					setState(179);
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
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(182);
				((StatementContext)_localctx).assignStatement = assignStatement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).assignStatement.result; 
				}
				break;
			case 2:
				{
				setState(185);
				((StatementContext)_localctx).expression = expression();
				 ((StatementContext)_localctx).result =  new NopStatementNode(((StatementContext)_localctx).expression.result); 
				}
				break;
			case 3:
				{
				setState(188);
				((StatementContext)_localctx).printStatement = printStatement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).printStatement.result; 
				}
				break;
			case 4:
				{
				setState(191);
				((StatementContext)_localctx).debugStatement = debugStatement();
				 ((StatementContext)_localctx).result =  new DebugNode((((StatementContext)_localctx).debugStatement!=null?(((StatementContext)_localctx).debugStatement.start):null).getLine()); 
				}
				break;
			}
			setState(196);
			match(T__1);
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
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(198);
				((AssignStatementContext)_localctx).TYPE = match(TYPE);
				}
			}

			setState(201);
			((AssignStatementContext)_localctx).i = match(IDENTIFIER);
			setState(202);
			match(T__13);
			{
			setState(203);
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
			setState(206);
			((FunctionCallStatementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(207);
			match(T__5);
			 List<ExpressionNode> expressionList = new ArrayList<>(); 
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__15) | (1L << T__30) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				setState(209);
				((FunctionCallStatementContext)_localctx).expression = expression();
				 expressionList.add(((FunctionCallStatementContext)_localctx).expression.result); 
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(211);
					match(T__10);
					setState(212);
					((FunctionCallStatementContext)_localctx).expression = expression();
					 expressionList.add(((FunctionCallStatementContext)_localctx).expression.result); 
					}
					}
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(222);
			match(T__6);
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
			setState(225);
			match(T__14);
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__15:
			case T__30:
			case IDENTIFIER:
			case NUMERIC_LITERAL:
				{
				setState(226);
				((PrintStatementContext)_localctx).expression = expression();
				 ((PrintStatementContext)_localctx).result =  new PrintStatementNode(((PrintStatementContext)_localctx).expression.result); 
				}
				break;
			case STRING_LITERAL:
				{
				setState(229);
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

	public static class ThrowStatementContext extends ParserRuleContext {
		public ThrowStatementNode result;
		public Token STRING_LITERAL;
		public TerminalNode STRING_LITERAL() { return getToken(PreProParser.STRING_LITERAL, 0); }
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).enterThrowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PreProListener ) ((PreProListener)listener).exitThrowStatement(this);
		}
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(T__15);
			{
			setState(234);
			((ThrowStatementContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
			 ((ThrowStatementContext)_localctx).result =  new ThrowStatementNode((((ThrowStatementContext)_localctx).STRING_LITERAL!=null?((ThrowStatementContext)_localctx).STRING_LITERAL.getText():null).substring(1, (((ThrowStatementContext)_localctx).STRING_LITERAL!=null?((ThrowStatementContext)_localctx).STRING_LITERAL.getText():null).length() - 1)); 
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
		enterRule(_localctx, 22, RULE_debugStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			((DebugStatementContext)_localctx).d = match(T__16);
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
		enterRule(_localctx, 24, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			((ExpressionContext)_localctx).term = term();
			 ((ExpressionContext)_localctx).result =  ((ExpressionContext)_localctx).term.result; 
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17 || _la==T__18) {
				{
				setState(251);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__17:
					{
					{
					setState(241);
					match(T__17);
					setState(242);
					((ExpressionContext)_localctx).term = term();
					}
					 ((ExpressionContext)_localctx).result =  new AddNode(_localctx.result, ((ExpressionContext)_localctx).term.result); 
					}
					break;
				case T__18:
					{
					{
					setState(246);
					match(T__18);
					setState(247);
					((ExpressionContext)_localctx).term = term();
					}
					 ((ExpressionContext)_localctx).result =  new SubNode(_localctx.result, ((ExpressionContext)_localctx).term.result); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(255);
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
		enterRule(_localctx, 26, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			((TermContext)_localctx).factor = factor();
			 ((TermContext)_localctx).result =  ((TermContext)_localctx).factor.result; 
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) {
				{
				setState(306);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__19:
					{
					{
					setState(258);
					match(T__19);
					setState(259);
					((TermContext)_localctx).factor = factor();
					}
					 ((TermContext)_localctx).result =  new MulNode(_localctx.result, ((TermContext)_localctx).factor.result); 
					}
					break;
				case T__20:
					{
					{
					setState(263);
					match(T__20);
					setState(264);
					((TermContext)_localctx).factor = factor();
					}
					 ((TermContext)_localctx).result =  new LazyMulNode(_localctx.result, ((TermContext)_localctx).factor.result); 
					}
					break;
				case T__21:
					{
					{
					setState(268);
					match(T__21);
					setState(269);
					((TermContext)_localctx).factor = factor();
					}
					 ((TermContext)_localctx).result =  new CrossProductNode(_localctx.result, ((TermContext)_localctx).factor.result); 
					}
					break;
				case T__22:
					{
					{
					setState(273);
					match(T__22);
					setState(274);
					((TermContext)_localctx).factor = factor();
					}
					 ((TermContext)_localctx).result =  new DivNode(_localctx.result, ((TermContext)_localctx).factor.result); 
					}
					break;
				case T__23:
					{
					setState(278);
					match(T__23);
					setState(279);
					((TermContext)_localctx).factor = factor();
					 ((TermContext)_localctx).result =  new IsEqualNode(_localctx.result, ((TermContext)_localctx).factor.result); 
					}
					break;
				case T__24:
					{
					setState(282);
					match(T__24);
					setState(283);
					((TermContext)_localctx).factor = factor();
					 ((TermContext)_localctx).result =  new IsLessOrEqualNode(_localctx.result, ((TermContext)_localctx).factor.result); 
					}
					break;
				case T__25:
					{
					setState(286);
					match(T__25);
					setState(287);
					((TermContext)_localctx).factor = factor();
					 ((TermContext)_localctx).result =  new IsLessNode(_localctx.result, ((TermContext)_localctx).factor.result); 
					}
					break;
				case T__26:
					{
					setState(290);
					match(T__26);
					setState(291);
					((TermContext)_localctx).factor = factor();
					 ((TermContext)_localctx).result =  new IsGreaterNode(_localctx.result, ((TermContext)_localctx).factor.result); 
					}
					break;
				case T__27:
					{
					setState(294);
					match(T__27);
					setState(295);
					((TermContext)_localctx).factor = factor();
					 ((TermContext)_localctx).result =  new IsGreaterOrEqualNode(_localctx.result, ((TermContext)_localctx).factor.result); 
					}
					break;
				case T__28:
					{
					setState(298);
					match(T__28);
					setState(299);
					((TermContext)_localctx).factor = factor();
					 ((TermContext)_localctx).result =  new LazyAndNode(_localctx.result, ((TermContext)_localctx).factor.result); 
					}
					break;
				case T__29:
					{
					setState(302);
					match(T__29);
					setState(303);
					((TermContext)_localctx).factor = factor();
					 ((TermContext)_localctx).result =  new LazyOrNode(_localctx.result, ((TermContext)_localctx).factor.result); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(310);
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
		public ThrowStatementContext throwStatement;
		public ExpressionContext expression;
		public Token NUMERIC_LITERAL;
		public TerminalNode IDENTIFIER() { return getToken(PreProParser.IDENTIFIER, 0); }
		public FunctionCallStatementContext functionCallStatement() {
			return getRuleContext(FunctionCallStatementContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NUMERIC_LITERAL() { return getToken(PreProParser.NUMERIC_LITERAL, 0); }
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
		enterRule(_localctx, 28, RULE_factor);
		try {
			setState(331);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				((FactorContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 ((FactorContext)_localctx).result =  new VariableConstantNode((((FactorContext)_localctx).IDENTIFIER!=null?((FactorContext)_localctx).IDENTIFIER.getText():null)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
				match(T__30);
				setState(314);
				match(T__5);
				setState(315);
				((FactorContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(316);
				match(T__6);
				 ((FactorContext)_localctx).result =  new ExistsNode((((FactorContext)_localctx).IDENTIFIER!=null?((FactorContext)_localctx).IDENTIFIER.getText():null)); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(318);
				((FactorContext)_localctx).functionCallStatement = functionCallStatement();
				 ((FactorContext)_localctx).result =  ((FactorContext)_localctx).functionCallStatement.result; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(321);
				((FactorContext)_localctx).throwStatement = throwStatement();
				 ((FactorContext)_localctx).result =  ((FactorContext)_localctx).throwStatement.result; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(324);
				match(T__5);
				setState(325);
				((FactorContext)_localctx).expression = expression();
				setState(326);
				match(T__6);
				 ((FactorContext)_localctx).result =  ((FactorContext)_localctx).expression.result; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(329);
				((FactorContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
				 ((FactorContext)_localctx).result =  new ConstantNode(Double.parseDouble((((FactorContext)_localctx).NUMERIC_LITERAL!=null?((FactorContext)_localctx).NUMERIC_LITERAL.getText():null))); 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u0150\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\63\n\2\3"+
		"\2\3\2\3\2\7\28\n\2\f\2\16\2;\13\2\3\2\3\2\3\2\3\2\5\2A\n\2\3\2\3\2\3"+
		"\2\3\2\7\2G\n\2\f\2\16\2J\13\2\3\2\3\2\5\2N\n\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\\\n\3\f\3\16\3_\13\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4o\n\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4z\n\4\7\4|\n\4\f\4\16\4\177\13\4\5\4\u0081\n\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\7\5\u0089\n\5\f\5\16\5\u008c\13\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6\u0096\n\6\3\6\3\6\3\6\3\6\7\6\u009c\n\6\f\6\16\6\u009f"+
		"\13\6\3\6\3\6\3\6\3\6\5\6\u00a5\n\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\7\7\u00b2\n\7\f\7\16\7\u00b5\13\7\5\7\u00b7\n\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00c5\n\b\3\b\3\b\3\t\5\t\u00ca"+
		"\n\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00da"+
		"\n\n\f\n\16\n\u00dd\13\n\5\n\u00df\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u00ea\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00fe\n\16\f\16\16\16\u0101"+
		"\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0135\n\17\f\17\16"+
		"\17\u0138\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u014e\n\20\3\20\2\2"+
		"\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\2\2\u016b\2M\3\2\2\2\4O\3"+
		"\2\2\2\6f\3\2\2\2\b\u0082\3\2\2\2\n\u008d\3\2\2\2\f\u00a9\3\2\2\2\16\u00c4"+
		"\3\2\2\2\20\u00c9\3\2\2\2\22\u00d0\3\2\2\2\24\u00e3\3\2\2\2\26\u00eb\3"+
		"\2\2\2\30\u00ef\3\2\2\2\32\u00f1\3\2\2\2\34\u0102\3\2\2\2\36\u014d\3\2"+
		"\2\2 !\b\2\1\2!\"\5\4\3\2\"#\b\2\1\2#(\3\2\2\2$%\5\n\6\2%&\b\2\1\2&(\3"+
		"\2\2\2\' \3\2\2\2\'$\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2"+
		"+)\3\2\2\2,N\b\2\1\2-\62\b\2\1\2./\7\3\2\2/\60\5\6\4\2\60\61\7\4\2\2\61"+
		"\63\3\2\2\2\62.\3\2\2\2\62\63\3\2\2\2\639\3\2\2\2\64\65\5\16\b\2\65\66"+
		"\b\2\1\2\668\3\2\2\2\67\64\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:@\3"+
		"\2\2\2;9\3\2\2\2<=\7\5\2\2=>\5\b\5\2>?\7\4\2\2?A\3\2\2\2@<\3\2\2\2@A\3"+
		"\2\2\2AB\3\2\2\2BH\b\2\1\2CD\5\n\6\2DE\b\2\1\2EG\3\2\2\2FC\3\2\2\2GJ\3"+
		"\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\b\2\1\2LN\7\2\2\3M)\3"+
		"\2\2\2M-\3\2\2\2N\3\3\2\2\2OP\7\6\2\2PQ\b\3\1\2QR\7\7\2\2RS\7\b\2\2ST"+
		"\7\t\2\2TU\7\n\2\2UV\7\3\2\2VW\5\6\4\2W]\7\4\2\2XY\5\16\b\2YZ\b\3\1\2"+
		"Z\\\3\2\2\2[X\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2"+
		"\2`a\7\5\2\2ab\5\b\5\2bc\7\4\2\2cd\7\13\2\2de\b\3\1\2e\5\3\2\2\2f\u0080"+
		"\b\4\1\2gh\7%\2\2hi\7&\2\2io\b\4\1\2jk\7\f\2\2kl\7%\2\2lm\7&\2\2mo\b\4"+
		"\1\2ng\3\2\2\2nj\3\2\2\2o}\3\2\2\2pq\7\r\2\2qr\7%\2\2rs\7&\2\2sz\b\4\1"+
		"\2tu\7\r\2\2uv\7\f\2\2vw\7%\2\2wx\7&\2\2xz\b\4\1\2yp\3\2\2\2yt\3\2\2\2"+
		"z|\3\2\2\2{y\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0081\3\2\2\2\177"+
		"}\3\2\2\2\u0080n\3\2\2\2\u0080\u0081\3\2\2\2\u0081\7\3\2\2\2\u0082\u0083"+
		"\b\5\1\2\u0083\u0084\7&\2\2\u0084\u008a\b\5\1\2\u0085\u0086\7\r\2\2\u0086"+
		"\u0087\7&\2\2\u0087\u0089\b\5\1\2\u0088\u0085\3\2\2\2\u0089\u008c\3\2"+
		"\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\t\3\2\2\2\u008c\u008a"+
		"\3\2\2\2\u008d\u008e\7\6\2\2\u008e\u008f\b\6\1\2\u008f\u0090\7&\2\2\u0090"+
		"\u0091\7\b\2\2\u0091\u0092\5\f\7\2\u0092\u0095\7\t\2\2\u0093\u0094\7\16"+
		"\2\2\u0094\u0096\7%\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u009d\7\n\2\2\u0098\u0099\5\16\b\2\u0099\u009a\b"+
		"\6\1\2\u009a\u009c\3\2\2\2\u009b\u0098\3\2\2\2\u009c\u009f\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a4\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u00a0\u00a1\7\17\2\2\u00a1\u00a2\5\32\16\2\u00a2\u00a3\7\4\2\2\u00a3"+
		"\u00a5\3\2\2\2\u00a4\u00a0\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00a7\7\13\2\2\u00a7\u00a8\b\6\1\2\u00a8\13\3\2\2\2\u00a9\u00b6"+
		"\b\7\1\2\u00aa\u00ab\7%\2\2\u00ab\u00ac\7&\2\2\u00ac\u00b3\b\7\1\2\u00ad"+
		"\u00ae\7\r\2\2\u00ae\u00af\7%\2\2\u00af\u00b0\7&\2\2\u00b0\u00b2\b\7\1"+
		"\2\u00b1\u00ad\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4"+
		"\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00aa\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\r\3\2\2\2\u00b8\u00b9\5\20\t\2\u00b9\u00ba\b\b\1"+
		"\2\u00ba\u00c5\3\2\2\2\u00bb\u00bc\5\32\16\2\u00bc\u00bd\b\b\1\2\u00bd"+
		"\u00c5\3\2\2\2\u00be\u00bf\5\24\13\2\u00bf\u00c0\b\b\1\2\u00c0\u00c5\3"+
		"\2\2\2\u00c1\u00c2\5\30\r\2\u00c2\u00c3\b\b\1\2\u00c3\u00c5\3\2\2\2\u00c4"+
		"\u00b8\3\2\2\2\u00c4\u00bb\3\2\2\2\u00c4\u00be\3\2\2\2\u00c4\u00c1\3\2"+
		"\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\7\4\2\2\u00c7\17\3\2\2\2\u00c8\u00ca"+
		"\7%\2\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00cc\7&\2\2\u00cc\u00cd\7\20\2\2\u00cd\u00ce\5\32\16\2\u00ce\u00cf\b"+
		"\t\1\2\u00cf\21\3\2\2\2\u00d0\u00d1\7&\2\2\u00d1\u00d2\7\b\2\2\u00d2\u00de"+
		"\b\n\1\2\u00d3\u00d4\5\32\16\2\u00d4\u00db\b\n\1\2\u00d5\u00d6\7\r\2\2"+
		"\u00d6\u00d7\5\32\16\2\u00d7\u00d8\b\n\1\2\u00d8\u00da\3\2\2\2\u00d9\u00d5"+
		"\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00d3\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\7\t\2\2\u00e1\u00e2\b\n\1\2\u00e2"+
		"\23\3\2\2\2\u00e3\u00e9\7\21\2\2\u00e4\u00e5\5\32\16\2\u00e5\u00e6\b\13"+
		"\1\2\u00e6\u00ea\3\2\2\2\u00e7\u00e8\7\'\2\2\u00e8\u00ea\b\13\1\2\u00e9"+
		"\u00e4\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\25\3\2\2\2\u00eb\u00ec\7\22\2"+
		"\2\u00ec\u00ed\7\'\2\2\u00ed\u00ee\b\f\1\2\u00ee\27\3\2\2\2\u00ef\u00f0"+
		"\7\23\2\2\u00f0\31\3\2\2\2\u00f1\u00f2\5\34\17\2\u00f2\u00ff\b\16\1\2"+
		"\u00f3\u00f4\7\24\2\2\u00f4\u00f5\5\34\17\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f7\b\16\1\2\u00f7\u00fe\3\2\2\2\u00f8\u00f9\7\25\2\2\u00f9\u00fa\5"+
		"\34\17\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\b\16\1\2\u00fc\u00fe\3\2\2\2"+
		"\u00fd\u00f3\3\2\2\2\u00fd\u00f8\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd"+
		"\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\33\3\2\2\2\u0101\u00ff\3\2\2\2\u0102"+
		"\u0103\5\36\20\2\u0103\u0136\b\17\1\2\u0104\u0105\7\26\2\2\u0105\u0106"+
		"\5\36\20\2\u0106\u0107\3\2\2\2\u0107\u0108\b\17\1\2\u0108\u0135\3\2\2"+
		"\2\u0109\u010a\7\27\2\2\u010a\u010b\5\36\20\2\u010b\u010c\3\2\2\2\u010c"+
		"\u010d\b\17\1\2\u010d\u0135\3\2\2\2\u010e\u010f\7\30\2\2\u010f\u0110\5"+
		"\36\20\2\u0110\u0111\3\2\2\2\u0111\u0112\b\17\1\2\u0112\u0135\3\2\2\2"+
		"\u0113\u0114\7\31\2\2\u0114\u0115\5\36\20\2\u0115\u0116\3\2\2\2\u0116"+
		"\u0117\b\17\1\2\u0117\u0135\3\2\2\2\u0118\u0119\7\32\2\2\u0119\u011a\5"+
		"\36\20\2\u011a\u011b\b\17\1\2\u011b\u0135\3\2\2\2\u011c\u011d\7\33\2\2"+
		"\u011d\u011e\5\36\20\2\u011e\u011f\b\17\1\2\u011f\u0135\3\2\2\2\u0120"+
		"\u0121\7\34\2\2\u0121\u0122\5\36\20\2\u0122\u0123\b\17\1\2\u0123\u0135"+
		"\3\2\2\2\u0124\u0125\7\35\2\2\u0125\u0126\5\36\20\2\u0126\u0127\b\17\1"+
		"\2\u0127\u0135\3\2\2\2\u0128\u0129\7\36\2\2\u0129\u012a\5\36\20\2\u012a"+
		"\u012b\b\17\1\2\u012b\u0135\3\2\2\2\u012c\u012d\7\37\2\2\u012d\u012e\5"+
		"\36\20\2\u012e\u012f\b\17\1\2\u012f\u0135\3\2\2\2\u0130\u0131\7 \2\2\u0131"+
		"\u0132\5\36\20\2\u0132\u0133\b\17\1\2\u0133\u0135\3\2\2\2\u0134\u0104"+
		"\3\2\2\2\u0134\u0109\3\2\2\2\u0134\u010e\3\2\2\2\u0134\u0113\3\2\2\2\u0134"+
		"\u0118\3\2\2\2\u0134\u011c\3\2\2\2\u0134\u0120\3\2\2\2\u0134\u0124\3\2"+
		"\2\2\u0134\u0128\3\2\2\2\u0134\u012c\3\2\2\2\u0134\u0130\3\2\2\2\u0135"+
		"\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\35\3\2\2"+
		"\2\u0138\u0136\3\2\2\2\u0139\u013a\7&\2\2\u013a\u014e\b\20\1\2\u013b\u013c"+
		"\7!\2\2\u013c\u013d\7\b\2\2\u013d\u013e\7&\2\2\u013e\u013f\7\t\2\2\u013f"+
		"\u014e\b\20\1\2\u0140\u0141\5\22\n\2\u0141\u0142\b\20\1\2\u0142\u014e"+
		"\3\2\2\2\u0143\u0144\5\26\f\2\u0144\u0145\b\20\1\2\u0145\u014e\3\2\2\2"+
		"\u0146\u0147\7\b\2\2\u0147\u0148\5\32\16\2\u0148\u0149\7\t\2\2\u0149\u014a"+
		"\b\20\1\2\u014a\u014e\3\2\2\2\u014b\u014c\7(\2\2\u014c\u014e\b\20\1\2"+
		"\u014d\u0139\3\2\2\2\u014d\u013b\3\2\2\2\u014d\u0140\3\2\2\2\u014d\u0143"+
		"\3\2\2\2\u014d\u0146\3\2\2\2\u014d\u014b\3\2\2\2\u014e\37\3\2\2\2\36\'"+
		")\629@HM]ny}\u0080\u008a\u0095\u009d\u00a4\u00b3\u00b6\u00c4\u00c9\u00db"+
		"\u00de\u00e9\u00fd\u00ff\u0134\u0136\u014d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}