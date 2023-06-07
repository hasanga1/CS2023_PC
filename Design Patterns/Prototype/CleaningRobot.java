package Prototype;

public class CleaningRobot implements Cloneable {
    public String id;
    private final int[][] dustMap = new int[10000][10000];
    {
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                dustMap[i][j] = (int) (Math.random() * 2);
            }
        }
    }

    public CleaningRobot(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int[][] getDustMap() {
        return dustMap;
    }

    public void clean() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (dustMap[i][j] == 1) {
                    System.out.printf("%s is cleaning the cell (%d, &%d)\n", this.id, i, j);
                }
            }
        }
    }

    public CleaningRobot clone(String id) throws CloneNotSupportedException {
        CleaningRobot temp = this.clone();
        temp.id = id;
        return temp;
    }

    @Override
    protected CleaningRobot clone() throws CloneNotSupportedException {
        return (CleaningRobot) super.clone();
    }
}
