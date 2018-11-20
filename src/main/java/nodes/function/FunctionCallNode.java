package nodes.function;

import nodes.FunctionTable;
import nodes.SymbolTable;
import nodes.expression.ExpressionNode;
import nodes.statement.StatementNode;
import variables.Variable;

import java.util.List;

public class FunctionCallNode extends ExpressionNode {

    private final String functionName;
    private final List<ExpressionNode> parameters;

    private final FunctionTable functionTable = FunctionTable.getInstance();

    public FunctionCallNode(String functionName, List<ExpressionNode> parameters) {
        this.functionName = functionName;
        this.parameters = parameters;
    }

    @Override
    public Variable execute(SymbolTable symbolTable) {
        Variable[] values = new Variable[parameters.size()];
        for(int i = 0; i < parameters.size(); i++) {
            values[i] = parameters.get(i).execute(symbolTable);
        }

        Arguments arguments = new Arguments(values);
        return functionTable.getFunction(functionName).execute(arguments);
    }

    public String getFunctionName() {
        return functionName;
    }
}
