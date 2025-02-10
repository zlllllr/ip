package orim.command;

import orim.storage.Storage;
import orim.tasklist.TaskList;
import orim.ui.Ui;

/**
 * Represents a command to update the state of the task(done or not done).
 */

public class UpdateCommand extends Command {

    private final int index;
    private final boolean shouldMark;


    public UpdateCommand(int index, boolean shouldMark) {
        super(false);
        this.index = index;
        this.shouldMark = shouldMark;
    }

    /**
     * @param tasks TaskList that contain all the tasks.
     * @param ui deals with interactions with the user.
     * @param file deals with loading tasks from the file and saving tasks in the file.
     */
    public String execute(TaskList tasks, Ui ui, Storage file) {
        if (shouldMark) {
            return tasks.get(index).mark();
        } else {
            return tasks.get(index).unmark();
        }
    }

}
