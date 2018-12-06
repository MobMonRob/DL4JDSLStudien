package de.sbernauer.prepro.nodes;

import de.sbernauer.prepro.nodes.function.Function;

import java.util.HashMap;

public class FunctionTable {

    private HashMap<String, Function> functions = new HashMap<>();

    public void addFunction(Function function) {
        if (functions.containsKey(function.getFunctionName())) {
            throw new RuntimeException("The function " + function.getFunctionName() + " is already defined.");
        }
        functions.put(function.getFunctionName(), function);
    }

    public Function getFunction(String name) {
        Function function = functions.get(name);
        if (function == null) {
            throw new RuntimeException("The function \"" + name + "\" is not defined.");
        }
        return function;
    }
}
