package autocompletion;

import nodes.FunctionTable;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.PreProLexer;
import parser.PreProParser;

import java.util.HashSet;
import java.util.Set;

public class AutoComplete {
    private Set<String> possibilities;

    public Set<String> tryAutoComplete(String previousProgram) {

        FunctionTable.getInstance().reset();
        PreProLexer lexer = new PreProLexer(CharStreams.fromString(previousProgram));
        PreProParser parser = new PreProParser(new CommonTokenStream(lexer));

        parser.getErrorListeners();
        parser.setErrorHandler(new MyErrorListener(this));

        possibilities = new HashSet<>();
        try {
            parser.prepro();
        } catch (RuntimeException e) {
            // Its normal, that an uncompleted program throws exceptions
        }
        return possibilities;
    }

    public void reportPossibility(String possibility) {
        possibilities.add(possibility);
    }
}
