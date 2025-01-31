class Task {
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

    public void mark() {
        this.isDone = true;
        System.out.println("Nice! I've marked this task as done:\n " + this.toString());
    }

    public void unmark() {
        this.isDone = false;
        System.out.println("OK, I've marked this task as not done yet:\n " + this.toString());
    }

    public String generateLog() { // generate log of the task
        return "";
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}