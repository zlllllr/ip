package orim.command;

import orim.storage.Storage;
import orim.task.Task;
import orim.tasklist.TaskList;
import orim.ui.Ui;

public class DeleteCommand extends Command {

    private final int index;

    public DeleteCommand(int index) {
        super(false);
        this.index = index;
    }

    public void execute(TaskList tasks, Ui ui, Storage file){
        Task temp = tasks.delete(index);
        System.out.println("Noted. I've removed this task:\n " + temp.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}
