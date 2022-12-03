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

    public Integer getPriorityByGroup(String filename) throws IOException {
        List<String> lines = getInput(filename);
        Integer totalOfPriorities = 0;

        // how do we get three lines at a time?
        int index = 0;
        while (index < lines.size()) {
            var first = lines.get(index);
            var second = lines.get(index + 1);
            var third = lines.get(index + 2);
            index += 3;

            char badge = 'a';
            for (Character c : first.toCharArray()) {
                if (second.contains(String.valueOf(c)) && (third.contains(String.valueOf(c))) ) {
                    badge = c;
                    break;
                }
            }
            totalOfPriorities += getItemValue(badge);
        }

        return totalOfPriorities;
    }

    public Integer getItemValue(char c) {
        int result;
        if (Character.isLowerCase(c)) {
            result = (int) c - 'a' + 1;
        } else {
            result = (int) c - 'A' + 27;
        }

        return result;
    }
}
