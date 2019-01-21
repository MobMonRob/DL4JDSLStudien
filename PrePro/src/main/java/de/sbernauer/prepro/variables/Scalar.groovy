package de.sbernauer.prepro.variables;

import org.nd4j.linalg.api.ndarray.INDArray;

public class Scalar extends Variable {
    public Scalar(INDArray ndArray) {
        super(ndArray);
        int size = ndArray.shape()[1];
        if (ndArray.shape().length != 2 || size != 1) {
            throw new RuntimeException("The given Scalar has the size " + size + ", must be 1.");
        }
    }

    Variable add(Scalar right) {
        return new Scalar(ndArray.add(right.ndArray));
    }

    Variable sub(Scalar right) {
        return new Scalar(ndArray.sub(right.ndArray));
    }

    Variable mul(Scalar right) {
        return new Scalar(ndArray.mul(right.ndArray));
    }

    Variable div(Scalar right) {
        return new Scalar(ndArray.div(right.ndArray));
    }

    @Override
    public String toString() {
        return "Scalar{" +
                "ndArray=" + ndArray +
                '}';
    }
}
