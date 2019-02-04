package de.sbernauer.prepro.nodes.expression.arithmetic;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.nodes.expression.ExpressionNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import de.sbernauer.prepro.variables.*;

/**
 * Represents a multiplication.
 * The exact operation depends on the given types.
 * Represented by a "*"
 */
public class MulNode extends ExpressionNode {

    private ExpressionNode left;
    private ExpressionNode right;

    public MulNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Variable execute(SymbolTable symbolTable, FunctionTable functionTable) {
        Variable leftValue = left.execute(symbolTable, functionTable);
        Variable rightValue = right.execute(symbolTable, functionTable);

        return leftValue.mul(rightValue);
    }
}
