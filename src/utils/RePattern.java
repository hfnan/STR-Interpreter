package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RePattern {
    public static final String varR = "var";
    public static final String addR = "\\+";
    public static final String subR = "-";
    public static final String mulR = "\\*";
    public static final String divR = "/";
    public static final String modR = "%";
    public static final String lparenR = "\\(";
    public static final String rparenR = "\\)";
    public static final String dAssignR = "=";
    public static final String idR = "[a-zA-Z_]([a-zA-Z0-9_])*";
    public static final String intcR = "[1-9][0-9]*|0";
    public static final String floatcR = "([1-9][0-9]*|0)\\.[0-9]*";
    public static final String strcR = "\\.";
    public static final String delimitR = "\n";

    public static final Pattern varP = Pattern.compile(varR);
    public static final Pattern addP = Pattern.compile(addR);
    public static final Pattern subP = Pattern.compile(subR);
    public static final Pattern mulP = Pattern.compile(mulR);
    public static final Pattern divP = Pattern.compile(divR);
    public static final Pattern modP = Pattern.compile(modR);
    public static final Pattern lparenP = Pattern.compile(lparenR);
    public static final Pattern rparenP = Pattern.compile(rparenR);
    public static final Pattern dAssignP = Pattern.compile(dAssignR);
    public static final Pattern idP = Pattern.compile(idR);
    public static final Pattern intcP = Pattern.compile(intcR);
    public static final Pattern floatcP = Pattern.compile(floatcR);
    public static final Pattern strcP = Pattern.compile(strcR);
    public static final Pattern delimitP = Pattern.compile(delimitR);

    public static int matchFirst(Pattern pattern, String text) {
        var mat = getMatcher(pattern, text);
        if (mat.find() && mat.start() == 0) {
            return mat.end();
        }
        return 0;
    }

    public static Matcher getMatcher(Pattern pattern, String text) {
        return pattern.matcher(text);
    }

    private RePattern() {}

}
