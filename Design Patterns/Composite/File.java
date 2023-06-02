package Composite;

public class File implements Directory{
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void delete() {
        System.out.println("Deleting file " + name);
    }

    public String getName() {
        return name;
    }
}
