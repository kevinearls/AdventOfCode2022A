package dev.kearls;
import java.io.IOException;
import java.util.*;

import static dev.kearls.Common.getInput;

public class SupplyStacks {
    public String calculateTopsOfStack(String filename) throws IOException {
        List<String> lines = getInput(filename);

        // First figure out where the input is split between starting state and move commands, and figure out how many stacks there are
        var index = 0;
        var longestLine = Integer.MIN_VALUE;
        var line = lines.get(0);
        while (!line.trim().isBlank()) {
            index++;
            if (line.length() > longestLine) {
                longestLine = line.length();
            }
            line = lines.get(index);
        }
        var stackCount = longestLine/4 + 1;
        var maxHeight = index - 1;
        System.out.println("First blank line is " + index +  " stacks " + stackCount);  // TODO maxHeight of stacks is firstBlank - 1

        List<Deque<String>> supplyStacks = getSupplyStacks(lines, stackCount, maxHeight);
        List<Move> moves = getMoves(lines, index);

        for (Move move : moves) {
            var from = supplyStacks.get(move.getStartPosition() - 1);  // remember the input is 1-based
            var to = supplyStacks.get(move.getDestination()-1);
            for (int q=0; q<move.getQuantity(); q++) {
                to.push(from.pop());
            }
        }

        StringBuilder tops = new StringBuilder();
        for (Deque<String> stack : supplyStacks) {
            tops.append(stack.peek());
        }

        return tops.toString();
    }

    private List<Move> getMoves(List<String> lines, int blankLinePosition) {
        List<Move> moves = new ArrayList<>();

        var index = blankLinePosition + 1;
        while (index < lines.size()) {
            var commands = lines.get(index).split(" ");

            var quantity = commands[1];
            var startPosition = commands[3];
            var destination = commands[5];
            var move = new Move(quantity, startPosition, destination);
            moves.add(move);
            index++;
        }

        return moves;
    }

    private static List<Deque<String>> getSupplyStacks(List<String> lines, int stackCount, int maxHeight) {
        int index;
        String line;
        List<Deque<String>> supplyStacks = new ArrayList<>();
        for (int i = 0; i < stackCount; i++) {
            supplyStacks.add(new ArrayDeque<String>());
        }

        index = maxHeight - 1;
        while (index >= 0) {
            line = lines.get(index);
            // Here we need to split by position, taking 3 characters at a time.....
            for (int j = 0; j < stackCount; j++) {
                var firstChar = j * 4;
                if (line.length() > firstChar) {
                    var currentChunk = line.substring(firstChar, firstChar + 3);
                    if (!currentChunk.isBlank()) {
                        supplyStacks.get(j).push(currentChunk.substring(1,2));   // just push the letter
                    }
                }
            }
            index--;
        }

        return supplyStacks;
    }
}
