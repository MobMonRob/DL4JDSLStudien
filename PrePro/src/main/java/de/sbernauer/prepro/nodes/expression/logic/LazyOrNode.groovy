package de.sbernauer.prepro.nodes.expression.logic

import de.sbernauer.prepro.nodes.FunctionTable
import de.sbernauer.prepro.nodes.SymbolTable
import de.sbernauer.prepro.nodes.expression.ExpressionNode
import de.sbernauer.prepro.variables.Constant
import de.sbernauer.prepro.variables.Variable

/**
 * Represents a lazy logic OR.
 * If the right part is a constant and is 0, the right part will be evaluated and returned.
 * Represented by a "||".
 */
public class LazyOrNode extends ExpressionNode {

    private ExpressionNode left;
    private ExpressionNode right;

    public LazyOrNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Variable execute(SymbolTable symbolTable, FunctionTable functionTable) {
        Variable leftValue = left.execute(symbolTable, functionTable);
        if(!(leftValue instanceof Constant)) {
            return leftValue;
        }
        if(((Constant)leftValue).getDoubleValue() != 0) {
            return leftValue;
        }

        Variable rightValue = right.execute(symbolTable, functionTable);

        return rightValue;
    }
}
