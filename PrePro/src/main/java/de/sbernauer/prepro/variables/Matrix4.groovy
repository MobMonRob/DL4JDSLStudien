package de.sbernauer.prepro.variables

import org.nd4j.linalg.api.ndarray.INDArray

public class Matrix4 extends Matrix {

    public Matrix4(INDArray ndArray) {
        super(ndArray);
        if (ndArray.shape()[0] != 4 || ndArray.shape()[1] != 4) {
            throw new RuntimeException("The given Matrix4 has the shape " + Arrays.toString(ndArray.shape()) +
                    ", must be [4,4].");
        }
    }

    public Variable add(Matrix4 right) {
        return new Matrix4(ndArray.add(right.ndArray));
    }

    public Variable sub(Matrix4 right) {
        return new Matrix4(ndArray.sub(right.ndArray));
    }

    public Variable mul(Matrix4 right) {
        return new Matrix4(multiplyMatrixWithMatrix(this, right, 4));
    }

    @Override
    public String toString() {
        return "Matrix4{" +
                "ndArray=" + ndArray +
                '}';
    }
}
