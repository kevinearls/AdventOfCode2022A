import java.io.IOException;
import java.util.*;

import static dev.kearls.Common.getInput;

public class MonkeysInTheMiddle {

    public int calculateMonkeyBusinessLevel(String filename) throws IOException {
        Monkey[] monkees = loadMonkeys(filename);

        for (int round = 1; round <= 20; round++) {
            int i=0;
            while ((i < monkees.length)) {
                Monkey m = monkees[i];
                m.move();
                i++;
            }
            if (round % 10 == 0) {
                System.out.println("---------- After round " + round + "----------");
                for (Monkey m : monkees) {
                    System.out.println(m);
                }
            }
        }


        // Now get the two highest inspection counts and multiply
        int[] inspectionCounts = new int[monkees.length];
        for (Monkey m : monkees) {
            inspectionCounts[m.getID()] = m.getInspectionCount();
        }

        Arrays.sort(inspectionCounts);

        int level=inspectionCounts[inspectionCounts.length-1] * inspectionCounts[inspectionCounts.length - 2];
        return level;
    }

    public Monkey[] loadMonkeys(String filename) throws IOException {
        Map<Integer, Monkey> monkeys = new HashMap<>();
        List<String> lines = getInput(filename);
        int index = 0;
        int monkeyId = 0;  // TODO do we really need this?
        while (index < lines.size()) {
            var line = lines.get(index);
            while (!line.startsWith("Monkey")) {  // FIXME we need a cleaner way to deal wtih EOF
                index++;
                if (index >= lines.size()) {
                    // Do we ever get here?
                    Monkey[] wtf = new Monkey[monkeys.size()];
                    for (int i=0; i < monkeys.size() ; i++) {
                        wtf[i] = monkeys.get(i);
                    }
                    //return new ArrayList<>(monkeys.values());
                }
                line = lines.get(index);
            }
            var parts = line.split(" |:");
            int id = Integer.valueOf(parts[1]);   // should we use monkeyId here?
            assert(id == monkeyId);
            line = lines.get(++index);

            // Get the starting items
            line = line.replace(" ", "");
            var indexofColon = line.indexOf(":");
            parts = line.substring(indexofColon+1).trim().split(",");
            var startingItems = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
            List<Integer> startingItemsList = Arrays.stream(startingItems).boxed().toList();
            line = lines.get(++index);

            // Get the operation
            parts = line.substring(line.indexOf("old") + 3).trim().split(" ");
            assert(parts.length == 2);
            Monkey.Operation operation;
            int operationValue = 0;
            if (parts[0].equals("*")) {
                if (parts[1].equals("old")) {
                    operation = Monkey.Operation.SQUARE;
                } else {
                    operation = Monkey.Operation.MULTIPLY;
                    operationValue = Integer.valueOf(parts[1]);
                }
            } else {
                operation = Monkey.Operation.ADD;
                operationValue = Integer.valueOf(parts[1]);
            }

            line = lines.get(++index);

            // Test Value
            var divisibleByValue = Integer.valueOf(line.substring(line.lastIndexOf(" ")+1));
            line = lines.get(++index);

            // Now get the true and false lines...for now assume true and false are in order
            var trueRecipient = Integer.valueOf(line.substring(line.lastIndexOf(" ") + 1));
            line=lines.get(++index);
            var falseRecipient = Integer.valueOf(line.substring(line.lastIndexOf(" ") + 1));

            Monkey m = new Monkey(id, startingItemsList, operation, operationValue, divisibleByValue, trueRecipient, falseRecipient);
            //System.out.println("Monkey? " + m) ;
            monkeys.put(id, m);
            monkeyId++;
            index++;
        }

        // TODO set recipients
        for (Integer id : monkeys.keySet()) {
            Monkey monkey = monkeys.get(id);
            var trm = monkeys.get(monkey.getIfTrueRecipientId());
            var frm = monkeys.get(monkey.getIfFalseRecipientId());
            monkey.setIfTrueRecipient(trm);
            monkey.setIfFalseRecipient(frm);
        }

        Monkey[] wtf = new Monkey[monkeys.size()];
        for (int i=0; i < monkeys.size() ; i++) {
            wtf[i] = monkeys.get(i);
        }

        return wtf;
    }
}
