package de.sbernauer.prepro.nodes.statement;

import com.oracle.truffle.api.nodes.Node;
import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;

public abstract class StatementNode extends Node {
    private int lineNumber;

    public abstract void execute(SymbolTable symbolTable, FunctionTable functionTable);

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void reportError(String message) {
        throw new RuntimeException("[Line " + lineNumber + "]: " + message);
    }
}
