package de.sbernauer.prepro.nodes.expression.arithmetic;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.nodes.expression.ExpressionNode;
import de.sbernauer.prepro.variables.Scalar;
import de.sbernauer.prepro.variables.Variable;

public class DivNode extends ExpressionNode {

    private ExpressionNode left;
    private ExpressionNode right;

    public DivNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Variable execute(SymbolTable symbolTable, FunctionTable functionTable) {
        Variable leftValue = left.execute(symbolTable, functionTable);
        Variable rightValue = right.execute(symbolTable, functionTable);

        return leftValue.div(rightValue);
    }
}
