package FlyWeight;

import java.util.ArrayList;
import java.util.List;

public class GoogleMap {
    private List<Point> points = new ArrayList<Point>();

    public List<Point> getPoints() {
        points.add(new Point(2, 4, PointType.HOSPITAL));
        points.add(new Point(8, 2, PointType.SCHOOL));
        points.add(new Point(1, 10, PointType.CAFE));
        points.add(new Point(9, 4, PointType.HOSPITAL));

        return points;
    }
}
