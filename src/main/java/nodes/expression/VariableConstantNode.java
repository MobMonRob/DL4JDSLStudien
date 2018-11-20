package nodes.expression;

import nodes.SymbolTable;
import variables.Variable;

public class VariableConstantNode extends ExpressionNode {
    private final String variableName;

    public VariableConstantNode(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public Variable execute(SymbolTable symbolTable) {
        return symbolTable.getValueOrThrowExceptionIfNotDefined(variableName);
    }
}
