package de.sbernauer.prepro.dataset;

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
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilePreProDataSet implements PreProDataSet {

    public static final String CSV_SEPERATOR = ";";
    public static final int CSV_PRECISION = 9;

    private final DataSet dataSet;
    private final List<DataSetEntry> dataSetEntries;

    private HashMap<String, INDArray> constants = new HashMap<>();

    /**
     * @param dataSetEntries A List of DataSetEntries.
     *                       The DataSetEntries must cover the complete feature-matrix.
     */
    public FilePreProDataSet(DataSet dataSet, List<DataSetEntry> dataSetEntries) {
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

    public FilePreProDataSet(List<INDArray> variables, List<String> variableNames) {
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

    public FilePreProDataSet(String filePathDefaultProProDataSetFile) {
        try {
            if (!fileExists(filePathDefaultProProDataSetFile)
                    || !fileExists(filePathDefaultProProDataSetFile + ".meta")) {
                throw new RuntimeException("The files " + filePathDefaultProProDataSetFile + " and "
                        + filePathDefaultProProDataSetFile + ".meta must exist.");
            }
            INDArray features = Nd4j.readTxt(filePathDefaultProProDataSetFile, CSV_SEPERATOR);
            this.dataSet = new DataSet(features, null);

            String metaDataJsonString = new String(Files.readAllBytes(
                    Paths.get(filePathDefaultProProDataSetFile + ".meta")));
            MetaDataJsonObject metaData = new MetaDataJsonObject(metaDataJsonString);
            this.dataSetEntries = metaData.dataSetEntries;
            this.constants = metaData.constants;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean fileExists(String filePath) {
        File f = new File(filePath);
        return (f.exists() && !f.isDirectory());
    }

    private boolean constantExists(String constantName) {
        return constants.containsKey(constantName);
    }

    private boolean timeSeriesExists(String variableName) {
        return dataSetEntries.stream()
                .map(DataSetEntry::getVariableName)
                .anyMatch(variableName::equals);
    }

    @Override
    public INDArray getVariable(String variableName) {
        if (timeSeriesExists(variableName)) {
            for (DataSetEntry dataSetEntry : dataSetEntries) {
                if (variableName.equals(dataSetEntry.getVariableName())) {
                    int startColumn = dataSetEntry.getStartColumn();
                    int endColumn = startColumn + dataSetEntry.getLength();

                    return dataSet.getFeatures()
                            .get(NDArrayIndex.all(), NDArrayIndex.interval(startColumn, endColumn))
                            .reshape(dataSetEntry.getVariableShape());
                }
            }
        } else if (constantExists(variableName)) {
            return constants.get(variableName);
        }
        throw new RuntimeException("Variable " + variableName + " not found in the DataSet.");
    }

    @Override
    public Set<String> getVariableNames() {
        Set<String> result = dataSetEntries.stream()
                .map(DataSetEntry::getVariableName)
                .collect(Collectors.toSet());
        result.addAll(constants.keySet());
        return result;
    }

    @Override
    public boolean variableExists(String variableName) {
        return constantExists(variableName) || timeSeriesExists(variableName);
    }

    @Override
    public void addConstant(String constantName, INDArray value) {
        if (variableExists(constantName)) {
            throw new RuntimeException("The variable " + constantName + " already exists.");
        }
        constants.put(constantName, value);
    }

    @Override
    public void writeDataSetToFile(String filePathData) {
        writeDataSetToFile(filePathData, filePathData + ".meta");
    }

    public void writeDataSetToFile(String filePathData, String filePathMetaData) {
        try {
            Nd4j.writeTxt(dataSet.getFeatures(), filePathData, CSV_SEPERATOR, CSV_PRECISION);

            MetaDataJsonObject metaData = new MetaDataJsonObject(dataSetEntries, constants);

            PrintWriter printWriter = new PrintWriter(new FileOutputStream(filePathMetaData));
            printWriter.println(metaData.getJsonString());
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
                "constants=" + constants.toString() + "\n\n" +
                "calculated_variables=\n" + stringBuilderVariables.toString() +
                '}';
    }
}
