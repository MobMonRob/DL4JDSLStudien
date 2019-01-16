package de.sbernauer.prepro.nodes.function;

import de.sbernauer.prepro.dataset.FilePreProDataSet;
import de.sbernauer.prepro.dataset.PreProDataSet;
import de.sbernauer.prepro.nodes.FunctionTable;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.nodes.expression.ExistsFunction;
import de.sbernauer.prepro.nodes.statement.StatementListNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import de.sbernauer.prepro.variables.*;

import java.util.ArrayList;
import java.util.List;

public class MainFunctionNode extends FunctionNode {
    private final List<ImportDefinition> importDefinitions;
    private final List<String> exportDefinitions;

    public MainFunctionNode(String name, List<ImportDefinition> importDefinitions, List<String> exportDefinitions, StatementListNode statementListNode) {
        super(name, null, new ArrayList<>(), statementListNode, null);

        this.importDefinitions = importDefinitions;
        this.exportDefinitions = exportDefinitions;
    }

    public PreProDataSet executeMainFunction(PreProDataSet preProDataSet, FunctionTable functionTable) {
        SymbolTable symbolTable = new SymbolTable();

        for (ImportDefinition importDefinition : importDefinitions) {
            if(importDefinition.isOptional() && !preProDataSet.variableExists(importDefinition.getVariableName())) {
                continue;
            }
            INDArray array = preProDataSet.getVariable(importDefinition.getVariableName());
            Variable variable = getVariableForType(importDefinition.getVariableType(), array);
            symbolTable.setValue(importDefinition.getVariableName(), variable);
            ExistsFunction.addExistingVariable(importDefinition.getVariableName());
        }

        statementListNode.execute(symbolTable, functionTable);

        if (exportDefinitions.size() == 0) { // No exports needed, return empty PreProDataSet
            return new FilePreProDataSet(new DataSet(), new ArrayList<>());
        }

        List<INDArray> timeSeries = new ArrayList<>();
        List<String> timeSeriesNames = new ArrayList<>();
        List<INDArray> constants = new ArrayList<>();
        List<String> constantNames = new ArrayList<>();

        for (String variableName : exportDefinitions) {
            Variable variable = symbolTable.getValueOrThrowExceptionIfNotDefined(variableName);

            if (variable instanceof Constant) {
                constants.add(variable.getNdArray());
                constantNames.add(variableName);
            } else {
                timeSeries.add(variable.getNdArray());
                timeSeriesNames.add(variableName);
            }
        }

        PreProDataSet dataSet = new FilePreProDataSet(timeSeries, timeSeriesNames);
        for(int i = 0; i < constants.size(); i++) {
            dataSet.addConstant(constantNames.get(i), constants.get(i));
        }

        return dataSet;
    }

    private Variable getVariableForType(Class type, INDArray array) {
        if (type == Vector3.class) {
            return new Vector3(array);
        } else if (type == Vector4.class) {
            return new Vector4(array);
        } else if (type == Vector.class) {
            return new Vector(array);
        } else if (type == Matrix3.class) {
            return new Matrix3(array);
        } else if (type == Matrix4.class) {
            return new Matrix4(array);
        } else if (type == Matrix.class) {
            return new Matrix(array);
        } else if (type == Scalar.class) {
            return new Scalar(array);
        } else if (type == Constant.class) {
            return new Constant(array);
        }
        throw new RuntimeException();
    }
}
