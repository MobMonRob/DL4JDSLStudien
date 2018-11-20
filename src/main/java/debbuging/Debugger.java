package debbuging;

import nodes.SymbolTable;

public interface Debugger {

    void wait(SymbolTable symbolTable, int lineNumber);
}
