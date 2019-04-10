package de.sbernauer.prepro.nodes.statement;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.nodes.expression.ExpressionNode;
import de.sbernauer.prepro.variables.Variable;

public class ThrowStatementNode extends ExpressionNode {
    private String message;

    public ThrowStatementNode(String message) {
        this.message = message;
    }

    public Variable execute(SymbolTable symbolTable, FunctionTable functionTable) {
        throw new ThrowFromPreProException(message);
    }
}