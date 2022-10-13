package parser;

import ast.Identifier;
import ast.Program;
import ast.VarStatement;
import ast.type.Statement;
import lexer.Lexer;
import token.Token;

import java.util.Objects;

import static token.TokenTypeConst.*;


public class Parser {
    private Lexer lexer;
    private Token curToken;
    private Token peekToken;

    public Program parseProgram() {
        var program = new Program();

        while (!Objects.equals(curToken.getTokenType(), EOF)) {
            var stmt = parseStatement();
            if (stmt != null) {
                program.statements.add(stmt);
            }
            nextToken();
        }

        return program;
    }

    public Statement parseStatement() {
        switch (curToken.getTokenType()) {
            case VAR:
                return parseVarStatement();
            default:
                return null;
        }
    }

    public VarStatement parseVarStatement() {
        var stmt = new VarStatement(curToken);

        if (!expectPeek(ID)) {
            return null;
        }

        stmt.setVariable(new Identifier(curToken, curToken.getLiteral()));

        if (!expectPeek(ASSIGN)) {
            return null;
        }

        // TODO: 2022/10/13 处理表达式
        while (!curTokenIs(DELIMIT)) {
            nextToken();
        }

        return stmt;
    }

    public boolean expectPeek(String type) {
        if (peekTokenIs(type)) {
            nextToken();
            return true;
        } else {
            return false;
        }
    }

    public boolean curTokenIs(String type) {
        return Objects.equals(curToken.getTokenType(), type);
    }

    public boolean peekTokenIs(String type) {
        return Objects.equals(peekToken.getTokenType(), type);
    }

    public void nextToken() {
        curToken = peekToken;
        peekToken = lexer.nextToken();
    }

    public Parser(Lexer l) {
        lexer = l;
        nextToken();
        nextToken();
    }
}
