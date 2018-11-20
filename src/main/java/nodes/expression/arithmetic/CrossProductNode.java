package nodes.expression.arithmetic;

import nodes.FunctionTable;
import nodes.SymbolTable;
import nodes.expression.ExpressionNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import variables.Variable;
import variables.Vector3;

public class CrossProductNode extends ExpressionNode {

    private ExpressionNode left;
    private ExpressionNode right;

    public CrossProductNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Variable execute(SymbolTable symbolTable, FunctionTable functionTable) {
        Variable leftValue = left.execute(symbolTable, functionTable);
        Variable rightValue = right.execute(symbolTable, functionTable);

        if (leftValue instanceof Vector3 && rightValue instanceof Vector3) {
            return crossProduct((Vector3) leftValue, (Vector3) rightValue);
        } else {
            throw new RuntimeException("Can't do cross product because of wrong types");
        }
    }

    private Vector3 crossProduct(Vector3 left, Vector3 right) {
        INDArray a = left.getNdArray();
        INDArray b = right.getNdArray();

        INDArray a1 = a.getColumn(0);
        INDArray a2 = a.getColumn(1);
        INDArray a3 = a.getColumn(2);

        INDArray b1 = b.getColumn(0);
        INDArray b2 = b.getColumn(1);
        INDArray b3 = b.getColumn(2);

        INDArray c1 = (a2.mul(b3)).sub(a3.mul(b2));
        INDArray c2 = (a3.mul(b1)).sub(a1.mul(b3));
        INDArray c3 = (a1.mul(b2)).sub(a2.mul(b1));

        int size = a.shape()[0];
        INDArray result = Nd4j.create(size, 3);
        result.putColumn(0, c1);
        result.putColumn(1, c2);
        result.putColumn(2, c3);

        return new Vector3(result);
    }

    private Vector3 crossProductSlow(Vector3 left, Vector3 right) {
        INDArray a = left.getNdArray();
        INDArray b = right.getNdArray();

        int size = a.shape()[0];
        double[] result = new double[size * 3];

        for (int i = 0; i < size; i++) {
            result[i * 3 + 0] = a.getDouble(i, 1) * b.getDouble(i, 2) - a.getDouble(i, 2) * b.getDouble(i, 1);
            result[i * 3 + 1] = a.getDouble(i, 2) * b.getDouble(i, 0) - a.getDouble(i, 0) * b.getDouble(i, 2);
            result[i * 3 + 2] = a.getDouble(i, 0) * b.getDouble(i, 1) - a.getDouble(i, 1) * b.getDouble(i, 0);
        }
        return new Vector3(Nd4j.create(result, new int[]{size, 3}));
    }
}

