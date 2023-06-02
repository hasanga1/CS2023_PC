package Decorator;

public class CameraRawFilter implements SmartFilter{
    private SmartFilter smartFilter;

    public CameraRawFilter(SmartFilter smartFilter) {
        this.smartFilter = smartFilter;
    }

    @Override
    public void apply() {
        System.out.println("Applying camera raw filters...");
        smartFilter.apply();
    }
}
