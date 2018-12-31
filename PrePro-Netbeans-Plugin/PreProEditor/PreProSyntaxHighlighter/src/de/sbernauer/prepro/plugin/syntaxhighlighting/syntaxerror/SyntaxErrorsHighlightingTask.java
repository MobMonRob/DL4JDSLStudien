package de.sbernauer.prepro.plugin.syntaxhighlighting.syntaxerror;

import de.sbernauer.prepro.plugin.syntaxhighlighting.parser.PreProParser.SyntaxError;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Document;
import org.antlr.runtime.RecognitionException;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.ParserResultTask;
import org.netbeans.modules.parsing.spi.Scheduler;
import org.netbeans.modules.parsing.spi.SchedulerEvent;
import org.netbeans.spi.editor.hints.ErrorDescription;
import org.netbeans.spi.editor.hints.ErrorDescriptionFactory;
import org.netbeans.spi.editor.hints.HintsController;
import org.netbeans.spi.editor.hints.Severity;

public class SyntaxErrorsHighlightingTask extends ParserResultTask<PreProEditorParser.PreProEditorParserResult> {

    public SyntaxErrorsHighlightingTask() {
    }

    public int getPriority() {
        return 100;
    }

    public Class<? extends Scheduler> getSchedulerClass() {
        return Scheduler.EDITOR_SENSITIVE_TASK_SCHEDULER;
    }

    public void cancel() {
    }

    @Override
    public void run(PreProEditorParser.PreProEditorParserResult result, SchedulerEvent event) {
        try {
            List<SyntaxError> syntaxErrors = result.getPreProParser().syntaxErrors;
            Document document = result.getSnapshot().getSource().getDocument(false);
            List<ErrorDescription> errors = new ArrayList<>();
            for (SyntaxError syntaxError : syntaxErrors) {
                RecognitionException exception = syntaxError.exception;
                String message = syntaxError.message;

                int line = exception.line;
                if (line <= 0) {
                    continue;
                }
                ErrorDescription errorDescription = ErrorDescriptionFactory.createErrorDescription(
                        Severity.ERROR,
                        message,
                        document,
                        document.createPosition(syntaxError.start),
                        document.createPosition(syntaxError.stop));
                errors.add(errorDescription);
            }

            HintsController.setErrors(document, "prepro", errors);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
