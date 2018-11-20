package variables;

import org.nd4j.linalg.api.ndarray.INDArray;

public class Matrix extends Variable {

    public Matrix(INDArray ndArray) {
        super(ndArray);
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "ndArray=" + ndArray +
                '}';
    }
}
