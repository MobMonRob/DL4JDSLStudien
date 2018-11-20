package main;

import nodes.FunctionTable;
import nodes.MainNode;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.PreProLexer;
import parser.PreProParser;

import java.io.IOException;
import java.util.Arrays;

public class PreProProgram {
    private final MainNode mainNode;

    public PreProProgram(String fileName) {
        try {
            PreProLexer lexer = new PreProLexer(CharStreams.fromFileName(fileName));
            PreProParser parser = new PreProParser(new CommonTokenStream(lexer));
            this.mainNode = parser.prepro().result;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public PreProDataSet execute(PreProDataSet preProDataSet) {
        System.out.println("\n\nStarting PrePro-Interpreter...\n");

        System.out.println("\nInput-PreProDataSet contains:\n" + Arrays.toString(preProDataSet.getVariableNames()));

        PreProDataSet result = mainNode.execute(preProDataSet);

        System.out.println("\nOutput-PreProDataSet contains:\n" + Arrays.toString(result.getVariableNames()));
        return result;
    }
}
