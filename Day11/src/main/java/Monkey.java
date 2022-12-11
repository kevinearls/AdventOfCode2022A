import java.util.ArrayList;
import java.util.List;

public class Monkey {
    public enum Operation {
        ADD,
        MULTIPLY,
        SQUARE
    }
    private int ID;
    private List<Integer> items;
    private Operation operation;
    private int operationValue;
    private int divisibleByValue;
    private Monkey ifTrueRecipient;
    private Monkey ifFalseRecipient;
    private int ifTrueRecipientId;
    private int ifFalseRecipientId;
    private int inspectionCount = 0;

    public Monkey(int ID,List<Integer> items, Operation operation, int operationValue, int divisibleByValue, int ifTrueRecipientId, int ifFalseRecipientId) {
        this.ID = ID;
        this.items = new ArrayList<>(items);
        this.operation = operation;
        this.operationValue = operationValue;
        this.divisibleByValue = divisibleByValue;
        this.ifTrueRecipientId = ifTrueRecipientId;
        this.ifFalseRecipientId = ifFalseRecipientId;
    }

    public void move() {  // FXME we need to keep a global count of how many items were inspected!
        // First step, apply operation
        for (Integer item : items) {
            inspectionCount++;
            switch(operation) {
                case SQUARE:
                    item = item * item;
                    break;
                case ADD:
                    item += operationValue;
                    break;
                case MULTIPLY:
                    item *= operationValue;
                    break;
                default:
                    throw new RuntimeException("**** We should never get here!!!");
            }
            // Second step, get bored
            item = item / 3;

            // Now decide who to give this to
            if (item % divisibleByValue == 0) {
                ifTrueRecipient.receive(item);
            } else {
                ifFalseRecipient.receive(item);
            }
        }
        // How do we get rid of items we gave away?
        items = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public void receive(int itemNumber) {
        items.add(itemNumber);
    }

    public boolean performTest() {
        return false;
    }

    public int getIfTrueRecipientId() {
        return ifTrueRecipientId;
    }

    public int getIfFalseRecipientId() {
        return ifFalseRecipientId;
    }

    public void setIfTrueRecipient(Monkey ifTrueRecipient) {
        this.ifTrueRecipient = ifTrueRecipient;
    }

    public void setIfFalseRecipient(Monkey ifFalseRecipient) {
        this.ifFalseRecipient = ifFalseRecipient;
    }


    public int getInspectionCount() {
        return inspectionCount;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Monkey { ID " + ID);
        builder.append(", items=" + items );
        builder.append(", operationValue=" + operationValue);
        builder.append(", divisibleByValue=" + divisibleByValue);
        if (ifTrueRecipient != null) {
            builder.append(", ifTrueRecipient=" + ifTrueRecipient.getID());
        } else {
            builder.append(", ifTrueRecipientID=" + ifTrueRecipientId);
        }
        if (ifFalseRecipient != null) {
            builder.append(", ifFalseRecipient=" + ifFalseRecipient.getID());
        } else {
            builder.append(", ifFalseRecipientID=" + ifFalseRecipientId);
        }
        builder.append(", inspection count=" + inspectionCount);
        builder.append(" }");
        return builder.toString();
    }
}
