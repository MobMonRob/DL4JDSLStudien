package nodes.expression;

import nodes.FunctionTable;
import nodes.SymbolTable;
import variables.Variable;

public class VariableConstantNode extends ExpressionNode {
    private final String variableName;

    public VariableConstantNode(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public Variable execute(SymbolTable symbolTable, FunctionTable functionTable) {
        return symbolTable.getValueOrThrowExceptionIfNotDefined(variableName);
    }
}
