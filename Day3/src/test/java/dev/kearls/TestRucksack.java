package dev.kearls;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static dev.kearls.Common.getInput;
import static org.junit.jupiter.api.Assertions.*;



public class TestRucksack {
    @Test
    public void testPart1Example() throws IOException {
        String inputFileName = "src/main/resources/TestInput.txt";
        Rucksack rucksack = new Rucksack();
        assertEquals(157, rucksack.reorganize(inputFileName));
    }

    @Test
    public void testPart1() throws IOException {
        String inputFileName = "src/main/resources/input.txt";
        Rucksack rucksack = new Rucksack();
        assertEquals(7980, rucksack.reorganize(inputFileName));
    }

}
