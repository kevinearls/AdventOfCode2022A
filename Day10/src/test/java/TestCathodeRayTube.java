import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCathodeRayTube {
    private static final String EXAMPLE_INPUT = "src/main/resources/TestInput.txt";
    private static final String TEST_INPUT = "src/main/resources/input.txt";
    private CathodeRayTube crt = new CathodeRayTube();

    @Test
    public void testPart1Example() throws IOException {
        assertEquals(13140, crt.calculateSignalStrength(EXAMPLE_INPUT));
    }

    @Test
    public void testPart1() throws IOException {
        assertEquals(13760, crt.calculateSignalStrength(TEST_INPUT));
    }

    @Test
    public void testPart2Example() throws IOException {
        crt.drawSomething(EXAMPLE_INPUT);
    }

    @Test
    public void testPart2() throws IOException {
        crt.drawSomething(TEST_INPUT);

        // Draws RFKZCPEF
    }


}
