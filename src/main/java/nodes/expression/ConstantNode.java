package nodes.expression;

import nodes.FunctionTable;
import nodes.SymbolTable;
import variables.Variable;

public class ConstantNode extends ExpressionNode {
    private Variable value;

    public ConstantNode(Variable value) {
        this.value = value;
    }

    @Override
    public Variable execute(SymbolTable symbolTable, FunctionTable functionTable) {
        return value;
    }
}
