package de.sbernauer.prepro.variables;

import org.nd4j.linalg.api.ndarray.INDArray;

public class Vector extends Variable {

    public Vector(INDArray ndArray) {
        super(ndArray);
        if (ndArray.shape().length != 2) {
            throw new RuntimeException("Vector must be one-dimensional.");
        }
    }

    @Override
    public String toString() {
        return "Vector{" +
                "ndArray=" + ndArray +
                '}';
    }
}
