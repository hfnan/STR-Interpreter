package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Help to read and write files
 * @author hfnan
 */
public class FileHelper {

    public static String readFile(String path) {
        return String.join("\n", readLines(path)) + "\n";
    }

    public static void writeFile(String path, String content) {
        writeLines(path, List.of(content));
    }

    public static List<String> readLines(String path) {
        try (final var lines = Files.lines(Paths.get(path))) {
            return lines.toList();
        } catch (IOException e) {
            throw new RuntimeException("IO Exception on " + path, e);
        }
    }

    public static void writeLines(String path, List<String> lines) {
        try {
            Files.write(Paths.get(path), lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("IO Exception for " + path);
        }
    }

    private FileHelper() {}
}
