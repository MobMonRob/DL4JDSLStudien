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

        if (leftValue.getAmountTimeElements() != rightValue.getAmountTimeElements()) {
            throw new RuntimeException("Matrix must have the same amount of time elements.");
        }

        if (leftValue instanceof Vector3 && rightValue instanceof Vector3) {
            return new Vector3((leftValue).getNdArray().mul((rightValue).getNdArray()));
        } else if (leftValue instanceof Vector4 && rightValue instanceof Vector4) {
            return new Vector4((leftValue).getNdArray().mul((rightValue).getNdArray()));

        } else if (leftValue instanceof Matrix3 && rightValue instanceof Matrix3) {
            return new Matrix3(multiplyMatrixWithMatrix((Matrix) leftValue, (Matrix) rightValue, 3));
        } else if (leftValue instanceof Matrix4 && rightValue instanceof Matrix4) {
            return new Matrix4(multiplyMatrixWithMatrix((Matrix) leftValue, (Matrix) rightValue, 4));

        } else if (leftValue instanceof Matrix3 && rightValue instanceof Vector3) {
            return new Vector3(multiplyMatrixWithVector((Matrix3) leftValue, (Vector3) rightValue, 3));
        } else if (leftValue instanceof Matrix4 && rightValue instanceof Vector4) {
            return new Vector4(multiplyMatrixWithVector((Matrix4) leftValue, (Vector4) rightValue, 4));

        } else if (leftValue instanceof Vector3 && rightValue instanceof Scalar) {
            return new Vector3(multiplyVectorWithScalar((Vector3)leftValue, (Scalar)rightValue, 3));
        } else if (leftValue instanceof Vector4 && rightValue instanceof Scalar) {
            return new Vector4(multiplyVectorWithScalar((Vector4)leftValue, (Scalar)rightValue, 4));

        } else if (leftValue instanceof Matrix3 && rightValue instanceof Scalar) {
            return new Matrix3(multiplyMatrixWithScalar((Matrix3)leftValue, (Scalar)rightValue, 3));
        } else if (leftValue instanceof Matrix4 && rightValue instanceof Scalar) {
            return new Matrix4(multiplyMatrixWithScalar((Matrix4)leftValue, (Scalar)rightValue, 4));

        } else if (leftValue instanceof Scalar && rightValue instanceof Scalar) {
            return elementWiseProduct((Scalar) leftValue, (Scalar) rightValue);

        } else {
            throw new RuntimeException("Cant multiply because of wrong types");
        }
    }

    private INDArray multiplyMatrixWithMatrix(Matrix left, Matrix right, int dimension) {
        //TODO Replace with faster implementation
        INDArray result = Nd4j.create(left.getAmountTimeElements(), dimension, dimension);
        for (int i = 0; i < left.getAmountTimeElements(); i++) {
            result.putRow(i, left.getNdArray().getRow(i).mmul(right.getNdArray().getRow(i)));
        }
        return result;
    }

    private INDArray multiplyMatrixWithVector(Matrix left, Vector right, int dimension) {
        //TODO Replace with faster implementation
        INDArray result = Nd4j.create(left.getAmountTimeElements(), dimension);
        for (int i = 0; i < left.getAmountTimeElements(); i++) {
            INDArray leftValue = left.getNdArray().getRow(i);
            INDArray rightValue = right.getNdArray().getRow(i);

            INDArray value = leftValue.mmul(rightValue.transpose());
            result.putRow(i, value);
        }
        return result;
    }

    private INDArray multiplyVectorWithScalar(Vector left, Scalar right, int dimension) {
        //TODO Replace with faster implementation
        INDArray result = Nd4j.create(left.getAmountTimeElements(), dimension);
        for (int i = 0; i < left.getAmountTimeElements(); i++) {
            INDArray leftValue = left.getNdArray().getRow(i);
            double rightValue = right.getNdArray().getDouble(i);

            INDArray value = leftValue.mul(rightValue);
            result.putRow(i, value);
        }
        return result;
    }

    private INDArray multiplyMatrixWithScalar(Matrix left, Scalar right, int dimension) {
        //TODO Replace with faster implementation
        INDArray result = Nd4j.create(left.getAmountTimeElements(), dimension, dimension);
        for (int i = 0; i < left.getAmountTimeElements(); i++) {
            INDArray leftValue = left.getNdArray().getRow(i);
            double rightValue = right.getNdArray().getDouble(i);

            INDArray value = leftValue.mul(rightValue);
            result.putRow(i, value);
        }
        return result;
    }

    private Scalar elementWiseProduct(Scalar left, Scalar right) {
        return new Scalar(left.getNdArray().add(right.getNdArray()));
    }
}
