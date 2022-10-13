package repl;

import lexer.Lexer;

import java.util.Objects;
import java.util.Scanner;

import static token.TokenTypeConst.EOF;

public class REPL {

    private static final String PROMPT1 = ">>> ";
    private static final String PROMPT2 = "... ";


    public static void start(/*可以加入输入输出流参数*/) {

        var scan = new Scanner(System.in);

        while(true) {
            System.out.print(PROMPT1);
            var line = scan.nextLine();

            if (line == null) {
                return;
            }

            if ("".equals(line)) {
                continue;
            }

            var lexer = new Lexer(line + "\n");

            for (var tok = lexer.nextToken(); !Objects.equals(tok.getTokenType(), EOF); tok = lexer.nextToken()) {
                System.out.println(tok);
            }

            System.out.println();
        }
    }
}
