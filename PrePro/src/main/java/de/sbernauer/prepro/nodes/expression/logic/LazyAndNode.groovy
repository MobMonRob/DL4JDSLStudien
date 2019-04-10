package de.sbernauer.prepro.nodes.expression.logic

import de.sbernauer.prepro.nodes.FunctionTable
import de.sbernauer.prepro.nodes.SymbolTable
import de.sbernauer.prepro.nodes.expression.ExpressionNode
import de.sbernauer.prepro.variables.Constant
import de.sbernauer.prepro.variables.Variable

/**
 * Represents a lazy logic AND.
 * The left side must be a Constant. Returns the right side, if the left side is != 0, otherwise 0.
 * Represented by a "&&".
 */
public class LazyAndNode extends ExpressionNode {

    private ExpressionNode left;
    private ExpressionNode right;

    public LazyAndNode(ExpressionNode left, ExpressionNode right) {
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

        return rightValue;
    }
}
