package de.sbernauer.prepro.plugin.syntaxhighlighting.syntaxerror;

import de.sbernauer.prepro.plugin.syntaxhighlighting.parser.PreProLexer;
import de.sbernauer.prepro.plugin.syntaxhighlighting.parser.PreProParser;
import javax.swing.event.ChangeListener;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.Parser.Result;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;

public class PreProEditorParser extends Parser {

    private Snapshot snapshot;
    private PreProParser preproParser;

    public void parse(Snapshot snapshot, Task task, SourceModificationEvent event) {
        this.snapshot = snapshot;
        ANTLRStringStream input = new ANTLRStringStream(snapshot.getText().toString());
        Lexer lexer = new PreProLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        preproParser = new PreProParser(tokens);
        try {
            preproParser.prepro();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Result getResult(Task task) {
        return new PreProEditorParserResult(snapshot, preproParser);
    }

    public void cancel() {
    }

    public void addChangeListener(ChangeListener changeListener) {
    }

    public void removeChangeListener(ChangeListener changeListener) {
    }

    public static class PreProEditorParserResult extends Result {

        private PreProParser preproParser;
        private boolean valid = true;

        PreProEditorParserResult(Snapshot snapshot, PreProParser preproParser) {
            super(snapshot);
            this.preproParser = preproParser;
        }

        public PreProParser getPreProParser() throws ParseException {
            if (!valid) {
                throw new ParseException();
            }
            return preproParser;
        }

        protected void invalidate() {
            valid = false;
        }
    }
}
