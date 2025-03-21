public class Entry implements Priority {
    String val;
    int priority;
    public Entry(String value,int pri){
        val = value;
        priority = pri;
    }
    @Override
    public int priority() {
        return priority;
    }

    @Override
    public String toString() {
        return "(" + val + "pri=" + priority + ")!";
    }
}
