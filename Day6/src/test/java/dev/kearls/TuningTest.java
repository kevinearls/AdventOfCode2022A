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
        Assert.assertTrue("Can I put a message here?", tuning.hasRepeatingCharacters("abba"));
    }

    // Useing test data from part 1
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

}
