package Factory;

public class Car extends Vehicle{
    public Car() {
        super.noOfWheels = 4;
    }

    @Override
    public void drive() {
        System.out.println("The car is moving...");
    }
}
