package nodes.function;

import com.oracle.truffle.api.nodes.Node;
import nodes.FunctionTable;
import nodes.SymbolTable;
import nodes.expression.ExpressionNode;
import nodes.statement.StatementListNode;
import variables.Variable;
import variables.VariableType;

import java.util.ArrayList;
import java.util.List;

public class FunctionNode extends Node {
    protected final List<ParameterDefinition> parameterDefinitions;
    private final String name;
    private final VariableType returnType; /* null, if returnType = void */
    private final ExpressionNode returnExpression;

    @Child
    protected StatementListNode statementListNode;

    /**
     * @param returnType null, if function is void
     */
    public FunctionNode(String name, String returnType, List<ParameterDefinition> parameterDefinitions, StatementListNode statementListNode, ExpressionNode returnExpression) {
        this.name = name;
        if (returnType == null) {
            this.returnType = null;
            this.returnExpression = null;
            if (returnExpression != null) {
                throw new RuntimeException("Function " + name + " must have NO return statement or specify the return type with \"<funtion>() returns <type>\"");
            }
        } else {
            this.returnType = VariableType.getTypeForText(returnType);
            if (returnExpression == null) {
                throw new RuntimeException("Function " + name + " must have an return statement.");
            }
            this.returnExpression = returnExpression;
        }
        if (parameterDefinitions == null) {
            this.parameterDefinitions = new ArrayList<>();
        } else {
            this.parameterDefinitions = parameterDefinitions;
        }
        this.statementListNode = statementListNode;
    }

    public String getName() {
        return name;
    }

    /**
     * @return null, if the function is void
     */
    public Variable execute(Arguments arguments, FunctionTable functionTable) {
        if (parameterDefinitions.size() != arguments.getValues().length) {
            throw new RuntimeException("Number of Argument for the function \"" + name + "\" differs.");
        }
        SymbolTable symbolTable = new SymbolTable();
        for (int i = 0; i < parameterDefinitions.size(); i++) {

            Variable value = arguments.getValues()[i];

            if (value.getClass() != parameterDefinitions.get(i).getVariableType()) {
                throw new RuntimeException("Wrong type of parameter " + parameterDefinitions.get(i).getVariableName() + ".");
            }

            symbolTable.setValue(parameterDefinitions.get(i).getVariableName(), value);
        }
        statementListNode.execute(symbolTable, functionTable);

        if (returnType == null) { // void function
            return null;
        } else {
            return returnExpression.execute(symbolTable, functionTable);
        }
    }
}
