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



import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PreProParser}.
 */
public interface PreProListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PreProParser#prepro}.
	 * @param ctx the parse tree
	 */
	void enterPrepro(PreProParser.PreproContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreProParser#prepro}.
	 * @param ctx the parse tree
	 */
	void exitPrepro(PreProParser.PreproContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreProParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void enterMainFunction(PreProParser.MainFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreProParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void exitMainFunction(PreProParser.MainFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreProParser#importDefinitions}.
	 * @param ctx the parse tree
	 */
	void enterImportDefinitions(PreProParser.ImportDefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreProParser#importDefinitions}.
	 * @param ctx the parse tree
	 */
	void exitImportDefinitions(PreProParser.ImportDefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreProParser#exportDefinitions}.
	 * @param ctx the parse tree
	 */
	void enterExportDefinitions(PreProParser.ExportDefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreProParser#exportDefinitions}.
	 * @param ctx the parse tree
	 */
	void exitExportDefinitions(PreProParser.ExportDefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreProParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(PreProParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreProParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(PreProParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreProParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArguments(PreProParser.FunctionArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreProParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArguments(PreProParser.FunctionArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreProParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PreProParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreProParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PreProParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreProParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStatement(PreProParser.AssignStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreProParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStatement(PreProParser.AssignStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreProParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallStatement(PreProParser.FunctionCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreProParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallStatement(PreProParser.FunctionCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreProParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(PreProParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreProParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(PreProParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreProParser#debugStatement}.
	 * @param ctx the parse tree
	 */
	void enterDebugStatement(PreProParser.DebugStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreProParser#debugStatement}.
	 * @param ctx the parse tree
	 */
	void exitDebugStatement(PreProParser.DebugStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreProParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PreProParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreProParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PreProParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreProParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(PreProParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreProParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(PreProParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link PreProParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(PreProParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PreProParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(PreProParser.FactorContext ctx);
}