import java.io.IOException;
import java.util.List;

import static dev.kearls.Common.getInput;

public class CampCleanup {
    public int countFullOverlaps(String filename) throws IOException {
        int overlaps= 0;
        List<String> lines = getInput(filename);
        for (String line : lines) {
            var pairs = line.split(",");
            var firstValues = pairs[0].split("-");
            var firstAssignment = new Assignment(firstValues[0], firstValues[1]);
            var secondValues = pairs[1].split("-");
            var secondAssignment = new Assignment(secondValues[0], secondValues[1]);

            if (firstAssignment.fullyOverlaps(secondAssignment)) {
                overlaps++;
            }
        }

        return overlaps;
    }

    public int countOverlapsAtAll(String filename) throws IOException {
        int overlaps= 0;
        List<String> lines = getInput(filename);
        for (String line : lines) {
            var pairs = line.split(",");
            var firstValues = pairs[0].split("-");
            assert(firstValues.length ==  2);
            var firstAssignment = new Assignment(Integer.valueOf(firstValues[0]), Integer.valueOf(firstValues[1]));
            var secondValues = pairs[1].split("-");
            assert(secondValues.length ==  2);
            var secondAssignment = new Assignment(Integer.valueOf(secondValues[0]), Integer.valueOf(secondValues[1]));

            if (firstAssignment.overlapsAtAll(secondAssignment)) {
                overlaps++;
            }
        }

        return overlaps;
    }
}
