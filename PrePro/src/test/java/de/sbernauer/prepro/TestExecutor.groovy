package de.sbernauer.prepro;

import de.sbernauer.prepro.dataset.FilePreProDataSet;
import de.sbernauer.prepro.dataset.PreProDataSet;
import de.sbernauer.prepro.variables.Vector3;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class TestExecutor {
    private static final PrintStream SYSTEM_OUT = System.out;

    private PreProDataSet TEST_PRE_PRO_DATA_SET = new FilePreProDataSet("src/test/tests/test.dataset");

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
        program.registerFunction(TestExecutor.class, "calculateDifferenceCustomFunction");
        String result = program.execute(TEST_PRE_PRO_DATA_SET).toString();
        String expected = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath().replace(".prepro", ".out"))),
                StandardCharsets.UTF_8);

        assertEquals(expected, result);
    }

    private List<File> getAllTestFilesAndCheckIfOutputExists() {
        File dir = new File("src/test/tests/");

        List<File> testFiles = (List<File>) FileUtils.listFiles(dir, (String[]) ["prepro"], true);

        for (File testFile : testFiles) {
            File outputFile = new File(testFile.getAbsolutePath().replace(".prepro", ".out"));
            if (!outputFile.exists() || outputFile.isDirectory()) {
                throw new RuntimeException("Didn't found matching .out file for " + testFile.getAbsolutePath());
            }
        }
        return testFiles;
    }

    /**
     * This is a custom function and can be called in a PrePro-Programm.
     * It must be static!
     * It must be registered at the PrePro-Programm via the function registerFunction(Class, String).
     * You must provide the register-function the Class were the custom function is located and the function name.
     * There must be exactly one function in this class with this name.
     *
     * @return null, if the custom function is a void function
     */
    static Vector3 calculateDifferenceCustomFunction(Vector3 left, Vector3 right) {
        return new Vector3(right.getNdArray().sub(left.getNdArray()));
    }
}
