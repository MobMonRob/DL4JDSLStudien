package dataset;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.indexing.NDArrayIndex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultPreProDataSet implements PreProDataSet {

    private final DataSet dataSet;
    private final List<DataSetEntry> dataSetEntries;

    /**
     * @param dataSetEntries A List of DataSetEntries.
     *                       The DataSetEntries must cover the complete feature-matrix.
     *                       //     * @param workOnCopy     If true it will clone the DataSet and work on a copy.
     *                       //     *                       This is useful, if the DataSet is used later on.
     */
    public DefaultPreProDataSet(DataSet dataSet, List<DataSetEntry> dataSetEntries) {
        if (dataSetEntries.isEmpty()) { // Empty DataSet
            this.dataSet = dataSet;
            this.dataSetEntries = new ArrayList<>();
            return;
        }

        int amountColumns = dataSet.getFeatures().shape()[1];

        int nextColumn = 0;
        for (DataSetEntry dataSetEntry : dataSetEntries) {
            if (dataSetEntry.getStartColumn() != nextColumn) {
                throw new RuntimeException();
            }
            nextColumn += dataSetEntry.getLength();
        }
        if (nextColumn != amountColumns) {
            throw new RuntimeException();
        }

        this.dataSetEntries = dataSetEntries;
        this.dataSet = dataSet;
    }

    public DefaultPreProDataSet(List<INDArray> variables, List<String> variableNames) {
        if (variables.size() == 0 || (variables.size() != variableNames.size())) {
            throw new RuntimeException();
        }

        int amountTimeElements = variables.get(0).shape()[0];
        for (INDArray array : variables) {
            if (array.shape()[0] != amountTimeElements) {
                throw new RuntimeException();
            }
            if (array.length() % amountTimeElements != 0) {
                throw new RuntimeException(); // Will this ever be catched?
            }
        }

        int amountTotalElements = variables.stream()
                .mapToInt(INDArray::length)
                .sum();
        int amountColumns = amountTotalElements / amountTimeElements;

        INDArray features = Nd4j.create(amountTimeElements, amountColumns);

        this.dataSet = new DataSet(features, null);
        this.dataSetEntries = new ArrayList<>();
        int columnCounter = 0;
        for (int i = 0; i < variables.size(); i++) {
            INDArray variable = variables.get(i);
            int widthInColumns = variable.length() / amountTimeElements;

            features.get(NDArrayIndex.all(), NDArrayIndex.interval(columnCounter, columnCounter + widthInColumns))
                    .assign(variable);

            this.dataSetEntries.add(new DataSetEntry(variableNames.get(i),
                    variables.get(i).shape(), columnCounter, widthInColumns));

            columnCounter += widthInColumns;
        }
    }

    @Override
    public INDArray getVariable(String variableName) {
        for (DataSetEntry dataSetEntry : dataSetEntries) {
            if (variableName.equals(dataSetEntry.getVariableName())) {
                int startColumn = dataSetEntry.getStartColumn();
                int endColumn = startColumn + dataSetEntry.getLength();

                return dataSet.getFeatures()
                        .get(NDArrayIndex.all(), NDArrayIndex.interval(startColumn, endColumn))
                        .reshape(dataSetEntry.getVariableShape());
            }
        }
        throw new RuntimeException("Variable " + variableName + " not found in the DataSet.");
    }

    @Override
    public List<String> getVariableNames() {
        return dataSetEntries.stream()
                .map(DataSetEntry::getVariableName)
                .collect(Collectors.toList());
    }

    private int[][] getVariableShapes() {
        return dataSetEntries.stream()
                .map(DataSetEntry::getVariableShape)
                .toArray(int[][]::new);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilderVariables = new StringBuilder();
        for(String variableName : getVariableNames()) {
            stringBuilderVariables.append(variableName + "=" + getVariable(variableName).toString() + "\n");
        }
        return "DefaultPreProDataSet{\n" +
                "dataSetEntries=\n" + dataSetEntries + ",\n" +
                "dataSet=\n" + dataSet.getFeatures().toString() + "\n\n" +
                "calculated_variables=\n" + stringBuilderVariables.toString() +
                '}';
    }
}
