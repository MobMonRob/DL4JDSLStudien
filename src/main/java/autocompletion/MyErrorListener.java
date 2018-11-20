package autocompletion;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;

public class MyErrorListener extends DefaultErrorStrategy {
    private final AutoComplete autoComplete;

    public MyErrorListener(AutoComplete autoComplete) {
        this.autoComplete = autoComplete;
    }

    @Override
    protected void reportNoViableAlternative(Parser recognizer, NoViableAltException e) {
        catchError(recognizer);
    }


    protected void reportUnwantedToken(Parser recognizer) {
        catchError(recognizer);
    }

    protected void reportInputMismatch(Parser recognizer, InputMismatchException e) {
        catchError(recognizer, e);
        catchError(recognizer);
    }

    protected void reportMissingToken(Parser recognizer) {
        catchError(recognizer);
    }

    private void catchError(Parser recognizer) {
        int[] expected = this.getExpectedTokens(recognizer).toArray();
        for (int i : expected) {
            autoComplete.reportPossibility(recognizer.getVocabulary().getDisplayName(i));
        }
    }

    private void catchError(Parser recognizer, InputMismatchException e) {
        int[] expected = e.getExpectedTokens().toArray();
        for (int i : expected) {
            autoComplete.reportPossibility(recognizer.getVocabulary().getDisplayName(i));
        }
    }}
