package de.sbernauer.prepro.nodes.function;

public class ParameterDefinition {
    private final String variableName;
    private final Class variableType;

    public ParameterDefinition(String variableName, Class variableType) {
        this.variableName = variableName;
        this.variableType = variableType;
    }

    public String getVariableName() {
        return variableName;
    }

    public Class getVariableType() {
        return variableType;
    }
}
