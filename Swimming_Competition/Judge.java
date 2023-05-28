public class Judge extends Person{
    private boolean isBlew = false;
    public Judge(int id, String name) {
        super(id, name);
    }
    private Object lock = new Object();

    public void blow() {
        System.out.println("Judge " + this.getName() + " blew the whistle!");
        synchronized (lock) {
            isBlew = true;
            lock.notify();
        }
    }

    public boolean isBlew() {
        return isBlew;
    }
}
