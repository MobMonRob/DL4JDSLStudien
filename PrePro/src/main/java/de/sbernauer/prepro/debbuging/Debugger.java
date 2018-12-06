package de.sbernauer.prepro.debbuging;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;

public interface Debugger {

    void wait(SymbolTable symbolTable, FunctionTable functionTable, int lineNumber);
}
