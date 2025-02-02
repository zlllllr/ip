package orim.command;

import orim.storage.Storage;
import orim.tasklist.TaskList;
import orim.ui.Ui;

public class SearchCommand extends Command {

    private final String searchKey;

    public SearchCommand(String searchKey) {

        super(false);
        this.searchKey = searchKey;

    }

    public void execute(TaskList tasks, Ui ui, Storage file) {
        TaskList ans = tasks.find(searchKey);
        Ui.showListing(ans);
    }

}
