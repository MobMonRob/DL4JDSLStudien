package de.sbernauer.prepro.parser;

import de.sbernauer.prepro.nodes.function.FunctionNode;
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
    private List<Float> arrayValues = new ArrayList<>();
    private int actualArrayHeight;
    private int actualArrayWidth;
    private int arrayWidth;

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

    public void startArray() {
        arrayValues.clear();
        arrayWidth = 0;
        actualArrayWidth = 0;
        actualArrayHeight = 0;
    }

    public void addValueToArray(String value) {
        arrayValues.add(Float.parseFloat(value));
        actualArrayWidth++;
    }

    public void startNewRowInArray() {
        if (arrayWidth == 0) {
            arrayWidth = actualArrayWidth;
        }
        if (actualArrayWidth != arrayWidth) {
            throw new RuntimeException("The given Array has in the row " + actualArrayHeight
                    + " the invalid width of " + actualArrayWidth + ", must be " + arrayWidth);
        }
        actualArrayHeight++;
        actualArrayWidth = 0;
    }

    public INDArray finishArray() {
        float[] values = new float[arrayValues.size()];
        for (int i = 0; i < arrayValues.size(); i++) {
            values[i] = arrayValues.get(i);
        }

        return Nd4j.create(values, new int[]{actualArrayHeight, arrayWidth});
    }

    public ParameterDefinition createParameterDefiniton(String type, String variableName) {
        return new ParameterDefinition(variableName,
                VariableType.getTypeForText(type).getVariableClass());
    }
}
