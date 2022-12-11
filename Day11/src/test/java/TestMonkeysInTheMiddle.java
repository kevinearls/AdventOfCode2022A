import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static dev.kearls.Common.getInput;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMonkeysInTheMiddle {
    private static final String EXAMPLE_INPUT = "src/main/resources/TestInput.txt";
    private static final String TEST_INPUT = "src/main/resources/input.txt";
    private MonkeysInTheMiddle mitm = new MonkeysInTheMiddle();
    @Test
    public void testPart1Example() throws IOException {
        assertEquals(10605, mitm.calculateMonkeyBusinessLevel(EXAMPLE_INPUT));
    }

    @Test
    public void testPart1() throws IOException {
        assertEquals(78678, mitm.calculateMonkeyBusinessLevel(TEST_INPUT));
    }


    @Test
    public void testStuff() {
        var monkeyString = "Monkey 2:";
        System.out.println(Arrays.toString(monkeyString.split(" |:")));
        var parts = monkeyString.split(" |:");
        int id = Integer.valueOf(parts[1]);
        System.out.println(id);

        var line = "    Starting items: 79, 98";
        line = line.replace(" ", "");
        var indexofColon = line.indexOf(":");
        parts = line.substring(indexofColon+1).trim().split(",");

        // This returns an arrya of ints, it would be nice to figure out how to get a list directly
        var startingItems = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(startingItems));

        // Operation
        //line = "   Operation: new = old * 19";
        line =  "    Operation: new = old + 6";
        parts = line.substring(line.indexOf("old") + 3).trim().split(" ");
        assert(parts.length == 2);
        System.out.println(Arrays.toString(parts));
        Monkey.Operation operation;
        if (parts[0].equals("*")) {
            operation = Monkey.Operation.MULTIPLY;
        } else {
            operation = Monkey.Operation.ADD;
        }
        int operationValue = Integer.valueOf(parts[1]);
        System.out.println(operation + " " + operationValue);

        line = "    Test: divisible by 19";
        var divisibleValue = Integer.valueOf(line.substring(line.lastIndexOf(" ")+1));
        System.out.println(divisibleValue);

        line = "    If true: throw to monkey 0";
        var trueRecipient = Integer.valueOf(line.substring(line.lastIndexOf(" ") + 1));
        System.out.println("Value: [" + trueRecipient + "]");
    }

    @Test
    public void testReadingFile() throws IOException {
        List<String> input = getInput(EXAMPLE_INPUT);

        int monkeyCount = 0;
        List<String> lines = new ArrayList<>();
        var index = 0;
        while (index < input.size()) {
            var line = input.get(index);
            if (line.trim().isBlank()) {
                monkeyCount++;
                System.out.println("Monkey " + monkeyCount++ + " " + lines);
                lines = new ArrayList<>();
            } else {
                lines.add(line);
            }
            index++;
        }
        // TODO if we fall out do we have to print the last one?
        if (lines.size() > 0) {
            System.out.println("Last one");
            System.out.println("Monkey " + monkeyCount++ + " " + lines);
        }
    }

}
