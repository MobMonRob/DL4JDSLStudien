package de.sbernauer.prepro.nodes.expression;

import java.util.HashSet;
import java.util.Set;

public class ExistsFunction {

    private static Set<String> existingVariables = new HashSet<>();

    private ExistsFunction() {

    }

    public static void addExistingVariable(String variableName) {
        existingVariables.add(variableName);
    }

    public static boolean variableExists(String variableName) {
        return existingVariables.contains(variableName);
    }
}
