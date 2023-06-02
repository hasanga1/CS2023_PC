package Composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Directory{
    private String name;
    private List<Directory> directories = new ArrayList<Directory>();

    @Override
    public void delete() {
        for (Directory directory: directories) {
            directory.delete();
        }
    }
    public void add (Directory directory) {
        directories.add(directory);
    }

    public Folder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
