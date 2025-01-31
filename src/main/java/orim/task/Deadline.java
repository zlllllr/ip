package orim.task;

public class Deadline extends Task {
    private LocalDate time;

    public Deadline(String description, String time) {
        super(description);
        this.time = LocalDate.parse(time);
    }

    public Deadline(String isDone, String description, String time) {
        super(description, isDone.equals("1"));
        this.time = LocalDate.parse(time);
    }

    public String generateLog() {
        return "D," + (isDone ? 1 : 0) + "," + super.description + "," + time;
    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + time.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}
