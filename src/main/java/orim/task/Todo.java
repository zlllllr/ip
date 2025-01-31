package orim.task;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public Todo(String isDone, String description) {
        super(description, isDone.equals("1"));
    }

    public String generateLog() {
        return "T," + (isDone ? 1 : 0) + "," + super.description;
    }

    public String toString() {
        return "[T]" + super.toString();
    }
}
