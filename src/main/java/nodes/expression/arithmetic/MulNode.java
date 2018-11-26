package nodes.expression.arithmetic;

import nodes.FunctionTable;
import nodes.SymbolTable;
import nodes.expression.ExpressionNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import variables.Matrix4;
import variables.Variable;
import variables.Vector3;
import variables.Vector4;

public class MulNode extends ExpressionNode {

    private ExpressionNode left;
    private ExpressionNode right;

    public MulNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Variable execute(SymbolTable symbolTable, FunctionTable functionTable) {
        Variable leftValue = left.execute(symbolTable, functionTable);
        Variable rightValue = right.execute(symbolTable, functionTable);

        if (leftValue instanceof Vector3 && rightValue instanceof Vector3) {
            return new Vector3((leftValue).getNdArray().mul((rightValue).getNdArray()));
        } else if (leftValue instanceof Vector4 && rightValue instanceof Vector4) {
            return new Vector4((leftValue).getNdArray().mul((rightValue).getNdArray()));
        } else if (leftValue instanceof Matrix4 && rightValue instanceof Matrix4) {
            return new Matrix4(leftValue.getNdArray().mul(rightValue.getNdArray()));
        } else {
            throw new RuntimeException("Cant multiply because of wrong types");
        }
    }
}
