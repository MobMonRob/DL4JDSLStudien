package de.sbernauer.prepro.plugin.syntaxhighlighting;
import org.netbeans.api.lexer.TokenId;

public class PreProTokenId implements TokenId {

    private final String name;
    private final String primaryCategory;
    private final int id;

    public PreProTokenId(String name, String primaryCategory, int id) {
        this.name = name;
        this.primaryCategory = primaryCategory;
        this.id = id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int ordinal() {
        return id;
    }

    @Override
    public String primaryCategory() {
        return primaryCategory;
    }
}
