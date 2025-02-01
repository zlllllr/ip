package orim.command;

import orim.storage.Storage;
import orim.tasklist.TaskList;
import orim.ui.Ui;

import java.io.IOException;

public class ExitCommand extends Command {

    public ExitCommand() {
        super(true);
    }

    public void execute(TaskList tasks, Ui ui, Storage file) {
        Ui.showGoodbye();
        try {
            file.store(tasks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
