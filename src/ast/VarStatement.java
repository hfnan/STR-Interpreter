package ast;

import ast.type.Expression;
import ast.type.Statement;
import token.Token;

public class VarStatement implements Statement {
    private Token related;
    private Identifier variable;
    private Expression value;

    public void setVariable(Identifier variable) {
        this.variable = variable;
    }

    public Identifier getVariable() {
        return variable;
    }

    public Token getRelated() {
        return related;
    }

    public VarStatement(Token token) {
        related = token;
    }

    @Override
    public String tokenLiteral() {
        return related.getLiteral();
    }

    @Override
    public void statementNode() {

    }
}
