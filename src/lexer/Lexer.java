package lexer;

import token.Token;

import java.util.Collection;

import static token.TokenTypeConst.*;

public class Lexer {
    private String input;
    private int position;
    private int readPosition;
    char ch;

    public Lexer(String input) {
        this.input = input;
        readChar();
    }

    public void readChar() {
        if(readPosition >= input.length()) {
            ch = 0;
        } else {
            ch = input.charAt(readPosition);
        }
        position = readPosition;
        readPosition += 1;
    }

    public char peekChar() {
        if (readPosition >= input.length()) {
            return 0;
        }
        return input.charAt(readPosition);
    }

    public String lookAhead() {
        var i = readPosition;
        var ni = i;
        for (ni = i; input.charAt(ni) != '\n'; ni++) {}
        return input.substring(i, ni);
    }

    public Token nextToken() {
        Token tok;

        skipBlank();

        switch (ch) {
            case '=':
                if (peekChar() == '=') {
                    readChar();
                    tok = new Token(EQ, "==");
                } else {
                    tok = new Token(ASSIGN, ch);
                    // TODO: 2022/10/12 符号表管理
                }
                break;
            case '!':
                if (peekChar() == '=') {
                    readChar();
                    tok = new Token(NOT_EQ, "!=");
                } else {
                    tok = new Token(ILLEGAL, ch);
                }
                break;
            case '(': tok = new Token(LPAREN, ch); break;
            case ')': tok = new Token(RPAREN, ch); break;
            case '{': tok = new Token(LBRACE, ch); break;
            case '}': tok = new Token(RBRACE, ch); break;
            case ',': tok = new Token(COMMA, ch); break;
            case ':': tok = new Token(COLON, ch); break;
            case '+': tok = new Token(ADD, ch); break;
            case '-': tok = new Token(SUB, ch); break;
            case '*': tok = new Token(MUL, ch); break;
            case '/': tok = new Token(DIV, ch); break;
            case '<': tok = new Token(LT, ch); break;
            case '>': tok = new Token(GT, ch); break;
            case '\n': tok = new Token(DELIMIT, "delimit"); break;
            case '\0': tok = new Token(EOF, ""); break;
            default:
                if (isLetter(ch)) {
                    var ident = readIdentifier();
                    tok = new Token(Token.lookUpId(ident), ident);
                    return tok;
                } else if(isDigit(ch)) {
                    tok = new Token(INT, readNumber());
                    return tok;
                }else {
                    tok = new Token(ILLEGAL, ch);
                }
        }

        readChar();

        return tok;
    }

    private String readIdentifier() {
        var i = position;
        while (isLetOrDigit(ch)) {
            readChar();
        }
        return input.substring(i, position);
    }

    private String readNumber() {
        var i = position;
        while(isDigit(ch)) {
            readChar();
        }
        return input.substring(i, position);
    }

    private void skipBlank() {
        while (ch == ' ' || ch == '\t' || ch == '\r') {
            readChar();
        }
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isLetter(char ch) {
        return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch == '_';
    }

    private boolean isLetOrDigit(char ch) {
        return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9' || ch == '_';
    }
}
