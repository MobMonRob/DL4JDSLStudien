package de.sbernauer.prepro.nodes.function;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.variables.Variable;

public interface Function {
    String getFunctionName();

    Variable execute(Arguments arguments, FunctionTable functionTable);

}
