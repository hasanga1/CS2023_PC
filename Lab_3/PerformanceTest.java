package Lab_3;
import java.util.List;
import java.util.ArrayList;

class StudentRecord {
    int index;
    double GPA;

    public StudentRecord(int index, double GPA) {
        this.index = index;
        this.GPA = GPA;
    }

    public int getIndex() {
        return index;
    }

    public double getGPA() {
        return GPA;
    }
};
public class PerformanceTest {
    public static void main(String[] arg) {

        List<StudentRecord> records = new ArrayList<StudentRecord>();

        int size = 10;

        for (int i = 0; i <= size; i++) {
            records.add(new StudentRecord(i, Math.random() / 4.00));
        }

        Runtime runtime = Runtime.getRuntime();

        // Get the runtime to execute the garbage collector.
        // This is making a direct request to run the GC.
        // Otherwise, the system decides when to run the GC.

        runtime.gc();

        // Calculate the amount of memory used by your program

        long memory = runtime.totalMemory() - runtime.freeMemory();

        // Print the performance test data to the console
        // Find the size of the SomeObject instance that you are storing. Let's call it objSize

        // StudentRecord class has 1 integer and one double. So, the size of the class is 4 + 8 + 4 = 16
        int objSize = 16;

        System.out.println("Size of the stored object: " + objSize + " bytes");
        int calculatedSize = objSize*size;
        System.out.println("Size of the stored collection: " + calculatedSize + " bytes");
        System.out.println("Used memory: " + memory + " bytes");
        System.out.println("Memory overhead: " + (memory-calculatedSize) + " bytes");
    }
}