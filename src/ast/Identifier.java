package ast;

import ast.type.Expression;
import token.Token;

public class Identifier implements Expression {
    private Token related;
    private String value;

    public String getValue() {
        return value;
    }

    public Identifier(Token token, String value) {
        related = token;
        this.value = value;
    }

    @Override
    public void expressionNode() {

    }

    @Override
    public String tokenLiteral() {
        return related.getLiteral();
    }
}
