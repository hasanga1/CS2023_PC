package Factory;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type) {
        if (type == VehicleType.CAR) {
            return new Car();
        }
        else if (type == VehicleType.BIKE) {
            return new Bike();
        }
        else {
            return new Car();
        }
    }
}
