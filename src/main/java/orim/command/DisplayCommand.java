package orim.command;

import orim.storage.Storage;
import orim.tasklist.TaskList;
import orim.ui.Ui;

public class DisplayCommand extends Command{

    public DisplayCommand() {
        super(false);
    }

    public void execute(TaskList  tasks, Ui ui, Storage file) {
        Ui.showListing(tasks);
    }

}
