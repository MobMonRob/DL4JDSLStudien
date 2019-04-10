package de.sbernauer.prepro.nodes.expression.arithmetic;

import de.sbernauer.prepro.PreProProgram;
import de.sbernauer.prepro.dataset.FilePreProDataSet;
import de.sbernauer.prepro.dataset.PreProDataSet;
import de.sbernauer.prepro.nodes.statement.ThrowFromPreProException;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LazyMulNodeTest {

    private final INDArray a = Nd4j.create(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, new int[]{5, 3});
    private final INDArray b = Nd4j.create(new double[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}, new int[]{5, 3});

    private final INDArray center = a.add(b).div(2);

    @Test
    public void testExists_VariableAAndBExists() {
        PreProProgram program = new PreProProgram("src/test/resources/function/testOptionalImport.prepro");

        PreProDataSet dataSet = new FilePreProDataSet(Arrays.asList(a, b), Arrays.asList("a", "b"));

        PreProDataSet result = program.execute(dataSet);
        System.out.println(result.getVariable("center"));
        assertEquals(1, result.getVariable("aIsExisting").getDouble(0), 0);
        assertEquals(1, result.getVariable("bIsExisting").getDouble(0), 0);
        assertEquals(1, result.getVariable("somethingExisting").getDouble(0), 0);
        assertEquals(1, result.getVariable("bothExisting").getDouble(0), 0);

        assertEquals(center, result.getVariable("center"));
    }

    @Test
    public void testExists_OnlyAExists() {
        PreProProgram program = new PreProProgram("src/test/resources/function/testOptionalImport.prepro");

        PreProDataSet dataSet = new FilePreProDataSet(Arrays.asList(a), Arrays.asList("a"));

        PreProDataSet result = program.execute(dataSet);
        System.out.println(result.getVariable("center"));
        assertEquals(1, result.getVariable("aIsExisting").getDouble(0), 0);
        assertEquals(0, result.getVariable("bIsExisting").getDouble(0), 0);
        assertEquals(1, result.getVariable("somethingExisting").getDouble(0), 0);
        assertEquals(0, result.getVariable("bothExisting").getDouble(0), 0);

        assertEquals(a, result.getVariable("center"));
    }

    @Test
    public void testExists_OnlyBExists() {
        PreProProgram program = new PreProProgram("src/test/resources/function/testOptionalImport.prepro");

        PreProDataSet dataSet = new FilePreProDataSet(Arrays.asList(b), Arrays.asList("b"));

        PreProDataSet result = program.execute(dataSet);
        System.out.println(result.getVariable("center"));
        assertEquals(0, result.getVariable("aIsExisting").getDouble(0), 0);
        assertEquals(1, result.getVariable("bIsExisting").getDouble(0), 0);
        assertEquals(1, result.getVariable("somethingExisting").getDouble(0), 0);
        assertEquals(0, result.getVariable("bothExisting").getDouble(0), 0);

        assertEquals(b, result.getVariable("center"));
    }

    @Test(expected = ThrowFromPreProException.class)
    public void testExists_NeitherAOrBExists() {
        PreProProgram program = new PreProProgram("src/test/resources/function/testOptionalImport.prepro");

        PreProDataSet dataSet = new FilePreProDataSet(Arrays.asList(), Arrays.asList());

        PreProDataSet result = program.execute(dataSet);
        System.out.println(result.getVariable("center"));
        assertEquals(0, result.getVariable("aIsExisting").getDouble(0), 0);
        assertEquals(0, result.getVariable("bIsExisting").getDouble(0), 0);
        assertEquals(0, result.getVariable("somethingExisting").getDouble(0), 0);
        assertEquals(0, result.getVariable("bothExisting").getDouble(0), 0);

        // No center will be calculated, because Exception is thrown.
    }
}
