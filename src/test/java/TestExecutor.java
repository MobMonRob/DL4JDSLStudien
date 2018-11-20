import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import nodes.MainNode;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import parser.PreProLexer;
import parser.PreProParser;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TestExecutor {
    private static final PrintStream SYSTEM_OUT = System.out;

    ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    @Test
    public void runBlackboxTests() throws IOException {
        System.setOut(new PrintStream(buffer));

        for (File file : getAllTestFilesAndCheckIfOutputExists()) {
            checkIfOutputIsCorrect(file);
        }
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

    private void execute(File file) throws IOException {
        String fileContent = FileUtils.readFileToString(file);

        PreProLexer lexer = new PreProLexer(CharStreams.fromString(fileContent));
        MainNode main = new PreProParser(new CommonTokenStream(lexer)).prepro().result;

//        CallTarget target = Truffle.getRuntime().createCallTarget(main);
//        target.call();
    }

    private void checkIfOutputIsCorrect(File file) throws IOException {
        buffer.reset();

        execute(file);

        String expectedOutput = FileUtils.readFileToString(new File(file.getAbsolutePath().replace(".prepro", ".out")));

        assertEquals(expectedOutput, buffer.toString());

        SYSTEM_OUT.println("Checked output for " + file.getName());
    }
}
