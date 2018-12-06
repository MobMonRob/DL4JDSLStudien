package de.sbernauer.prepro.nodes.expression;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.variables.Variable;

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
