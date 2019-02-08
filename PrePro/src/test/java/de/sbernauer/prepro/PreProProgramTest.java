package de.sbernauer.prepro;

import de.sbernauer.prepro.dataset.FilePreProDataSet;
import de.sbernauer.prepro.dataset.PreProDataSet;
import de.sbernauer.prepro.nodes.SymbolTable;
import de.sbernauer.prepro.variables.Constant;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PreProProgramTest {
    FilePreProDataSet dataSet = new FilePreProDataSet("src/test/tests/test.dataset");

    @Test
    public void testExecutionWithSymbolTable() {
        PreProProgram program = new PreProProgram("src/test/resources/symboltable/testPreProProgramSymbolTable.prepro");
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.setValue("testSymbolTableX", new Constant(42));
        symbolTable.setValue("testSymbolTableY", new Constant(13));

        PreProDataSet result = program.execute(dataSet, symbolTable);
        double testSymbolTableResult = result.getVariable("testSymbolTableResult").getDouble(0, 0);
        assertEquals(55, testSymbolTableResult, 1E-6);
    }

    @Test(expected = RuntimeException.class)
    public void testExecutionWithoutSymbolTable() {
        PreProProgram program = new PreProProgram("src/test/resources/symboltable/testPreProProgramSymbolTable.prepro");

        program.execute(dataSet);
    }

}