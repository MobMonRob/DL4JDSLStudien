package de.sbernauer.prepro.nodes.expression;

import com.oracle.truffle.api.instrumentation.GenerateWrapper;
import com.oracle.truffle.api.nodes.Node;
import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.variables.Variable;

@GenerateWrapper
public abstract class ExpressionNode extends Node {

    /**
     * The execute method when no specialization is possible. This is the most general case,
     * therefore it must be provided by all subclasses.
     */
    public abstract Variable execute(SymbolTable symbolTable, FunctionTable functionTable);
}
