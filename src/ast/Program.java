package ast;

import ast.type.Node;
import ast.type.Statement;

import java.util.ArrayList;
import java.util.List;

public class Program implements Node {

    public final List<Statement> statements = new ArrayList<>();

    @Override
    public String tokenLiteral() {
        if(!statements.isEmpty()) {
            return statements.get(0).tokenLiteral();
        } else {
            return "";
        }
    }
}
