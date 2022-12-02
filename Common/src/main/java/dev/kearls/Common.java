package dev.kearls;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Common {
    public static List<String> getInput(String filename) throws IOException {
        Path inputFile = Paths.get(filename);

        List<String> lines = Files.readAllLines(inputFile);
        System.out.println("Input has " + lines.size() + " lines");

        return lines;
    }
}
