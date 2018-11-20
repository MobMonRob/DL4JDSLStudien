package debbuging;

import nodes.FunctionTable;
import nodes.SymbolTable;

public interface Debugger {

    void wait(SymbolTable symbolTable, FunctionTable functionTable, int lineNumber);
}
