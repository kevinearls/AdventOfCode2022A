package dev.kearls;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestRopeBridge {
    private static final String EXAMPLE_INPUT = "src/main/resources/TestInput.txt";
    private static final String TEST_INPUT = "src/main/resources/input.txt";
    private RopeBridge ropeBridge = new RopeBridge();

    @Test
    public void testPart1ExampleInput() throws IOException {
        assertEquals(13, ropeBridge.calculateMoves(EXAMPLE_INPUT));
    }

    @Test
    public void testPart1() throws IOException {
        assertEquals(13, ropeBridge.calculateMoves(TEST_INPUT));
    }
}
