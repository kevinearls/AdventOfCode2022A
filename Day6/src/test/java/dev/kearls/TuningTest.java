package dev.kearls;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static dev.kearls.Common.getInput;


public class TuningTest {
    private static final String TEST_INPUT = "src/main/resources/input.txt";
    private final Tuning tuning = new Tuning();
    @Test
    public void testHasRepeatingCharacters() {
        Assert.assertFalse(tuning.hasRepeatingCharacters("abcd"));
        Assert.assertTrue(tuning.hasRepeatingCharacters("abba"));
    }

    @Test
    public void testPart1ExampleData() {
        Assert.assertEquals(7, tuning.findFirstMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 4));
        Assert.assertEquals(5, tuning.findFirstMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", 4));
        Assert.assertEquals(6, tuning.findFirstMarker("nppdvjthqldpwncqszvftbrmjlhg", 4));
        Assert.assertEquals(10, tuning.findFirstMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 4));
        Assert.assertEquals(11, tuning.findFirstMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 4));
    }

    @Test
    public void testPart1() throws IOException {
        List<String> input = getInput(TEST_INPUT);
        Assert.assertEquals(1, input.size());
        Assert.assertEquals(1640, tuning.findFirstMarker(input.get(0), 4));
    }

    @Test
    public void testPart2ExampleData() {
        Assert.assertEquals(19, tuning.findFirstMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 14));
        Assert.assertEquals(23, tuning.findFirstMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", 14));
        Assert.assertEquals(23, tuning.findFirstMarker("nppdvjthqldpwncqszvftbrmjlhg", 14));
        Assert.assertEquals(29, tuning.findFirstMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 14));
        Assert.assertEquals(26, tuning.findFirstMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 14));
    }

    @Test
    public void testPart2() throws IOException {
        List<String> input = getInput(TEST_INPUT);
        Assert.assertEquals(1, input.size());
        Assert.assertEquals(3613, tuning.findFirstMarker(input.get(0), 14));
    }

}
