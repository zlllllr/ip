package orim.command;

import orim.storage.Storage;
import orim.task.Task;
import orim.tasklist.TaskList;
import orim.ui.Ui;

/**
 * Represents a command to delete task from TaskList.
 */
public class DeleteCommand extends Command {

    private final int index;

    public DeleteCommand(int index) {
        super(false);
        this.index = index;
    }

    /**
     * @param tasks TaskList that contain all the tasks.
     * @param ui deals with interactions with the user.
     * @param file deals with loading tasks from the file and saving tasks in the file.
     */
    public void execute(TaskList tasks, Ui ui, Storage file){
        Task temp = tasks.delete(index);
        System.out.println("Noted. I've removed this task:\n " + temp.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}
