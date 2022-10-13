package token;

import java.util.HashMap;
import java.util.Map;

import static token.TokenTypeConst.*;

public class Token {
    private String tokenType;
    private String literal;
    // Text(String) -> TokenType(String)
    private static Map<String, String> keywords = new HashMap<>(){{
        put("var", VAR);
        put("test", TEST);
        put("else", ELSE);
        put("true", TRUE);
        put("false", FALSE);
        put("return", RETURN);
    }};

    public Token(String type, char ch) {
        this.tokenType = type;
        this.literal = String.valueOf(ch);
    }

    public Token(String type, String literal) {
        this.tokenType = type;
        this.literal = literal;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getLiteral() {
        return literal;
    }

    public static String lookUpId(String ident) {
        var type = keywords.get(ident);
        if (type != null) {
            return type;
        }
        return ID;
    }

    @Override
    public String toString() {
        return "( " + tokenType + "  " + literal + " )";
    }
}
