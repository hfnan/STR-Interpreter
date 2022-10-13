package lexer;

import org.junit.jupiter.api.Test;
import utils.FileHelper;
import utils.SrcPath;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static token.TokenTypeConst.*;

class NextTokenTest {

    static record tests(String expectType, String expectLiteral) {}

    @Test
    void nextToken() {
        var input = FileHelper.readFile(SrcPath.STR_CODE_PATH);

        var tokens = FileHelper.readLines(SrcPath.TOKEN_TEST_PATH);

        var tests = new ArrayList<tests>();

        for (var token : tokens) {
            var a = token.split(" ");
            if (a.length == 1) {
               tests.add(new tests(a[0], ""));
            } else {
                if (Objects.equals(a[1], "\\n")) {
                    a[1] = "\n";
                }
                tests.add(new tests(a[0], a[1]));
            }
        }

        var lexer = new Lexer(input);

        for (var t : tests) {
            var tok = lexer.nextToken();

            assertEquals(t.expectType, tok.getTokenType());

            assertEquals(t.expectLiteral, tok.getLiteral());
        }

    }
}