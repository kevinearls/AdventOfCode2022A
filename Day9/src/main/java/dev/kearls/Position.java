package dev.kearls;

public class Position {
    private int x;
    private int y;

    public Position() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int steps, String direction) {
         switch (direction) {
             case "U":
                 this.y += steps;
                 break;
             case "D":
                 this.y -= steps;
                 break;
             case "L":
                 this.x -= steps;
                 break;
             case "R":
                 this.x += steps;
                 break;
             default:
                 throw new RuntimeException("No such direction as [" + direction +"]");
         }

        System.out.println("New position is " + x + ", " + y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
