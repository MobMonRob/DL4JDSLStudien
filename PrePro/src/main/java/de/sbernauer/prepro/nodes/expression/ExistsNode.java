package de.sbernauer.prepro.nodes.expression;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.variables.Constant;
import de.sbernauer.prepro.variables.Variable;
import org.nd4j.linalg.factory.Nd4j;

public class ExistsNode extends ExpressionNode {

    private final String variableName;

    public ExistsNode(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public Variable execute(SymbolTable symbolTable, FunctionTable functionTable) {
        if (ExistsFunction.variableExists(variableName)) {
            return new Constant(Nd4j.create(new int[]{1, 1}, new double[]{1}));
        }
        return new Constant(Nd4j.create(new int[]{1, 1}, new double[]{0}));
    }
}
