package dataset;

import org.junit.Before;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultPreProDataSetTest {
    private INDArray p1, p2, p3, testMat3_1, testMat3_2, testMat4_1, testMat4_2, numbers;
    private DefaultPreProDataSet dataSet;

    @Before
    public void setUp() {
        p1 = Nd4j.create(new double[]{42, 0, 0, 1, 0, 0, 5, 0, 0, 6, 0, 0, 1, 2, 3}, new int[]{4, 3});
        p2 = Nd4j.create(new double[]{43, 0, 0, 44662, 0, 0, 6, 0, 0, 7, 0, 0}, new int[]{4, 3});
        p3 = Nd4j.create(new double[]{42, 0, 1, 1, 0, 1, 5, 0, 1, 6, 0, 1}, new int[]{4, 3});

        testMat3_1 = Nd4j.create(IntStream.range(1, 36 + 1).mapToDouble(i -> i).toArray(), new int[]{4, 3, 3});
        testMat3_2 = Nd4j.create(IntStream.range(1, 36 * 2 + 1).filter(i -> i % 2 == 0).mapToDouble(i -> i).toArray(), new int[]{4, 3, 3});

        testMat4_1 = Nd4j.create(IntStream.range(1, 64 + 1).mapToDouble(i -> i).toArray(), new int[]{4, 4, 4});
        testMat4_2 = Nd4j.create(IntStream.range(1, 64 * 2 + 1).filter(i -> i % 2 == 0).mapToDouble(i -> i).toArray(), new int[]{4, 4, 4});

        numbers = Nd4j.create(new double[]{1, 2, 3, 4}, new int[]{4, 1});

        dataSet = new DefaultPreProDataSet(
                Arrays.asList(p1, p2, p3, testMat3_1, testMat3_2, testMat4_1, testMat4_2, numbers),
                Arrays.asList("p1", "p2", "p3", "testMat3_1", "testMat3_2", "testMat4_1", "testMat4_2", "numbers")
        );
    }

    @Test
    public void testSaveAndLoad() {
        dataSet.writeDataSetToFile("temp.dataset");
        PreProDataSet importedDataSet = new DefaultPreProDataSet("temp.dataset");

        assertEquals(dataSet.toString(), importedDataSet.toString());
    }

    @Test
    public void testGetVariable() {
        INDArray variable = dataSet.getVariable("p1");
        assertEquals(p1.toString(), variable.toString());
        variable = dataSet.getVariable("p3");
        assertEquals(p3.toString(), variable.toString());
        variable = dataSet.getVariable("testMat3_1");
        assertEquals(testMat3_1.toString(), variable.toString());
        variable = dataSet.getVariable("testMat4_2");
        assertEquals(testMat4_2.toString(), variable.toString());
        variable = dataSet.getVariable("numbers");
        assertEquals(numbers.toString(), variable.toString());
    }
}