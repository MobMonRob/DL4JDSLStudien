package de.sbernauer.prepro.nodes;

import de.sbernauer.prepro.variables.Variable;

import java.util.HashMap;

public class SymbolTable {
    private final HashMap<String, Variable> variables = new HashMap<>();

    public boolean variableExists(String variableName) {
        return variables.containsKey(variableName);
    }

    private Variable getValue(String variableName) {
        return variables.get(variableName);
    }

    public Variable getValueOrThrowExceptionIfNotDefined(String variableName) {
        if (variableExists(variableName)) {
            return getValue(variableName);
        } else {
            throw new RuntimeException("Variable " + variableName + " is not defined");
        }
    }

    public void setValue(String variableName, Variable value) {
        variables.put(variableName, value);
    }

    @Override
    public String toString() {
        return "SymbolTable{" +
                "variables=" + variables +
                '}';
    }
}
