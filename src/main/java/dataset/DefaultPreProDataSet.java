package dataset;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.indexing.NDArrayIndex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultPreProDataSet implements PreProDataSet {

    private static final String CSV_SPERATOR = ";";
    private static final int CSV_PRECISION = 9;

    private final DataSet dataSet;
    private final List<DataSetEntry> dataSetEntries;

    /**
     * @param dataSetEntries A List of DataSetEntries.
     *                       The DataSetEntries must cover the complete feature-matrix.
     *                       //     * @param workOnCopy     If true it will clone the DataSet and work on a copy.
     *                       //     *                       This is useful, if the DataSet is used later on.
     */
    public DefaultPreProDataSet(DataSet dataSet, List<DataSetEntry> dataSetEntries) {
        if (dataSetEntries.isEmpty()) {
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
            throw new RuntimeException("The lists of variables and variableNames must have the same size.");
        }

        int amountTimeElements = variables.get(0).shape()[0];
        for (int i = 0; i < variables.size(); i++) {
            INDArray array = variables.get(i);
            if (array.shape()[0] != amountTimeElements) {
                throw new RuntimeException("The variable " + variableNames.get(i) + " in the DataSet had " +
                        array.shape()[0] + " time elements, but the variable " + variableNames.get(0) +
                        " had " + amountTimeElements +
                        " time elements. All variables must have the same amount of time elements.");
            }
            if (array.length() % amountTimeElements != 0) {
                throw new RuntimeException(); // Will this ever be thrown?
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

    public DefaultPreProDataSet(String filePathDefaultProProDataSetFile) {
        try {
            if (!fileExists(filePathDefaultProProDataSetFile)
                    || !fileExists(filePathDefaultProProDataSetFile + ".meta")) {
                throw new RuntimeException("The files " + filePathDefaultProProDataSetFile + " and "
                        + filePathDefaultProProDataSetFile + ".meta must exist.");
            }
            INDArray features = Nd4j.readTxt(filePathDefaultProProDataSetFile, CSV_SPERATOR);
            this.dataSet = new DataSet(features, null);
            String dataSetEntriesJsonString = new String(Files.readAllBytes(Paths.get(filePathDefaultProProDataSetFile + ".meta")));
            this.dataSetEntries = new ObjectMapper().readValue(dataSetEntriesJsonString,
                    new TypeReference<List<DataSetEntry>>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    private boolean fileExists(String filePath) {
        File f = new File(filePath);
        return (f.exists() && !f.isDirectory());
    }

    @Override
    public List<String> getVariableNames() {
        return dataSetEntries.stream()
                .map(DataSetEntry::getVariableName)
                .collect(Collectors.toList());
    }

    @Override
    public void writeDataSetToFile(String filePathData) {
        writeDataSetToFile(filePathData, filePathData + ".meta");
    }

    public void writeDataSetToFile(String filePathData, String filePathMetaData) {
        try {
            Nd4j.writeTxt(dataSet.getFeatures(), filePathData, CSV_SPERATOR, CSV_PRECISION);

            ObjectMapper mapper = new ObjectMapper();
            String dataSetEntriesJsonString = mapper.writeValueAsString(this.dataSetEntries);
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(filePathMetaData));
            printWriter.println(dataSetEntriesJsonString);
            printWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilderVariables = new StringBuilder();
        for (String variableName : getVariableNames()) {
            stringBuilderVariables.append(variableName + "=" + getVariable(variableName).toString() + "\n");
        }
        return "DefaultPreProDataSet{\n" +
                "dataSetEntries=\n" + dataSetEntries + ",\n" +
                "dataSet=\n" + dataSet.getFeatures().toString() + "\n\n" +
                "calculated_variables=\n" + stringBuilderVariables.toString() +
                '}';
    }
}
