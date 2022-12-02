package dev.kearls;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCommon {
    @Test
    public void testGetInput() throws IOException {
        String testFileName = "src/main/resources/testInput.txt";
        List<String> lines = Common.getInput(testFileName);
        assertEquals(3, lines.size());
    }

}
