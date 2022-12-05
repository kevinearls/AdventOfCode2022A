import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestCampCleanup {

    private static final String EXAMPLE_INPUT = "src/main/resources/TestInput.txt";
    private static final String TEST_INPUT = "src/main/resources/input.txt";
    private final CampCleanup campCleanup = new CampCleanup();
    @Test
    public void testAssignmentFullyOverlaps() {
        var first = new Assignment("2", "4");
        var second = new Assignment(6, 8);
        assertFalse(first.fullyOverlaps(second));
        assertFalse(second.fullyOverlaps(first));

        var third = new Assignment(2, 8);
        var fourth = new Assignment(3,7);
        assertTrue(third.fullyOverlaps(fourth));
        assertTrue(fourth.fullyOverlaps(third));

        var fifth = new Assignment(6, 6);
        var sixth = new Assignment(4, 6);
        assertTrue(fifth.fullyOverlaps(sixth));
        assertTrue(sixth.fullyOverlaps(fifth));
    }

    @Test
    public void testAssignmentOverlapsAtAll() {
        var first = new Assignment("2", "4");
        var second = new Assignment(6, 8);
        assertFalse(first.overlapsAtAll(second));
        assertFalse(second.overlapsAtAll(first));
    }

    @Test
    public void testPart1Example() throws IOException {
        assertEquals(2, campCleanup.countFullOverlaps(EXAMPLE_INPUT));
    }

    @Test
    public void testPart1() throws IOException {
        assertEquals(511, campCleanup.countFullOverlaps(TEST_INPUT));
    }

    @Test
    public void testPart2Example() throws IOException {
        assertEquals(4, campCleanup.countOverlapsAtAll(EXAMPLE_INPUT));
    }

    @Test
    public void testPart2() throws IOException {
        assertEquals(821, campCleanup.countOverlapsAtAll(TEST_INPUT));
    }


}
