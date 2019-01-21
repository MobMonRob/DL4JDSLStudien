package de.sbernauer.prepro.variables

import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4j.linalg.factory.Nd4j

public class Constant extends Variable {

    public Constant(INDArray ndArray) {
        super(ndArray);
//        if (ndArray.shape().length != 2 || ndArray.shape()[0] != 1 || ndArray.shape()[1] != 1) {
//            throw new RuntimeException("A Constant must be a single value.");
//        }
    }

    @Override
    public String toString() {
        return "Constant{" +
                "ndArray=" + ndArray +
                '}';
    }
}
