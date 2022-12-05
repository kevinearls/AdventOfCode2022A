public class Assignment {
    private int first;
    private int last;


    public Assignment(int first, int last) {
        this.first = first;
        this.last = last;
    }

    public Assignment(String first, String last) {
        this.first = Integer.valueOf(first);
        this.last = Integer.valueOf(last);
    }

    public boolean fullyOverlaps(Assignment other) {
        if (((this.first >= other.first) && (this.last <= other.last)) || ((other.first >= this.first) && (other.last <= this.last))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean overlapsAtAll(Assignment other) {
        if (((this.first <= other.last) && (this.last >= other.first)) || ((other.first <= this.last) && (other.last >= this.first))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Assignment{" + "first=" + first + ", last=" + last + '}';
    }
}
