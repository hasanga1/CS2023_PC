package Mediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATC {
    private List<Flight> flights = new ArrayList<Flight>();
    private List<Runaway> runaways = new ArrayList<Runaway>();
    private List<Boolean> availability = new ArrayList<Boolean>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void addRunaway(Runaway runaway, Boolean availability) {
        runaways.add(runaway);
        this.availability.add(availability);
    }

    public boolean land(Flight flight, Runaway runaway) throws InterruptedException {
            int index = checkIndex(runaway);
            if (index == -1) {
                return false;
            }
            if (availability.get(index)) {
                availability.set(index, false);
                System.out.println("Flight " + flight.getId() + " is Landing trough the runaway " + runaway.getId());
                Thread.sleep(4000);
                System.out.println("Flight " + flight.getId() + " is successfully landed.");
                availability.set(index, true);
                return true;
            }
            System.out.println("Flight " + flight.getId() + " attempt failed.");
            return false;
    }

    public boolean checkAvailability(Flight flight, Runaway runaway) {
        for (int i = 0; i < runaways.size(); i++) {
            if (runaways.get(i) == runaway) {
                if (availability.get(i)) {
                    System.out.println("Flight " + flight.getId() + " can land through the runaway " + runaway.getId());
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public int checkIndex(Runaway runaway) {
        for (int i = 0; i < runaways.size(); i++) {
            if (runaways.get(i) == runaway) {
                return i;
            }
        }
        return -1;
    }
}
