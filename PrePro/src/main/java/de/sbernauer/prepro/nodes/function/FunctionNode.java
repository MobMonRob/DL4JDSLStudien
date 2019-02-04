package de.sbernauer.prepro.nodes.function;

import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.PreProNode;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.nodes.expression.ExpressionNode;
import de.sbernauer.prepro.nodes.statement.StatementListNode;
import de.sbernauer.prepro.variables.Variable;
import de.sbernauer.prepro.variables.VariableType;

import java.util.ArrayList;
import java.util.List;

public class FunctionNode implements PreProNode, Function {
    protected final List<ParameterDefinition> parameterDefinitions;
    private final String functionName;
    private final VariableType returnType; /* null, if returnType = void */
    private final ExpressionNode returnExpression;

    protected StatementListNode statementListNode;

    /**
     * @param returnType null, if function is void
     */
    public FunctionNode(String functionName, String returnType, List<ParameterDefinition> parameterDefinitions, StatementListNode statementListNode, ExpressionNode returnExpression) {
        this.functionName = functionName;
        if (returnType == null) {
            this.returnType = null;
            this.returnExpression = null;
            if (returnExpression != null) {
                throw new RuntimeException("Function " + functionName + " must have NO return statement or specify the return type with \"<funtion>() returns <type>\"");
            }
        } else {
            this.returnType = VariableType.getTypeForText(returnType);
            if (returnExpression == null) {
                throw new RuntimeException("Function " + functionName + " must have an return statement.");
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

    @Override
    public String getFunctionName() {
        return functionName;
    }

    /**
     * @return null, if the function is void
     */
    @Override
    public Variable execute(Arguments arguments, FunctionTable functionTable) {
        if (parameterDefinitions.size() != arguments.getValues().length) {
            throw new RuntimeException("Number of Argument for the function \"" + functionName + "\" differs.");
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
