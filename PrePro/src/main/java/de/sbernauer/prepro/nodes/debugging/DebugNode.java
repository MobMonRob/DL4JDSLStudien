package de.sbernauer.prepro.nodes.debugging;

import de.sbernauer.prepro.debbuging.DebuggerInstance;
import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.nodes.statement.StatementNode;

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
