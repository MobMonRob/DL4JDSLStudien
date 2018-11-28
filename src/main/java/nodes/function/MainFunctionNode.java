package nodes.function;

import dataset.DefaultPreProDataSet;
import dataset.PreProDataSet;
import nodes.FunctionTable;
import nodes.SymbolTable;
import nodes.statement.StatementListNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import variables.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainFunctionNode extends FunctionNode {
    private final List<ParameterDefinition> importDefinitions;
    private final List<String> exportDefinitions;

    public MainFunctionNode(String name, List<ParameterDefinition> importDefinitions, List<String> exportDefinitions, StatementListNode statementListNode) {
        super(name, null, new ArrayList<>(), statementListNode, null);

        this.importDefinitions = importDefinitions;
        this.exportDefinitions = exportDefinitions;
    }

    public PreProDataSet executeMainFunction(PreProDataSet preProDataSet, FunctionTable functionTable) {
        SymbolTable symbolTable = new SymbolTable();

        for (ParameterDefinition parameterDefinition : importDefinitions) {
            INDArray array = preProDataSet.getVariable(parameterDefinition.getVariableName());
            Variable variable = getVariableForType(parameterDefinition.getVariableType(), array);
            symbolTable.setValue(parameterDefinition.getVariableName(), variable);
        }

        statementListNode.execute(symbolTable, functionTable);

        if (exportDefinitions.size() == 0) { // No exports needed, return empty PreProDataSet
            return new DefaultPreProDataSet(new DataSet(), new ArrayList<>());
        }

        List<INDArray> variables = exportDefinitions.stream()
                .map(symbolTable::getValueOrThrowExceptionIfNotDefined)
                .map(Variable::getNdArray)
                .collect(Collectors.toList());

        return new DefaultPreProDataSet(variables, exportDefinitions);
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
        }
        throw new RuntimeException();
    }
}
