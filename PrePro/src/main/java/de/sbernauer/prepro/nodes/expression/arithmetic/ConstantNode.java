package de.sbernauer.prepro.nodes.expression.arithmetic;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.nodes.expression.ExpressionNode;
import de.sbernauer.prepro.variables.Constant;
import de.sbernauer.prepro.variables.Variable;

public class ConstantNode extends ExpressionNode {

    private final Constant value;

    public ConstantNode(double value) {
        this.value = new Constant(value);
    }

    @Override
    public Variable execute(SymbolTable symbolTable, FunctionTable functionTable) {
        return value;
    }
}
