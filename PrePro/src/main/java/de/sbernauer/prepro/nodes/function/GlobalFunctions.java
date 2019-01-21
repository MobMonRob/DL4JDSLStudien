package de.sbernauer.prepro.nodes.function;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.variables.Variable;

import java.util.function.BiFunction;

public abstract class GlobalFunctions {

    public static void registerGlobalFunctions(FunctionTable functionTable) {
        functionTable.addFunction(createFunction("exists", (arguments, functionTable1) -> {
            throw new RuntimeException();
        }));
    }

    private static Function createFunction(String functionName, BiFunction<Arguments, FunctionTable, Variable> function) {
        return new Function() {
            @Override
            public String getFunctionName() {
                return functionName;
            }

            @Override
            public Variable execute(Arguments arguments, FunctionTable functionTable) {
                return function.apply(arguments, functionTable);
            }
        };
    }
}
