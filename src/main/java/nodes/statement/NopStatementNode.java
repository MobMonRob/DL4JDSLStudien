package nodes.statement;

import nodes.FunctionTable;
import nodes.SymbolTable;
import nodes.expression.ExpressionNode;

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
