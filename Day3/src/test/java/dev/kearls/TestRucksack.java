package dev.kearls;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;



public class TestRucksack {
    private static final String EXAMPLE_INPUT = "src/main/resources/TestInput.txt";
    private static final String TEST_INPPUT = "src/main/resources/input.txt";
    final Rucksack rucksack = new Rucksack();
    @Test
    public void testPart1Example() throws IOException {
        assertEquals(157, rucksack.reorganize(EXAMPLE_INPUT));
    }

    @Test
    public void testPart1() throws IOException {
        assertEquals(7980, rucksack.reorganize(TEST_INPPUT));
    }

    @Test
    public void testPart2Example() throws IOException {
        assertEquals(70, rucksack.getPriorityByGroup(EXAMPLE_INPUT));
    }

    @Test
    public void testPart2() throws IOException {
        assertEquals(2881, rucksack.getPriorityByGroup(TEST_INPPUT));
    }

}
