
// Abstract Factory

abstract class Device {
    public abstract void getDetails();

}

class Dell extends Device {
    private int ram;
    private int storage;
    private int VGA;

    public Dell(int ram, int storage, int VGA) {
        this.ram = ram;
        this.storage = storage;
        this.VGA = VGA;
    }

    @Override
    public void getDetails() {
        System.out.println("Ram: " + ram);
        System.out.println("Storage: " + storage);
        System.out.println("VGA: " + VGA);
    }
}

class Macbook extends Device {
    private int ram;
    private int storage;
    private int VGA;

    public Macbook(int ram, int storage, int VGA) {
        this.ram = ram;
        this.storage = storage;
        this.VGA = VGA;
    }

    @Override
    public void getDetails() {
        System.out.println("Ram: " + ram);
        System.out.println("Storage: " + storage);
        System.out.println("VGA: " + VGA);
    }
}

class Nokia extends Device {
    private int ram;
    private int storage;

    public Nokia(int ram, int storage) {
        this.ram = ram;
        this.storage = storage;
    }

    @Override
    public void getDetails() {
        System.out.println("Ram: " + ram);
        System.out.println("Storage: " + storage);
    }
}

class IPhone extends Device {
    private int ram;
    private int storage;

    public IPhone(int ram, int storage) {
        this.ram = ram;
        this.storage = storage;
    }

    @Override
    public void getDetails() {
        System.out.println("Ram: " + ram);
        System.out.println("Storage: " + storage);
    }
}

enum DeviceType {
    DELL, MACBOOK, NOKIA, IPHONE
}
abstract class AbstractFactory {
    public abstract Device getGadget(DeviceType deviceType);
}

class LaptopFactory extends AbstractFactory {

    @Override
    public Device getGadget(DeviceType deviceType) {
        switch (deviceType) {
            case DELL -> {
                return new Dell(8, 512, 2);
            }
            case MACBOOK -> {
                return new Macbook(8, 256, 2);
            }
        }
        return null;
    }
}

class MobileFactory extends AbstractFactory {

    @Override
    public Device getGadget(DeviceType deviceType) {
        switch (deviceType) {
            case NOKIA -> {
                return new Nokia(4, 32);
            }
            case IPHONE -> {
                return new IPhone(8, 128);
            }
        }
        return null;
    }
}

enum FactoryType {
    LAPTOP, MOBILE
}
class FactoryGenerator {
    public static AbstractFactory createFactory(FactoryType factoryType) {
        switch (factoryType) {
            case LAPTOP -> {
                return new LaptopFactory();
            }
            case MOBILE -> {
                return new MobileFactory();
            }
        }
        return null;
    }
}

public class DesignPattern {
    public static void main(String[] arg) {
        Device device = FactoryGenerator.createFactory(FactoryType.MOBILE).getGadget(DeviceType.IPHONE);
        device.getDetails();
    }
}
