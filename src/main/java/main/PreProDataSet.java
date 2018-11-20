package main;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.factory.Nd4j;

import java.util.Arrays;
import java.util.List;

public class PreProDataSet {
    private final DataSet dataSet;
    private final String[] variableNames;
    private final int[][] variableShapes;

    public PreProDataSet(DataSet dataSet, String[] variableNames, int[][] variableShapes) {
        this.dataSet = dataSet;
        this.variableNames = variableNames;
        this.variableShapes = variableShapes;
    }

    public PreProDataSet(List<INDArray> variables, List<String> variableNames) {
        assert variables.size() > 0;
        assert variables.size() == variableNames.size();

        int maxCountDataElements = variables.stream()
                .mapToInt(INDArray::length)
                .max()
                .orElse(0);

        INDArray features = Nd4j.create(new int[]{variables.size(), maxCountDataElements});
        int[][] variableShapes = new int[variables.size()][];
        for (int i = 0; i < variables.size(); i++) {
            features.putRow(i, variables.get(i));
            variableShapes[i] = variables.get(i).shape();
        }
        this.dataSet = new DataSet(features, null);
        this.variableNames = variableNames.toArray(new String[variableNames.size()]);
        this.variableShapes = variableShapes;
    }

    public INDArray getVariable(String variableName) {
        for (int i = 0; i < dataSet.getFeatures().shape()[0]; i++) {
            if (variableNames[i].equals(variableName)) {
                INDArray result = dataSet.getFeatures().getRow(i);
                result.setShape(variableShapes[i]);
                return result;
            }
        }
        throw new RuntimeException("Variable " + variableName + " not found in the DataSet.");
    }

    public String[] getVariableNames() {
        return variableNames;
    }

    @Override
    public String toString() {
        return "PreProDataSet{" +
                "dataSet=" + dataSet +
                ", variableNames=" + Arrays.toString(variableNames) +
                ", variableShapes=" + Arrays.toString(variableShapes) +
                '}';
    }
}
