package dev.kearls;

import java.io.IOException;
import java.util.List;
import static dev.kearls.Common.getInput;


public class Rucksack {
    public Integer reorganize(String filename) throws IOException {
        List<String> lines = getInput(filename);
        Integer totalOfPriorities = 0;

        for (String line : lines) {
            int halfway = line.length()/2;
            var first = line.substring(0, halfway);
            var second = line.substring(halfway);

            char inBoth = 'a';
            for (Character c : first.toCharArray()) {
                if (second.contains(String.valueOf(c))) {
                    inBoth = c;
                    break;
                }
            }

            totalOfPriorities += getItemValue(inBoth);
        }

        return totalOfPriorities;
    }

    public Integer getItemValue(char c) {
        Integer result=0;
        if (Character.isLowerCase(c)) {
            result = (int) c - 'a' + 1;
        } else {
            result = (int) c - 'A' + 27;
        }

        return result;
    }
}
