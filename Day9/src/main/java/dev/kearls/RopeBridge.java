package dev.kearls;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dev.kearls.Common.getInput;


public class RopeBridge {
    public int calculateMoves(String inputFileName) throws IOException {
        Position headPosition = new Position();
        Position tailPosition = new Position();
        Set<Position> positionsVisitedByTail = new HashSet<>();
        positionsVisitedByTail.add(tailPosition);


        List<String> input = getInput(inputFileName);
        System.out.println("Read " + input.size() + " lines");

        for (String line : input) {
            var parts = line.split(" ");
            assert(parts.length ==2);

            // I'm not sure that we need all of these...
            boolean sameRow = (headPosition.getX() == headPosition.getX());
            boolean sameColumn = (headPosition.getY() == tailPosition.getY());
            boolean overlapping = headPosition.equals(tailPosition);
            System.out.println("Overlapping? " + overlapping);

            // Move the head
            var direction = parts[0];
            int distance = Integer.valueOf(parts[1]);
            System.out.println("Move " + distance + " steps " + direction);
            headPosition.move(distance, direction);

            // FIXME how doees the tail move?  How do we keep track?

        }

        return positionsVisitedByTail.size();
    }
}
