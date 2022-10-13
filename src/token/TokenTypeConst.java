package token;

public final class TokenTypeConst {
    public static final String ILLEGAL = "illegal";
    public static final String EOF = "$";

    // 标识符 & 字面量
    public static final String ID = "id";
    public static final String INT = "int";

    // 运算符
    public static final String ASSIGN = "=";
    public static final String ADD = "+";
    public static final String MUL = "*";
    public static final String SUB = "-";
    public static final String DIV = "/";

    public static final String LT = "<";
    public static final String GT = ">";
    public static final String EQ = "==";
    public static final String NOT_EQ = "!=";

    // 分隔符
    public static final String LPAREN = "(";
    public static final String RPAREN = ")";
    public static final String LBRACE = "{";
    public static final String RBRACE = "}";
    public static final String COMMA = ",";
    public static final String COLON = ":";
    public static final String DELIMIT = "delimit";

    // 关键字
    public static final String VAR = "var";
    public static final String TEST = "test";
    public static final String ELSE = "else";
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String RETURN = "return";
}
