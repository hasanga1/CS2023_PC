package Decorator;

public class SmartObject implements SmartFilter{
    @Override
    public void apply() {
        System.out.println("Converted a smart object");
    }
}
