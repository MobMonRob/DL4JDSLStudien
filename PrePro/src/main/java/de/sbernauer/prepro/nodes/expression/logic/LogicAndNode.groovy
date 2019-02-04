package de.sbernauer.prepro.nodes.expression.logic

import de.sbernauer.prepro.nodes.FunctionTable
import de.sbernauer.prepro.nodes.SymbolTable
import de.sbernauer.prepro.nodes.expression.ExpressionNode
import de.sbernauer.prepro.variables.Scalar
import de.sbernauer.prepro.variables.Variable

public class LogicAndNode extends ExpressionNode {
    private ExpressionNode left;
    private ExpressionNode right;

    public LogicAndNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Variable execute(SymbolTable symbolTable, FunctionTable functionTable) {
        Variable leftValue = left.execute(symbolTable, functionTable);
        Variable rightValue = right.execute(symbolTable, functionTable);

        if(!(leftValue instanceof Scalar && rightValue instanceof Scalar)) {
            throw new RuntimeException("Can only perform logic and-operation on scalars.");
        }

        for(int i = 0; i < leftValue.getAmountTimeElements(); i++) {

        }
    }
}
