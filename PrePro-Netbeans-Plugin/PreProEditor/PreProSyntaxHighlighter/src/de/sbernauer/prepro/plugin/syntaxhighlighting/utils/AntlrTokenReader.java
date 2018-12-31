package de.sbernauer.prepro.plugin.syntaxhighlighting.utils;

import de.sbernauer.prepro.plugin.syntaxhighlighting.PreProTokenId;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openide.util.Exceptions;

public class AntlrTokenReader {

    private HashMap<String, String> tokenTypes = new HashMap<>();
    private ArrayList<PreProTokenId> tokens = new ArrayList<>();

    public AntlrTokenReader() {
        init();
    }

    /**
     * Initializes the map to include any keywords in the DSL.
     */
    private void init() {

        tokenTypes.put("TYPE", "type");

        tokenTypes.put("FUNCTION", "keyword");
        tokenTypes.put("IMPORT", "keyword");
        tokenTypes.put("EXPORT", "keyword");
        tokenTypes.put("RETURN", "keyword");
        tokenTypes.put("RETURNS", "keyword");
        tokenTypes.put("PRINT", "keyword");
        tokenTypes.put("DEBUG", "keyword");

        tokenTypes.put("IDENTIFIER", "identifier");
        
        tokenTypes.put("STRING_LITERAL", "number");
        tokenTypes.put("NUMERICAL_LITERAL", "number");
    }

    /**
     * Reads the token file from the ANTLR parser and generates appropriate
     * tokens.
     *
     * @return
     */
    public List<PreProTokenId> readTokenFile() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inp = classLoader.getResourceAsStream("de/sbernauer/prepro/plugin/syntaxhighlighting/parser/PrePro.tokens");
        BufferedReader input = new BufferedReader(new InputStreamReader(inp));
        readTokenFile(input);
        return tokens;
    }

    /**
     * Reads in the token file.
     *
     * @param buff
     */
    private void readTokenFile(BufferedReader buff) {
        String line = null;
        try {
            while ((line = buff.readLine()) != null) {
                String[] splLine = line.split("=");
                String name = splLine[0];
                int tok = Integer.parseInt(splLine[1].trim());
                PreProTokenId id;
                String tokenCategory = tokenTypes.get(name);
                if (tokenCategory != null) {
                    //if the value exists, put it in the correct category
                    id = new PreProTokenId(name, tokenCategory, tok);
                } else {
                    //if we don't recognize the token, consider it to a separator
                    id = new PreProTokenId(name, "separator", tok);
                }
                //add it into the vector of tokens
                tokens.add(id);
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
