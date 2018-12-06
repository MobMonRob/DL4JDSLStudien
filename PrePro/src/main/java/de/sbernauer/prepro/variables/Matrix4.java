package de.sbernauer.prepro.variables;

import org.nd4j.linalg.api.ndarray.INDArray;

import java.util.Arrays;

public class Matrix4 extends Matrix {

    public Matrix4(INDArray ndArray) {
        super(ndArray);
        if (ndArray.shape()[0] != 4 || ndArray.shape()[1] != 4) {
            throw new RuntimeException("The given Matrix4 has the shape " + Arrays.toString(ndArray.shape()) +
                    ", must be [4,4].");
        }
    }

    @Override
    public String toString() {
        return "Matrix4{" +
                "ndArray=" + ndArray +
                '}';
    }
}
