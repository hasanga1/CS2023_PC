package Mediator;

public class Flight {
    private ATC atc;
    private String id;

    public Flight(ATC atc, String id) {
        this.atc = atc;
        this.id = id;
    }

    public boolean land(Runaway runaway) throws InterruptedException {
        return atc.land(this, runaway);
    }

    public String getId() {
        return id;
    }

    public boolean checkRunaway(Runaway runaway) throws InterruptedException {
        return atc.checkAvailability(this, runaway);
    }
}
