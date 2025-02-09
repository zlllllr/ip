package orim;

import orim.command.Command;
import orim.myexception.MyException;
import orim.parser.Parser;
import orim.storage.Storage;
import orim.tasklist.TaskList;
import orim.ui.Ui;

import java.io.IOException;

/**
 * Represents a chatbot that allows user to keep track of their tasks.
 */
public class Orim {

    private final Storage storage;
    private TaskList tasks;
    private final Ui ui;

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
        Ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (MyException e) {
                Ui.showError(e.getMessage());
            } finally {
                Ui.showLine();
            }
        }
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        return "Duke heard: " + input;
    }

    public static void main(String[] args) {
        new Orim("data/tasks.txt").run();
    }

}
