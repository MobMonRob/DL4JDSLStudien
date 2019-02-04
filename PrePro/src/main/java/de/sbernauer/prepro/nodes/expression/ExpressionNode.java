package de.sbernauer.prepro.nodes.expression;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.PreProNode;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.variables.Variable;

public abstract class ExpressionNode implements PreProNode {

    /**
     * The execute method when no specialization is possible. This is the most general case,
     * therefore it must be provided by all subclasses.
     */
    public abstract Variable execute(SymbolTable symbolTable, FunctionTable functionTable);
}
