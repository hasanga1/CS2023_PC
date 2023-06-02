package CodeWithHasanga;

import Decorator.CameraRawFilter;
import Decorator.OilPaint;
import Decorator.SmartFilter;
import Decorator.SmartObject;

public class Main {
    public static void applyFilter(SmartFilter img) {
        img.apply();
    }
    public static void main(String[] arg) {
        applyFilter(new OilPaint(new CameraRawFilter(new SmartObject())));
    }

}
