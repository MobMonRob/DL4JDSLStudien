package de.sbernauer.prepro.nodes.function;

public class ImportDefinition extends ParameterDefinition {
    private final boolean optional;

    public ImportDefinition(String variableName, Class variableType, boolean optional) {
        super(variableName, variableType);
        this.optional = optional;
    }

    public boolean isOptional() {
        return optional;
    }
}
