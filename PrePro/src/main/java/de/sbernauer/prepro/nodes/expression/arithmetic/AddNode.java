package de.sbernauer.prepro.nodes.expression.arithmetic;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.nodes.expression.ExpressionNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import de.sbernauer.prepro.variables.*;

public class AddNode extends ExpressionNode {

    private ExpressionNode left;
    private ExpressionNode right;

    public AddNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Variable execute(SymbolTable symbolTable, FunctionTable functionTable) {
        Variable leftValue = left.execute(symbolTable, functionTable);
        Variable rightValue = right.execute(symbolTable, functionTable);

        INDArray addedValue = leftValue.getNdArray().add(rightValue.getNdArray());

        if (leftValue instanceof Vector3 && rightValue instanceof Vector3) {
            return new Vector3(addedValue);
        } else if (leftValue instanceof Vector4 && rightValue instanceof Vector4) {
            return new Vector4(addedValue);
        } else if (leftValue instanceof Vector && rightValue instanceof Vector) {
            return new Vector(addedValue);
        } else if (leftValue instanceof Matrix3 && rightValue instanceof Matrix3) {
            return new Matrix3(addedValue);
        } else if (leftValue instanceof Matrix4 && rightValue instanceof Matrix4) {
            return new Matrix4(addedValue);
        } else if (leftValue instanceof Matrix && rightValue instanceof Matrix) {
            return new Matrix(addedValue);
        } else if (leftValue instanceof Scalar && rightValue instanceof Scalar) {
            return new Scalar(addedValue);
        } else {
            throw new RuntimeException("Cant add because of wrong types");
        }
    }
}
