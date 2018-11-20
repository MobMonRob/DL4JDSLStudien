package nodes.function;

import variables.Variable;

public class Arguments {
    private final Variable[] values;

    public Arguments(Variable[] values) {
        this.values = values;
    }

    public Variable[] getValues() {
        return values;
    }
}
