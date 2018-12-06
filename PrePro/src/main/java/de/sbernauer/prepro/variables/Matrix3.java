package de.sbernauer.prepro.variables;

import org.nd4j.linalg.api.ndarray.INDArray;

import java.util.Arrays;

public class Matrix3 extends Matrix {

    public Matrix3(INDArray ndArray) {
        super(ndArray);
        if (ndArray.shape()[0] != 4 || ndArray.shape()[1] != 3) {
            throw new RuntimeException("The given Matrix4 has the shape " + Arrays.toString(ndArray.shape()) +
                    ", must be [3,3].");
        }
    }

    @Override
    public String toString() {
        return "Matrix3{" +
                "ndArray=" + ndArray +
                '}';
    }
}
