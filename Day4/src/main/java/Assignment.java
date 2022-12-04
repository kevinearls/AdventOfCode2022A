public class Assignment {
    private int first;
    private int last;


    public Assignment(int first, int last) {
        this.first = first;
        this.last = last;
    }

    public boolean fullyOverlaps(Assignment other) {
        if (((this.first >= other.first) && (this.last <= other.last)) || ((other.first >= this.first) && (other.last <= this.last))) {
                return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }
}
