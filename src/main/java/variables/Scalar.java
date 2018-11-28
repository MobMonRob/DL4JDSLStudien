package variables;

import org.nd4j.linalg.api.ndarray.INDArray;

public class Scalar extends Variable {
    public Scalar(INDArray ndArray) {
        super(ndArray);
        int size = ndArray.shape()[1];
        if (ndArray.shape().length != 2 || size != 1) {
            throw new RuntimeException("The given Scalar has the size " + size + ", must be 1.");
        }
    }

    @Override
    public String toString() {
        return "Scalar{" +
                "ndArray=" + ndArray +
                '}';
    }
}
