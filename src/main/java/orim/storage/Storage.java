package orim.storage;

import java.io.File;

public class Storage {

    private final File file;

    public Storage(String pathname) {
        this.file = new File(pathname);
    }

    void load() {

    }

}
