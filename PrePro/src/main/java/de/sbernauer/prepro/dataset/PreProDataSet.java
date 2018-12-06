package de.sbernauer.prepro.dataset;

import org.nd4j.linalg.api.ndarray.INDArray;

import java.util.List;

public interface PreProDataSet {

    INDArray getVariable(String variableName);

    List<String> getVariableNames();

    void writeDataSetToFile(String filePathData);
}
