import main.PreProDataSet;
import main.PreProProgram;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestExecutor {
    private static final PrintStream SYSTEM_OUT = System.out;

    private static final PreProDataSet TEST_PRE_PRO_DATA_SET = createTestPreProDataSet();

    private static PreProDataSet createTestPreProDataSet() {
        INDArray p1 = Nd4j.create(new double[]{42, 0, 0, 1, 0, 0, 5, 0, 0, 6, 0, 0, 1, 2, 3}, new int[]{4, 3});
        INDArray p2 = Nd4j.create(new double[]{43, 0, 0, 44662, 0, 0, 6, 0, 0, 7, 0, 0}, new int[]{4, 3});
        INDArray p3 = Nd4j.create(new double[]{42, 0, 1, 1, 0, 1, 5, 0, 1, 6, 0, 1}, new int[]{4, 3});

        return new PreProDataSet(
                Arrays.asList(p1, p2, p3),
                Arrays.asList("p1", "p2", "p3")
        );
    }

    @Test
    public void runTests() throws IOException {

        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
            }
        }));

        for (File file : getAllTestFilesAndCheckIfOutputExists()) {
            SYSTEM_OUT.println("Testing " + file.getName());
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

    private File[] getAllTestFilesAndCheckIfOutputExists() {
        File dir = new File("src/test/java/");

        File[] testFiles = dir.listFiles((directory, filename) -> filename.endsWith(".prepro"));

        for (File testFile : testFiles) {
            File outputFile = new File(testFile.getAbsolutePath().replace(".prepro", ".out"));
            if (!outputFile.exists() || outputFile.isDirectory()) {
                throw new RuntimeException("Didn't found matching .out file for " + testFile.getAbsolutePath());
            }
        }
        return testFiles;
    }
}
