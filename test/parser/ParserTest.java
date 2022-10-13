package parser;

import ast.VarStatement;
import ast.type.Statement;
import lexer.Lexer;
import org.junit.jupiter.api.Test;
import utils.FileHelper;
import utils.SrcPath;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    boolean testLetStatement(Statement s, String ident) {
        if (!Objects.equals(s.tokenLiteral(), "var")) {
            System.err.printf("tokenLiteral not 'var'. got = %s\n", s.tokenLiteral());
            return false;
        }

        var varStmt = (VarStatement) s;

        if (!Objects.equals(varStmt.getVariable().getValue(), ident)) {
            System.err.printf("identifier not '%s'. got = %s\n", ident,
                    varStmt.getVariable().getValue());
            return false;
        }

        if (!Objects.equals(varStmt.getVariable().tokenLiteral(), ident)) {
            System.err.printf("variable's tokenLiteral not '%s'. got = %s\n", ident,
                    varStmt.getVariable().tokenLiteral());
            return false;
        }

        return true;
    }

    @Test
    void testLetStatements() {
        var input = FileHelper.readFile(SrcPath.TEST_PARSER_PATH1);


        var lexer = new Lexer(input);
        var parser = new Parser(lexer);

        var program = parser.parseProgram();
        assertNotNull(program,"parserProgram() return null");
        assertEquals(3, program.statements.size(), "Statements Should be 3");

        var tests = FileHelper.readLines(SrcPath.TEST_ID_PATH1);

        int i = 0;
        for (var expectId : tests) {
            var stmt = program.statements.get(i);
            if (!testLetStatement(stmt, expectId)) {
                return;
            }
            i++;
        }
    }

}