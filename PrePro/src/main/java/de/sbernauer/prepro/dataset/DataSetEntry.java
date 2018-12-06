package de.sbernauer.prepro.dataset;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class DataSetEntry {

    private final String variableName;
    private final int[] variableShape;
    private final int startColumn;
    private final int length;

    @JsonCreator
    public DataSetEntry(@JsonProperty("variableName") String variableName,
                        @JsonProperty("variableShape") int[] variableShape,
                        @JsonProperty("startColumn") int startColumn,
                        @JsonProperty("length") int length) {
        this.variableName = variableName;
        this.variableShape = variableShape;
        this.startColumn = startColumn;
        this.length = length;
    }

    public String getVariableName() {
        return variableName;
    }

    public int[] getVariableShape() {
        return variableShape;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "DataSetEntry{" +
                "variableName='" + variableName + '\'' +
                ", variableShape=" + Arrays.toString(variableShape) +
                ", startColumn=" + startColumn +
                ", length=" + length +
                '}';
    }
}
