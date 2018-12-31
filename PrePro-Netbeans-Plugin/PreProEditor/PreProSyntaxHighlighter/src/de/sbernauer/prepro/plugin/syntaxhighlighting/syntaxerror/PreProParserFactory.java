package de.sbernauer.prepro.plugin.syntaxhighlighting.syntaxerror;

import java.util.Collection;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.ParserFactory;

@MimeRegistration(mimeType = "text/x-prepro", service = ParserFactory.class)
public class PreProParserFactory extends ParserFactory {

    @Override
    public Parser createParser(Collection<Snapshot> snapshots) {
        return new PreProEditorParser();
    }
}
