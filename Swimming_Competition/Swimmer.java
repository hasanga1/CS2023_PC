public class Swimmer extends Person{
    private String colour;
    private Object lock = new Object();
    public static enum Gender{
        MALE, FEMALE
    }
    int lane;

    public Swimmer(int id, String name, Gender gender, int lane) {
        super(id, name);
        if (gender == Gender.MALE) {
            this.colour = "Blue";
        }
        else {
            this.colour = "Red";
        }
        this.lane = lane;
    }

    public String getColour() {
        return colour;
    }

    public void swim(double speed, SwimmingPool swimmingPool) throws InterruptedException {
        System.out.println(this.getName() + " is swimming.");
        Thread.sleep((int) speed * swimmingPool.getLenght());
        System.out.println(this.getName() + " touched the touchPad");
        swimmingPool.setTouchPad(lane, (int) speed * swimmingPool.getLenght(), this);
    }
}
