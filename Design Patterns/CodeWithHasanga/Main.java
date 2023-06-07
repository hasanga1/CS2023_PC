package CodeWithHasanga;

import Mediator.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] arg) throws InterruptedException {

        List<Flight> flights = new ArrayList<Flight>();
        List<Runaway> runaways = new ArrayList<Runaway>();

        ATC atc = new ATC();

        flights.add(new Flight(atc, "0001"));
        flights.add(new Flight(atc, "0002"));
        flights.add(new Flight(atc, "0003"));

        runaways.add(new Runaway("#01"));
        runaways.add(new Runaway("#02"));

        for (Runaway runaway: runaways) {
            atc.addRunaway(runaway, true);
        }

        Thread flight0001 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (flights.get(0).checkRunaway(runaways.get(0))) {
                        flights.get(0).land(runaways.get(0));
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread flight0002 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (flights.get(1).checkRunaway(runaways.get(0))) {
                        flights.get(1).land(runaways.get(0));
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        flight0001.start();
        flight0002.start();

        flight0001.join();
        flight0002.join();
    }
}
