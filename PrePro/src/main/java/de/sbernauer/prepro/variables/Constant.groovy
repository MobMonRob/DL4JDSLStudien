package de.sbernauer.prepro.variables

import org.nd4j.linalg.api.ndarray.INDArray

public class Constant extends Variable {

    public Constant(INDArray ndArray) {
        super(ndArray);
    }

    @Override
    public String toString() {
        return "Constant{" +
                "ndArray=" + ndArray +
                '}';
    }
}
