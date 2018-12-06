package de.sbernauer.prepro;

import de.sbernauer.prepro.dataset.DefaultPreProDataSet;
import de.sbernauer.prepro.dataset.PreProDataSet;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestExecutor {
    private static final PrintStream SYSTEM_OUT = System.out;

    private PreProDataSet TEST_PRE_PRO_DATA_SET
            = new DefaultPreProDataSet("src/test/tests/test.dataset");

    @Test
    public void runTests() throws IOException {

        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
            }
        }));

        for (File file : getAllTestFilesAndCheckIfOutputExists()) {
            SYSTEM_OUT.println("Testing " + file.getPath());
            testFile(file);
        }
    }

    private void testFile(File file) throws IOException {
        PreProProgram program = new PreProProgram(file.getAbsolutePath());
        String result = program.execute(TEST_PRE_PRO_DATA_SET).toString();
        String expected = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath().replace(".prepro", ".out"))),
                StandardCharsets.UTF_8);

        assertEquals(expected, result);
    }

    private List<File> getAllTestFilesAndCheckIfOutputExists() {
        File dir = new File("src/test/tests/");

        List<File> testFiles = (List<File>) FileUtils.listFiles(dir, new String[]{"prepro"}, true);

        for (File testFile : testFiles) {
            File outputFile = new File(testFile.getAbsolutePath().replace(".prepro", ".out"));
            if (!outputFile.exists() || outputFile.isDirectory()) {
                throw new RuntimeException("Didn't found matching .out file for " + testFile.getAbsolutePath());
            }
        }
        return testFiles;
    }
}
