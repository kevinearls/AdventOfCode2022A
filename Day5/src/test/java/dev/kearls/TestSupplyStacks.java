package dev.kearls;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSupplyStacks {
    private static final String EXAMPLE_INPUT = "src/main/resources/TestInput.txt";
    private static final String TEST_INPUT = "src/main/resources/input.txt";
    private SupplyStacks supplyStacks = new SupplyStacks();

    @Test
    public void testPart1Example() throws IOException {
        assertEquals("CMZ", supplyStacks.calculateTopsOfStack(EXAMPLE_INPUT));
    }

    @Test
    public void testPart1() throws IOException {
        var wtf = new ArrayDeque<String>();
        assertEquals("PTWLTDSJV", supplyStacks.calculateTopsOfStack(TEST_INPUT));
    }
}
