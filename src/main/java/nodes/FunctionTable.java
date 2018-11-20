package nodes;

import nodes.function.FunctionNode;

import java.util.HashMap;

public class FunctionTable {

    private HashMap<String, FunctionNode> functions = new HashMap<>();

    public void addFunction(FunctionNode function) {
        if (functions.containsKey(function.getName())) {
            throw new RuntimeException("The function " + function.getName() + " is already defined.");
        }
        functions.put(function.getName(), function);
    }

    public FunctionNode getFunction(String name) {
        FunctionNode functionNode = functions.get(name);
        if (functionNode == null) {
            throw new RuntimeException("The function \"" + name + "\" is not defined.");
        }
        return functionNode;
    }

    public void reset() {
        functions.clear();
    }
}
