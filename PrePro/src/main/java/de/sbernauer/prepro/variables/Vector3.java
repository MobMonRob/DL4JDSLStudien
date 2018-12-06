package de.sbernauer.prepro.variables;

import org.nd4j.linalg.api.ndarray.INDArray;

public class Vector3 extends Vector {

    public Vector3(INDArray ndArray) {
        super(ndArray);
        int size = ndArray.shape()[1];
        if (ndArray.shape().length != 2 || size != 3) {
            throw new RuntimeException("The given Vector3 has the size " + size + ", must be 3.");
        }
    }

    @Override
    public String toString() {
        return "Vector3{" +
                "ndArray=" + ndArray +
                '}';
    }
}
