package FlyWeight;

import java.util.HashMap;
import java.util.Map;

public class IconFactory {
    private static Map<PointType, Icon> icons = new HashMap<PointType, Icon>();

    public static Icon getIcon(PointType type) {
        if (!icons.containsKey(type)) {
            icons.put(type, new Icon());
            return icons.get(type);
        }
        return icons.get(type);
    }
}
