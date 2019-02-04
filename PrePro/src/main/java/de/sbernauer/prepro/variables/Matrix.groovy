package de.sbernauer.prepro.variables;

import org.nd4j.linalg.api.ndarray.INDArray;

public class Matrix extends Variable {

    public Matrix(INDArray ndArray) {
        super(ndArray);
        if (ndArray.shape().length != 3) {
            throw new RuntimeException("Matrix must be two-dimensional.");
        }
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "ndArray=" + ndArray +
                '}';
    }
}
