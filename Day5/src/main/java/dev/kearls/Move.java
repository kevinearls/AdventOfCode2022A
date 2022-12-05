package dev.kearls;

public class Move {
    int quantity;
    int startPosition;
    int destination;

    public Move(int quantity, int startPosition, int destination) {
        this.quantity = quantity;
        this.startPosition = startPosition;
        this.destination = destination;
    }

    public Move(String quantity, String startPosition, String destination) {
        this.quantity = Integer.valueOf(quantity);
        this.startPosition = Integer.valueOf(startPosition);
        this.destination = Integer.valueOf(destination);
    }

    public int getQuantity() {
        return quantity;
    }

    public int getStartPosition() {
        return startPosition;
    }

    @Override
    public String toString() {
        return "Move{" + "quantity " + quantity + ", from " + startPosition + ", to " + destination + '}';
    }

    public int getDestination() {
        return destination;
    }


}
