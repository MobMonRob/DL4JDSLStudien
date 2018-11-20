package nodes.debugging;

import debbuging.DebuggerInstance;
import nodes.FunctionTable;
import nodes.SymbolTable;
import nodes.statement.StatementNode;

public class DebugNode extends StatementNode {
    private final DebuggerInstance debuggerInstance = DebuggerInstance.getInstance();

    private final int lineNumber;

    public DebugNode(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(SymbolTable symbolTable, FunctionTable functionTable) {
        debuggerInstance.wait(symbolTable, functionTable, lineNumber);
    }
}
