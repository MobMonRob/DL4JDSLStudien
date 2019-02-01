package de.sbernauer.prepro.variables;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public abstract class Variable {
    protected final INDArray ndArray;

    public Variable(INDArray ndArray) {
        this.ndArray = ndArray;
    }

    public INDArray getNdArray() {
        return ndArray;
    }

    public int getAmountTimeElements() {
        return ndArray.shape()[0];
    }

    public Variable add(Variable right) {
        throw new RuntimeException("Cannot add " + this.getClass().getSimpleName()
                + " and " + right.getClass().getSimpleName());
    }

    public Variable sub(Variable right) {
        throw new RuntimeException("Cannot subtract " + this.getClass().getSimpleName()
                + " and " + right.getClass().getSimpleName());
    }

    public Variable mul(Variable right) {
        throw new RuntimeException("Cannot multiply " + this.getClass().getSimpleName()
                + " and " + right.getClass().getSimpleName());
    }

    public Variable div(Variable right) {
        throw new RuntimeException("Cannot divide " + this.getClass().getSimpleName()
                + " and " + right.getClass().getSimpleName());
    }

    public Scalar isEqualTo(Variable right) {
        throw new RuntimeException("Cannot compare " + this.getClass().getSimpleName()
                + " and " + right.getClass().getSimpleName());
    }

    public Scalar isLessThan(Variable right) {
        throw new RuntimeException("Cannot compare " + this.getClass().getSimpleName()
                + " and " + right.getClass().getSimpleName());
    }

    public Scalar isLessOrEqualThan(Variable right) {
        throw new RuntimeException("Cannot compare " + this.getClass().getSimpleName()
                + " and " + right.getClass().getSimpleName());
    }

    public Scalar isGreaterThan(Variable right) {
        throw new RuntimeException("Cannot compare " + this.getClass().getSimpleName()
                + " and " + right.getClass().getSimpleName());
    }

    public Scalar isGreaterOrEqualThan(Variable right) {
        throw new RuntimeException("Cannot compare " + this.getClass().getSimpleName()
                + " and " + right.getClass().getSimpleName());
    }

    protected INDArray multiplyMatrixWithMatrix(Matrix left, Matrix right, int dimension) {
        //TODO Replace with faster implementation
        INDArray result = Nd4j.create((int[]) [left.getAmountTimeElements(), dimension, dimension]);
        for (int i = 0; i < left.getAmountTimeElements(); i++) {
            result.putRow(i, left.getNdArray().getRow(i).mmul(right.getNdArray().getRow(i)));
        }
        return result;
    }

    protected INDArray multiplyMatrixWithVector(Matrix left, Vector right, int dimension) {
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

    protected INDArray multiplyMatrixWithScalar(Matrix left, Scalar right, int dimension) {
        //TODO Replace with faster implementation
        INDArray result = Nd4j.create((int[]) [left.getAmountTimeElements(), dimension, dimension]);
        for (int i = 0; i < left.getAmountTimeElements(); i++) {
            INDArray leftValue = left.getNdArray().getRow(i);
            double rightValue = right.getNdArray().getDouble(i);

            INDArray value = leftValue.mul(rightValue);
            result.putRow(i, value);
        }
        return result;
    }

    protected INDArray multiplyVectorWithScalar(Vector left, Scalar right, int dimension) {
        //TODO Replace with faster implementation
        INDArray result = Nd4j.create((int[]) [left.getAmountTimeElements(), dimension]);
        for (int i = 0; i < left.getAmountTimeElements(); i++) {
            INDArray leftValue = left.getNdArray().getRow(i);
            double rightValue = right.getNdArray().getDouble(i);

            INDArray value = leftValue.mul(rightValue);
            result.putRow(i, value);
        }
        return result;
    }
}
