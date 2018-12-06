package de.sbernauer.prepro.variables;

import org.nd4j.linalg.api.ndarray.INDArray;

public abstract class Variable {
    protected final INDArray ndArray;

    public Variable(INDArray ndArray) {
        this.ndArray = ndArray;
    }

    public INDArray getNdArray() {
        return ndArray;
    }

    public int getAmountTimeElements() {
        return ndArray.shape()[0];
    }
}
