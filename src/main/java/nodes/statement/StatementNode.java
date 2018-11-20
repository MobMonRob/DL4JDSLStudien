package nodes.statement;

import com.oracle.truffle.api.nodes.Node;
import nodes.SymbolTable;

public abstract class StatementNode extends Node {
    private int lineNumber;

    public abstract void execute(SymbolTable symbolTable);

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
