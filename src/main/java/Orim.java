import orim.command.Command;
import orim.myexception.MyException;
import orim.parser.Parser;
import orim.storage.Storage;
import orim.tasklist.TaskList;
import orim.ui.Ui;

import java.io.IOException;

public class Orim {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Orim(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (IOException e) {
            Ui.showError(e.getMessage());
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (MyException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Orim("data/tasks.txt").run();
    }

}
