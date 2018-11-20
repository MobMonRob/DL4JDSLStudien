package nodes.function;

import main.PreProDataSet;
import nodes.SymbolTable;
import nodes.statement.StatementListNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import variables.Variable;
import variables.Vector3;

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

    public PreProDataSet executeMainFunction(PreProDataSet preProDataSet) {
        SymbolTable symbolTable = new SymbolTable();

        for (ParameterDefinition parameterDefinition : importDefinitions) {
            INDArray array = preProDataSet.getVariable(parameterDefinition.getVariableName());
            Variable variable = getVariableForType(parameterDefinition.getVariableType(), array);
            symbolTable.setValue(parameterDefinition.getVariableName(), variable);
        }

        statementListNode.execute(symbolTable);

        if (exportDefinitions.size() == 0) { // No exports needed, return empty PreProDataSet
            return new PreProDataSet(new DataSet(), new String[0], new int[0][0]);
        }

        List<INDArray> variables = exportDefinitions.stream()
                .map(symbolTable::getValueOrThrowExceptionIfNotDefined)
                .map(Variable::getNdArray)
                .collect(Collectors.toList());

        return new PreProDataSet(variables, exportDefinitions);
    }

    private Variable getVariableForType(Class type, INDArray array) {
        if (type == Vector3.class) {
            return new Vector3(array);
        }
        throw new RuntimeException();
    }

//    public void execute(Arguments arguments) {
//        if (parameterDefinitions.size() != arguments.getValues().length) {
//            throw new RuntimeException("Number of Argument for the function \"" + name + "\" differs.");
//        }
//        SymbolTable symbolTable = new SymbolTable();
//        for (int i = 0; i < parameterDefinitions.size(); i++) {
//
//            Variable value = arguments.getValues()[i];
//
//            if (value.getClass() != parameterDefinitions.get(i).getVariableType()) {
//                throw new RuntimeException("Wrong type of parameter " + parameterDefinitions.get(i).getVariableName() + ".");
//            }
//
//            symbolTable.setValue(parameterDefinitions.get(i).getVariableName(), value);
//        }
//        statementListNode.execute(symbolTable);
//    }
}
