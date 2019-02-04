package de.sbernauer.prepro.variables

import org.bytedeco.javacpp.annotation.Const
import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4j.linalg.factory.Nd4j

public class Constant extends Variable {

    public Constant(INDArray ndArray) {
        super(ndArray);
    }

    public Constant(double value) {
        this(Nd4j.create([value] as double[], [1, 1] as int[]));
    }

    @Override
    public String toString() {
        return "Constant{" +
                "ndArray=" + ndArray +
                '}';
    }

    Constant add(Constant right) {
        if (ndArray.length() != 1 || right.ndArray.length() != 1) {
            throw new RuntimeException("Can only add Constant with double value.");
        }
        return new Constant(ndArray.add(right.ndArray));
    }

    Constant sub(Constant right) {
        if (ndArray.length() != 1 || right.ndArray.length() != 1) {
            throw new RuntimeException("Can only subtract Constant with double value.");
        }
        return new Constant(ndArray.sub(right.ndArray));
    }

    Constant mul(Constant right) {
        if (ndArray.length() != 1 || right.ndArray.length() != 1) {
            throw new RuntimeException("Can only multiply Constant with double value.");
        }
        return new Constant(ndArray.mul(right.ndArray));
    }

    Constant div(Constant right) {
        if (ndArray.length() != 1 || right.ndArray.length() != 1) {
            throw new RuntimeException("Can only divide Constant with double value.");
        }
        return new Constant(ndArray.div(right.ndArray));
    }
}
