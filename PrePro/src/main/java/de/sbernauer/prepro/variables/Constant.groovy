package de.sbernauer.prepro.variables;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

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

    public double getDoubleValue() {
        return ndArray.getDouble(0);
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

    Vector3 add(Vector3 right) {
        return right.add(this);
    }

    Vector3 sub(Vector3 right) {
        return right.sub(this);
    }

    Vector3 mul(Vector3 right) {
        return right.mul(this);
    }

    Vector3 div(Vector3 right) {
        return right.div(this);
    }
}
