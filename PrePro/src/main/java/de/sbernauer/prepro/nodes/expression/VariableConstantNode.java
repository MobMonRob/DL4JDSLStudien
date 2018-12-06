package de.sbernauer.prepro.nodes.expression;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.variables.Variable;

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
