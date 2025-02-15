package orim.command;

import orim.storage.Storage;
import orim.tasklist.TaskList;
import orim.ui.Ui;

/**
 * Represents a command for searching task from taskList
 */
public class SearchCommand extends Command {

    private final String searchKey;

    public SearchCommand(String searchKey) {

        super(false);
        this.searchKey = searchKey;

    }

    /**
     * @param tasks TaskList that contain all the tasks.
     * @param ui deals with interactions with the user.
     * @param file deals with loading tasks from the file and saving tasks in the file.
     * @return
     */
    public String execute(TaskList tasks, Ui ui, Storage file) {
        TaskList ans = tasks.find(searchKey);
        return Ui.showListing(ans);
    }

}
