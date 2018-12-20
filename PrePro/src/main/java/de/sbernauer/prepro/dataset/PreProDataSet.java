package de.sbernauer.prepro.dataset;

import org.nd4j.linalg.api.ndarray.INDArray;

import java.util.Set;

public interface PreProDataSet {

    INDArray getVariable(String variableName);

    Set<String> getVariableNames();

    boolean variableExists(String variableName);

    void addConstant(String constantName, INDArray value);

    void writeDataSetToFile(String filePathData);
}
