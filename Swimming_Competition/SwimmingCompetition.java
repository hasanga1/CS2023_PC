import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SwimmingCompetition {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    public static void main(String[] arg) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name of the competition: ");
        String competition = scanner.nextLine();

        System.out.print("No of Swimmers: ");
        int noOfSwimmers = scanner.nextInt();
        List<Swimmer> swimmers = new ArrayList<>(noOfSwimmers);
        for (int i = 0; i < noOfSwimmers; i++) {
            System.out.print("ID: "); int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: "); String name = scanner.nextLine();
            System.out.print("Gender: "); String gender = scanner.nextLine();
            System.out.print("Lane Number: "); int lane = scanner.nextInt();scanner.nextLine();
            if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("MALE")) {
                swimmers.add(new Swimmer(id, name, Swimmer.Gender.MALE, lane));
            }
            else if (gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("FEMALE")) {
                swimmers.add(new Swimmer(id, name, Swimmer.Gender.FEMALE, lane));
            }
            else {
                System.out.println("Invalid Gender!");
                i--;
                continue;
            }
        }

        System.out.print("No of Judges: ");
        int noOfJudges = scanner.nextInt();
        List<Judge> judges = new ArrayList<>(noOfJudges);
        for (int i = 0; i < noOfJudges; i++) {
            System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
            System.out.print("Name: "); String name = scanner.nextLine();
            judges.add(new Judge(id, name));
        }

        System.out.print("No of Spectators: ");
        int noOfSpectators = scanner.nextInt();
        List<Spectator> spectators = new ArrayList<>(noOfSpectators);
        for (int i = 0; i < noOfSpectators; i++) {
            System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
            System.out.print("Name: "); String name = scanner.nextLine();
            spectators.add(new Spectator(id, name));
        }

        System.out.println("No of Lanes: ");
        int noOfLanes = scanner.nextInt();
        if (noOfLanes < noOfSwimmers) {
            System.out.println("Not enough Lanes!");
            return;
        }

        System.out.print("Length of the pool: ");
        int length = scanner.nextInt();

        ScoreBoard scoreBoard = new ScoreBoard();

        SwimmingPool swimmingPool = new SwimmingPool(noOfLanes, noOfJudges, noOfSwimmers, noOfSpectators, judges, swimmers, spectators, length, scoreBoard);

        System.out.println("WELCOME TO THE " + competition + "!\n");
        System.out.println("-----------Swimmers-----------");
        for (Swimmer swimmer: swimmers) {
            System.out.println(swimmer.getName() + "(" + swimmer.getId() + ")");
        }
        System.out.println("------------Judges------------");
        for (Judge judge: judges) {
            System.out.println(judge.getName() + "(" + judge.getId() + ")");


        }

        swimmingPool.setActiveJudge(judges.get((int) (Math.random() / noOfJudges)));

        ExecutorService executorService = Executors.newFixedThreadPool(noOfSwimmers);

        for (int i = 0; i < noOfSwimmers; i++) {
            int finalI = i;
            Runnable swimmer = new Runnable() {
                @Override
                public void run() {
                    synchronized (lock1) {
                        while (!swimmingPool.getActiveJudge().isBlew()) {
                            try {
                                lock1.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            try {
                                swimmingPool.getSwimmers().get(finalI).swim(Math.random() / 30, swimmingPool);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            };

            executorService.execute(swimmer);
        }

        Thread judge = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    lock2.notify();
                    judges.get((int) (Math.random() / noOfJudges)).blow();
                }

            }
        });

        scoreBoard.display();
    }
}
