package de.sbernauer.prepro.nodes.statement;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.nodes.expression.ExpressionNode;

import java.io.PrintStream;

public class PrintStatementNode extends StatementNode {
    private static final PrintStream OUTPUT_STREAM = System.out;

    private ExpressionNode expressionNode;

    private boolean printExpressionAndNotText;
    private String text;

    public PrintStatementNode(ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
        this.printExpressionAndNotText = true;
    }

    public PrintStatementNode(String text) {
        this.printExpressionAndNotText = false;
        this.text = text;
    }

    public void execute(SymbolTable symbolTable, FunctionTable functionTable) {
        if (printExpressionAndNotText) {
            OUTPUT_STREAM.println(expressionNode.execute(symbolTable, functionTable));
        } else {
            OUTPUT_STREAM.println(text);
        }
    }
}
