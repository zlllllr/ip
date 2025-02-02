package orim.task;

<<<<<<< HEAD
/**
 * Represents Users' tasks.
 */
>>>>>>> branch-A-CodingStandard
public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    private String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Marks the task as done.
     */
    public void mark() {
        this.isDone = true;
        System.out.println("Nice! I've marked this task as done:\n " + this.toString());
    }

    /**
     * Marks the task as not done.
     */
    public void unmark() {
        this.isDone = false;
        System.out.println("OK, I've marked this task as not done yet:\n " + this.toString());
    }

    /**
     * Transforms the state and detail of the tasks to a string.
     * Will be store in the data file and be reloaded when user open Orim again.
     *
     * @return log to represents the state and detail of the tasks
     */
    public String generateLog() { // generate log of the task
        return "";
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}