class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void mark() {
        System.out.println("Nice! I've marked this task as done:\n[X] " + description);
        this.isDone = true;
    }

    public void unmark() {
        System.out.println("OK, I've marked this task as not done yet:\n[] " + description);
        this.isDone = false;
    }

    public String toString() {
        return description;
    }
}