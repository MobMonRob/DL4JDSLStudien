package de.sbernauer.prepro.nodes;

import de.sbernauer.prepro.nodes.function.Function;

import java.util.HashMap;

public class FunctionTable {

    private HashMap<String, Function> functions = new HashMap<>();

    public void addFunction(Function function) {
        addFunction(function, true);
    }

    public void addFunction(Function function, boolean checkIfAlreadyEsists) {
        if (functions.containsKey(function.getFunctionName())) {
            if (checkIfAlreadyEsists) {
                throw new RuntimeException("The function " + function.getFunctionName() + " is already defined.");
            } else {
                System.out.println("[Warning] Overwriting function '" + function.getFunctionName() + "'");
            }
        }
        functions.put(function.getFunctionName(), function);
    }

    public Function getFunction(String functionName) {
        Function function = functions.get(functionName);
        if (function == null) {
            throw new RuntimeException("The function \"" + functionName + "\" is not defined.");
        }
        return function;
    }
}
