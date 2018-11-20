package nodes.expression.arithmetic;

import nodes.FunctionTable;
import nodes.SymbolTable;
import nodes.expression.ExpressionNode;
import variables.Variable;
import variables.Vector3;

public class DivNode extends ExpressionNode {

    private ExpressionNode left;
    private ExpressionNode right;

    public DivNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Variable execute(SymbolTable symbolTable, FunctionTable functionTable) {
        Variable leftValue = left.execute(symbolTable, functionTable);
        Variable rightValue = right.execute(symbolTable, functionTable);

        if (leftValue instanceof Vector3 && rightValue instanceof Vector3) {
            return new Vector3(((Vector3) leftValue).getNdArray().div(((Vector3) rightValue).getNdArray()));
        } else {
            throw new RuntimeException("Cant divide because of wrong types");
        }
    }
}
