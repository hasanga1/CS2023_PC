package Decorator;

public class OilPaint implements SmartFilter{
    private SmartFilter smartFilter;

    public OilPaint(SmartFilter smartFilter) {
        this.smartFilter = smartFilter;
    }

    @Override
    public void apply() {
        System.out.println("Applied oil paint");
        smartFilter.apply();
    }
}
