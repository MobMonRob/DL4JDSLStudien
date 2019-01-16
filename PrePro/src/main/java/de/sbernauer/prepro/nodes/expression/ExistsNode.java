package de.sbernauer.prepro.nodes.expression;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.variables.Constant;
import de.sbernauer.prepro.variables.Variable;

public class ExistsNode extends ExpressionNode {

    private final String variableName;

    public ExistsNode(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public Variable execute(SymbolTable symbolTable, FunctionTable functionTable) {
        if (ExistsFunction.variableExists(variableName)) {
            return new Constant(1);
        }
        return new Constant(0);
    }
}
