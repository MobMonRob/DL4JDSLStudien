package variables;

import org.nd4j.linalg.api.ndarray.INDArray;

public class Vector4 extends Vector {

    public Vector4(INDArray ndArray) {
        super(ndArray);
        int size = ndArray.shape()[1];
        if (ndArray.shape().length != 2 || size != 4) {
            throw new RuntimeException("The given Vector3 has the size " + size + ", must be 3.");
        }
    }

    @Override
    public String toString() {
        return "Vector4{" +
                "ndArray=" + ndArray +
                '}';
    }
}
