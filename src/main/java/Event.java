public class Event extends Task {
    private final String from;
    private final String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public String generateLog() {
        return "E|" + (isDone ? 1 : 0) + "|" + super.description + "|" + from + "|" + to;
    }

    public String toString() {
        return "[E]" + super.toString() + "(from: " + from + " to: " + to + ")";
    }
}