package de.sbernauer.prepro.nodes.statement;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.PreProNode;
import de.sbernauer.prepro.nodes.SymbolTable;

public abstract class StatementNode implements PreProNode {
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
