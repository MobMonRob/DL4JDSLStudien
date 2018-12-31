package de.sbernauer.prepro.plugin.syntaxhighlighting;

import org.netbeans.api.lexer.InputAttributes;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.LanguagePath;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.LanguageEmbedding;
import org.netbeans.spi.lexer.LanguageProvider;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider(service=LanguageProvider.class)
public class PreProLanguageProvider extends LanguageProvider {

    @Override
    public Language<?> findLanguage(String mimeType) {
        if ("text/x-prepro".equals(mimeType)) {
            return new PreProLanguageHierarchy().language();
        }

        return null;
    }

    @Override
    public LanguageEmbedding<?> findLanguageEmbedding(Token<?> token, LanguagePath lp, InputAttributes ia) {
        return null;
    }
}
