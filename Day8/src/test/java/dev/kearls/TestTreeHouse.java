package dev.kearls;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestTreeHouse {
    private static final String EXAMPLE_INPUT = "src/main/resources/TestInput.txt";
    private static final String TEST_INPUT = "src/main/resources/input.txt";
    private final Treehouse treehouse = new Treehouse();


    @Test
    public void testPart1Example() throws IOException {
        assertEquals(21, treehouse.countVisibleTrees(EXAMPLE_INPUT));
    }

    @Test
    public void testPart1() throws IOException {
        assertEquals(1820, treehouse.countVisibleTrees(TEST_INPUT));  // 3458 is too high, 1578 is too low
    }

    @Test
    public void testPart2Example() throws IOException {
        assertEquals(8, treehouse.getBestScenicScore(EXAMPLE_INPUT));
    }

    @Test
    public void testPart2() throws IOException {
        assertEquals(385112, treehouse.getBestScenicScore(TEST_INPUT));
    }

}

