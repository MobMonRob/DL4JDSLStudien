package de.sbernauer.prepro.nodes.function;

import de.sbernauer.prepro.variables.Variable;

public class Arguments {
    private final Variable[] values;

    public Arguments(Variable[] values) {
        this.values = values;
    }

    public Variable[] getValues() {
        return values;
    }
}
