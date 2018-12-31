package de.sbernauer.prepro.plugin.syntaxhighlighting;

import de.sbernauer.prepro.plugin.syntaxhighlighting.parser.PreProLexer;
import de.sbernauer.prepro.plugin.syntaxhighlighting.utils.AntlrCharStream;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

public class PreProEditorLexer implements Lexer<PreProTokenId> {

    private LexerRestartInfo<PreProTokenId> info;
    private PreProLexer lexer;

    public PreProEditorLexer(LexerRestartInfo<PreProTokenId> info) {
        this.info = info;
        AntlrCharStream charStream = new AntlrCharStream(info.input(), "PreProEditor", true);
        lexer = new PreProLexer(charStream);
    }

    @Override
    public org.netbeans.api.lexer.Token<PreProTokenId> nextToken() {
        org.antlr.runtime.Token token = lexer.nextToken();

        Token<PreProTokenId> createdToken = null;

        if (token.getType() != -1) {
            PreProTokenId tokenId = PreProLanguageHierarchy.getToken(token.getType());
            createdToken = info.tokenFactory().createToken(tokenId);
        } else if (info.input().readLength() > 0) {
            PreProTokenId tokenId = PreProLanguageHierarchy.getToken(PreProLexer.WS);
            createdToken = info.tokenFactory().createToken(tokenId);
        }

        return createdToken;
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }
}
