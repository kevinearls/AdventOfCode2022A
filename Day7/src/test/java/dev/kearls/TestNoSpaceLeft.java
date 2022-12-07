package dev.kearls;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static dev.kearls.Common.getInput;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestNoSpaceLeft {
    private static final String EXAMPLE_INPUT = "src/main/resources/TestInput.txt";

    private static final String TEST_INPUT = "src/main/resources/input.txt";
    NoSpaceLeft solver = new NoSpaceLeft();

    private Integer wtf = Integer.valueOf(0);


    @Test
    public void testGetFileSizes() {
        File b = new File("b.txt", 14848514);
        File c = new File("c.txt", 8504156);
        Directory root = new Directory("/", null);
        Directory a = new Directory("a", root);

        Directory e = new Directory("e", a);
        File i = new File("i", 584);
        e.addFile(i);
        a.addDirectory(e);

        root.addDirectory(a);
        a.addFile(b);
        a.addFile(c);
        System.out.println(root.getTotalSizeOfFiles());
    }


    @Test
    public void testPart1Example() throws IOException {
        List<String> commands = getInput(EXAMPLE_INPUT);
        Directory tree = solver.processInput(commands);
        wtf = 0;
        sumAllDirectories(tree);
        assertEquals(95437, wtf);
    }

    @Test
    public void testPart1() throws IOException {
        List<String> commands = getInput(TEST_INPUT);
        Directory tree = solver.processInput(commands);
        wtf = 0;
        sumAllDirectories(tree);
        assertEquals(919137, wtf);
    }

    public void sumAllDirectories(Directory directory) {
        var directorySize = directory.getTotalSizeOfFiles();
        if (directorySize < 100000) {
            wtf = wtf + directorySize;
        }
        for (Directory d : directory.getSubDirectories()) {
            sumAllDirectories(d);
        }
    }



}
