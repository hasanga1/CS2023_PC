package Factory;

public class Bike extends Vehicle{
    public Bike() {
        super.noOfWheels = 2;
    }

    @Override
    public void drive() {
        System.out.println("The Bike is moving...");
    }
}
