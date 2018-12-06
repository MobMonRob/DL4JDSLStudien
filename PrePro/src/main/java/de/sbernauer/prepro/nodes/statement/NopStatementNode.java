package de.sbernauer.prepro.nodes.statement;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.nodes.expression.ExpressionNode;

public class NopStatementNode extends StatementNode {
    private final ExpressionNode expressionNode;

    public NopStatementNode(ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
    }

    @Override
    public void execute(SymbolTable symbolTable, FunctionTable functionTable) {
        expressionNode.execute(symbolTable, functionTable);
    }
}
