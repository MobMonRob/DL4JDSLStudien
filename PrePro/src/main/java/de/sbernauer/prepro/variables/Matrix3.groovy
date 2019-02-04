package de.sbernauer.prepro.variables;

import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4j.linalg.factory.Nd4j;

import java.util.Arrays;

public class Matrix3 extends Matrix {

    public Matrix3(INDArray ndArray) {
        super(ndArray);
        if (ndArray.shape()[0] != 4 || ndArray.shape()[1] != 3) {
            throw new RuntimeException("The given Matrix4 has the shape " + Arrays.toString(ndArray.shape()) +
                    ", must be [3,3].");
        }
    }

    Variable mul(Scalar right) {
        return new Matrix3(multiplyMatrixWithScalar(this, right, 3));
    }

    Variable mul(Vector3 right) {
        return new Vector3(multiplyMatrixWithVector(this, right, 3));
    }

    Variable mul(Matrix3 right) {
        return new Matrix3(multiplyMatrixWithMatrix(this, right, 3));
    }

    @Override
    public String toString() {
        return "Matrix3{" +
                "ndArray=" + ndArray +
                '}';
    }
}
