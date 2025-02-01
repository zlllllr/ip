package orim.command;

import orim.storage.Storage;
import orim.task.Task;
import orim.tasklist.TaskList;
import orim.ui.Ui;

public abstract class Command {

    private final boolean isExit;

    public Command() {
        this.isExit = false;
    }

    public Command(boolean isExit) {
        this.isExit = isExit;
    }

    public abstract void execute(TaskList tasks, Ui ui, Storage file); // excutes the command

    public boolean isExit() {
        return this.isExit;
    }

}
