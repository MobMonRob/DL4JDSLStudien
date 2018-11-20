package nodes.expression;

import com.oracle.truffle.api.instrumentation.GenerateWrapper;
import com.oracle.truffle.api.nodes.Node;
import nodes.FunctionTable;
import nodes.SymbolTable;
import variables.Variable;

@GenerateWrapper
public abstract class ExpressionNode extends Node {

    /**
     * The execute method when no specialization is possible. This is the most general case,
     * therefore it must be provided by all subclasses.
     */
    public abstract Variable execute(SymbolTable symbolTable, FunctionTable functionTable);
}
