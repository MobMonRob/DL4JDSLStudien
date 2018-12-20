package de.sbernauer.prepro.dataset;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Only used to de/serialize MetaData of the {@link FilePreProDataSet} for text-files.
 */
public class MetaDataJsonObject {
    public List<DataSetEntry> dataSetEntries;
    public HashMap<String, INDArray> constants;

    public MetaDataJsonObject(List<DataSetEntry> dataSetEntries, HashMap<String, INDArray> constants) {
        this.dataSetEntries = dataSetEntries;
        this.constants = constants;
    }

    public MetaDataJsonObject(String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            ObjectNode gobalNodes = mapper.readValue(jsonString, ObjectNode.class);

            String dataSetEntriesJsonString = gobalNodes.get("dataSetEntries").toString();
            this.dataSetEntries = mapper.readValue(dataSetEntriesJsonString,
                    new TypeReference<List<DataSetEntry>>() {
                    });
            this.constants = new HashMap<>();

            String constantJsonString = gobalNodes.get("constants").toString();
            ObjectNode constantNodes = mapper.readValue(constantJsonString, ObjectNode.class);

            for (Iterator<String> it = constantNodes.fieldNames(); it.hasNext(); ) {
                String constantName = it.next();
                String constantJson = constantNodes.get(constantName).toString();

                constantJson = constantJson
                        .replace("\"filefrom\":", "\n\"filefrom\":")
                        .replace("\"ordering\":", "\n\"ordering\":")
                        .replace("\"shape\":", "\n\"shape\":")
                        .replace("\"data\":", "\n\"data\":\n");

                InputStream inputStream = new ByteArrayInputStream(constantJson.getBytes());
                INDArray constant = Nd4j.readTxtString(inputStream);

                constants.put(constantName, constant);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getJsonString() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            StringBuilder result = new StringBuilder();
            OutputStream outputStream = new OutputStream() {
                @Override
                public void write(int i) throws IOException {
                    result.append((char) i);
                }
            };

            result.append("{\"dataSetEntries\":");
            String dataSetEntriesJsonString = null;
            dataSetEntriesJsonString = mapper.writeValueAsString(dataSetEntries);
            result.append(dataSetEntriesJsonString);

            result.append(",\"constants\":{");
            for (String constantName : constants.keySet()) {
                INDArray constant = constants.get(constantName);

                result.append("\"");
                result.append(constantName);
                result.append("\":");
                Nd4j.writeTxtString(constant, outputStream);
                result.append(",");
            }
            result.deleteCharAt(result.length() - 1);
            result.append("}}");
            return result.toString();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}