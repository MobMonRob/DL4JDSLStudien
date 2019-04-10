package de.sbernauer.prepro.nodes.expression.arithmetic

import de.sbernauer.prepro.nodes.FunctionTable
import de.sbernauer.prepro.nodes.SymbolTable
import de.sbernauer.prepro.nodes.expression.ExpressionNode
import de.sbernauer.prepro.variables.Constant
import de.sbernauer.prepro.variables.Variable

/**
 * Represents a normal multiplication. The left part must be a constant.
 * If the (left) constant is 0, the right part will not be evaluated.
 * Represented by a "**".
 */
public class LazyMulNode extends ExpressionNode {

    private ExpressionNode left;
    private ExpressionNode right;

    public LazyMulNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Variable execute(SymbolTable symbolTable, FunctionTable functionTable) {
        Variable leftValue = left.execute(symbolTable, functionTable);
        if(!(leftValue instanceof Constant)) {
            return leftValue;
        }
        if(((Constant)leftValue).getDoubleValue() == 0) {
            return new Constant(0);
        }

        Variable rightValue = right.execute(symbolTable, functionTable);

        return leftValue.mul(rightValue);
    }
}
