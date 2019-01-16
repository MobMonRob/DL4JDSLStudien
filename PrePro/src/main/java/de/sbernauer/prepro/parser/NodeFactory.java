package de.sbernauer.prepro.parser;

import de.sbernauer.prepro.nodes.function.FunctionNode;
import de.sbernauer.prepro.nodes.function.ImportDefinition;
import de.sbernauer.prepro.nodes.function.ParameterDefinition;
import de.sbernauer.prepro.nodes.statement.StatementNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import de.sbernauer.prepro.variables.VariableType;

import java.util.ArrayList;
import java.util.List;

public class NodeFactory {

    private List<FunctionNode> functions;
    private List<StatementNode> statements;

    public void startFunctionList() {
        functions = new ArrayList<>();
    }

    public void addFunction(FunctionNode function) {
        functions.add(function);
    }

    public FunctionNode[] getFunctionsAsArray() {
        FunctionNode[] array = new FunctionNode[functions.size()];
        functions.toArray(array);
        return array;
    }

    public void startStatementList() {
        statements = new ArrayList<>();
    }

    public void addStatement(StatementNode statement, int lineNumber) {
        statement.setLineNumber(lineNumber);
        statements.add(statement);
    }

    public StatementNode[] getStatementsAsArray() {
        StatementNode[] array = new StatementNode[statements.size()];
        statements.toArray(array);
        return array;
    }

    public ParameterDefinition createParameterDefinition(String type, String variableName) {
        return new ParameterDefinition(variableName,
                VariableType.getTypeForText(type).getVariableClass());
    }

    public ImportDefinition createImportDefinition(String type, String variableName, boolean optional) {
        return new ImportDefinition(variableName,
                VariableType.getTypeForText(type).getVariableClass(), optional);
    }
}
