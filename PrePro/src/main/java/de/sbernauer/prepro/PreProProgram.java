package de.sbernauer.prepro;

import de.sbernauer.prepro.dataset.PreProDataSet;
import de.sbernauer.prepro.nodes.MainNode;
import de.sbernauer.prepro.nodes.function.Function;
import de.sbernauer.prepro.nodes.function.FunctionNode;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import de.sbernauer.prepro.parser.PreProLexer;
import de.sbernauer.prepro.parser.PreProParser;

import java.io.IOException;

public class PreProProgram {
    private final MainNode mainNode;

    public PreProProgram(String fileName) {
        try {
            PreProLexer lexer = new PreProLexer(CharStreams.fromFileName(fileName));
            PreProParser parser = new PreProParser(new CommonTokenStream(lexer));
            this.mainNode = parser.prepro().result;
            int syntaxErrors = parser.getNumberOfSyntaxErrors();
            if(syntaxErrors > 0) {
                throw new RuntimeException("Cannot read file " + fileName + ". Had " + syntaxErrors + " syntax error.");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public PreProDataSet execute(PreProDataSet preProDataSet) {
        System.out.println("\n\nStarting PrePro-Interpreter...\n");

        System.out.println("\nInput-PreProDataSet contains:\n" + preProDataSet.getVariableNames());

        PreProDataSet result = mainNode.execute(preProDataSet);

        System.out.println("\nOutput-PreProDataSet contains:\n" + result.getVariableNames());
        return result;
    }

    public void registerFunction(Class clazz, String functionName) {
        mainNode.registerFunction(clazz, functionName);
    }
}
