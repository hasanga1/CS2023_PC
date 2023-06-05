package FlyWeight;

public class Point {
    private int x;
    private int y;
    private Icon icon;
    private PointType type;

    public Point(int x, int y, PointType type) {
        this.x = x;
        this.y = y;
        this.icon = icon;
        this.type = type;
        icon = IconFactory.getIcon(type);
    }

    public void draw() {
        System.out.printf("%s at (%d, %d)\n", type, x, y);
    }
}
