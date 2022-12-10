import java.io.IOException;
import java.util.*;

import static dev.kearls.Common.getInput;

public class CathodeRayTube {

    public int calculateSignalStrength(String inputFileName) throws IOException {
        List<Instruction> instructions = loadInstructionsFromFile(inputFileName);
        var checks = new int[]{20, 60, 100, 140, 180, 220};
        Set<Integer> checkAtCycles = new HashSet<>();  // TODO there must be a better way to do this
        for (int check : checks) {
            checkAtCycles.add(check);
        }

        int signalStrength = 0;
        int registerX = 1;
        int curentCycle = 1;
        for (Instruction instruction : instructions) {
            if (instruction.instruction == InstructionType.NOOP) {
                if (checkAtCycles.contains(curentCycle)) {
                    //System.out.println("(1) At cycle " + curentCycle + " registerX is " + registerX  + " Adding " + curentCycle*registerX);
                    signalStrength += (curentCycle * registerX);
                }
                curentCycle += 1;
            } else {
                for (int i=0 ; i < 2 ; i++) {

                    if (checkAtCycles.contains(curentCycle)) {
                        //System.out.println("Instruction was: " + instruction);
                        //System.out.println("(2) At cycle " + curentCycle + " registerX is " + registerX + " Adding " + curentCycle*registerX);

                        signalStrength += (curentCycle * registerX);
                    }
                    curentCycle += 1;
                }
                registerX += instruction.amount();  // This shouldn't be done till the end of the cycle?
            }
            //System.out.println("After instruction " + curentCycle + " X = " +registerX);
        }

        return signalStrength;
    }

    public List<Instruction> loadInstructionsFromFile(String inputFileName) throws IOException {
        List<String> lines = getInput(inputFileName);
        List<Instruction> instructions = new ArrayList<>();  // TODO does this maintain order?

        for (String line : lines) {
            var parts = line.trim().split(" ");
            if (parts.length == 2) {
                Instruction i = new Instruction(InstructionType.ADDX, Integer.valueOf(parts[1]));
                instructions.add(i);
            } else {
                Instruction i = new Instruction(InstructionType.NOOP, 0);
                instructions.add(i);
            }
        }

        /*
        for (Instruction i : instructions) {
            System.out.println(i);
        }

         */

        return instructions;
    }

    enum InstructionType {
        ADDX,
        NOOP
    }

    // TODO The noop instruction has no amount;  what is the best way to deal with that?
    record Instruction(InstructionType instruction, int amount){};
}
