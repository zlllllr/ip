package orim.command;

import orim.storage.Storage;
import orim.tasklist.TaskList;
import orim.ui.Ui;

public class UpdateCommand extends Command {

    private final int index;
    private final boolean shouldMark;

    public UpdateCommand(int index, boolean shouldMark) {
        super(false);
        this.index = index;
        this.shouldMark = shouldMark;
    }

    public void execute(TaskList tasks, Ui ui, Storage file) {
        if (shouldMark) {
            tasks.get(index).mark();
        } else {
            tasks.get(index).unmark();
        }
    }

}
