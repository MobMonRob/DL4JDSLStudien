package de.sbernauer.prepro.plugin.syntaxhighlighting;

import de.sbernauer.prepro.plugin.syntaxhighlighting.utils.AntlrTokenReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.netbeans.api.lexer.Language;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

public class PreProLanguageHierarchy extends LanguageHierarchy<PreProTokenId> {

    private static List<PreProTokenId> tokens;
    private static Map<Integer, PreProTokenId> idToToken;

    private static final Language<PreProTokenId> language
            = new PreProLanguageHierarchy().language();

    public static Language<PreProTokenId> getLanguage() {
        return language;
    }

    /**
     * Initializes the list of tokens with IDs generated from the ANTLR token
     * file.
     */
    private static void init() {
        AntlrTokenReader reader = new AntlrTokenReader();
        tokens = reader.readTokenFile();
        idToToken = new HashMap<Integer, PreProTokenId>();
        for (PreProTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }

    /**
     * Returns an actual CMinusTokenId from an id. This essentially allows the
     * syntax highlighter to decide the color of specific words.
     *
     * @param id
     * @return
     */
    static synchronized PreProTokenId getToken(int id) {
        if (idToToken == null) {
            init();
        }
        return idToToken.get(id);
    }

    /**
     * Initializes the tokens in use.
     *
     * @return
     */
    @Override
    protected synchronized Collection<PreProTokenId> createTokenIds() {
        if (tokens == null) {
            init();
        }
        return tokens;
    }

    /**
     * Creates a lexer object for use in syntax highlighting.
     *
     * @param info
     * @return
     */
    @Override
    protected synchronized Lexer<PreProTokenId> createLexer(LexerRestartInfo<PreProTokenId> info) {
        return new PreProEditorLexer(info);
    }

    /**
     * Returns the mime type of this programming language ("text/x-cm). This
     * allows NetBeans to load the appropriate editors and file loaders when a
     * file with the cm file extension is loaded.
     *
     * @return
     */
    @Override
    protected String mimeType() {
        return "text/x-prepro";
    }
}
