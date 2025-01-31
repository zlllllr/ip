public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public String generateLog() {
        return "T|" + (isDone ? 1 : 0) + "|" + super.description;
    }

    public String toString() {
        return "[T]" + super.toString();
    }
}
