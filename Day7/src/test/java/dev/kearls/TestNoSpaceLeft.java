package dev.kearls;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dev.kearls.Common.getInput;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestNoSpaceLeft {
    private static final String EXAMPLE_INPUT = "src/main/resources/TestInput.txt";

    private static final String TEST_INPUT = "src/main/resources/input.txt";
    NoSpaceLeft solver = new NoSpaceLeft();

    private Integer wtf = Integer.valueOf(0);
    private List<Integer> directorySizes = new ArrayList<>();


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

    @Test
    public void testPart2Example() throws IOException {
        List<String> commands = getInput(EXAMPLE_INPUT);
        Directory tree = solver.processInput(commands);

        // TODO build a List<Integer> of sizes, and then sort them
        directorySizes = new ArrayList<>();
        addDirectorySizesToList(tree);
        Collections.sort(directorySizes);
        var totalUsedDiskSpace = directorySizes.get(directorySizes.size() - 1);
        var freeSpace = NoSpaceLeft.TOTAL_SPACE_AVAILABLE - totalUsedDiskSpace;
        var neededForUpdate = NoSpaceLeft.NEEDED_FOR_UPDATE - freeSpace;
        System.out.println("Total: " + totalUsedDiskSpace + " Free: " + freeSpace + " Needed: " + neededForUpdate);

        for (Integer i : directorySizes) {
            if (i > neededForUpdate) {
                System.out.println("Got one: " + i);
                assertEquals(24933642, i);
                return;
            }
        }

        // TODO if we get to here we fail...
    }

    @Test
    public void testPart2() throws IOException {
        List<String> commands = getInput(TEST_INPUT);
        Directory tree = solver.processInput(commands);

        directorySizes = new ArrayList<>();
        addDirectorySizesToList(tree);
        Collections.sort(directorySizes);
        var totalUsedDiskSpace = directorySizes.get(directorySizes.size() - 1);
        var freeSpace = NoSpaceLeft.TOTAL_SPACE_AVAILABLE - totalUsedDiskSpace;
        var neededForUpdate = NoSpaceLeft.NEEDED_FOR_UPDATE - freeSpace;
        System.out.println("Total: " + totalUsedDiskSpace + " Free: " + freeSpace + " Needed: " + neededForUpdate);

        for (Integer i : directorySizes) {
            if (i > neededForUpdate) {
                System.out.println("Got one: " + i);
                assertEquals(2877389, i);
                return;
            }
        }

        // TODO if we get to here we fail...
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

    public void addDirectorySizesToList(Directory directory) {
        var directorySize = directory.getTotalSizeOfFiles();
        directorySizes.add(directorySize);
        for (Directory d : directory.getSubDirectories()) {
            addDirectorySizesToList(d);
        }
    }





}
