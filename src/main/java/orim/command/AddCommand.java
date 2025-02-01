package orim.command;

import orim.storage.Storage;
import orim.task.Task;
import orim.tasklist.TaskList;
import orim.ui.Ui;

public class AddCommand extends Command {

    private final Task task;

    public AddCommand(Task task) {
        super(false);
        this.task = task;
    }

    public void execute(TaskList tasks, Ui ui, Storage file) {
        tasks.add(task);
        System.out.println("Got it. I've added this task:\n " + task.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

}
