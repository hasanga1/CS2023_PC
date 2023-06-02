package CodeWithHasanga;

import Composite.File;
import Composite.Folder;

public class Main {
    public static void main(String[] arg) {
        File bst = new File("BST.cpp");
        File heap = new File("Heap.cpp");

        Folder cppProject = new Folder("Clion Projects");
        cppProject.add(bst);
        cppProject.add(heap);

        File tutorial1 = new File("Tutorial1.pdf");
        File tutorial2 = new File("Tutorial2.pdf");

        Folder tutorial = new Folder("Tutorials");
        tutorial.add(tutorial1);
        tutorial.add(tutorial2);

        Folder uni = new Folder("University");
        uni.add(cppProject);
        uni.add(tutorial);

        uni.delete();
    }
}
