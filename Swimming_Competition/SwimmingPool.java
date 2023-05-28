import java.util.ArrayList;
import java.util.List;

public class SwimmingPool {
    private int noOfLanes;
    private int noOfJudges;
    private int noOfSwimmers;
    private int noOfSpectators;
    private int lenght;
    private ScoreBoard scoreBoard;
    private List<TouchPad> touchPads;
    private List<Judge> judges;
    private List<Swimmer> swimmers;
    private List<Spectator> spectators;
    private Judge activeJudge;

    public SwimmingPool(int noOfLanes, int noOfJudges, int noOfSwimmers, int noOfSpectators, List<Judge> judges, List<Swimmer> swimmers, List<Spectator> spectators, int lenght, ScoreBoard scoreBoard) {
        this.noOfLanes = noOfLanes;
        this.noOfJudges = noOfJudges;
        this.noOfSwimmers = noOfSwimmers;
        this.noOfSpectators = noOfSpectators;
        this.judges = judges;
        this.swimmers = swimmers;
        this.spectators = spectators;
        this.lenght = lenght;
        this.scoreBoard = scoreBoard;

        touchPads = new ArrayList<TouchPad>(noOfLanes);
        for (int i = 0; i < noOfLanes; i++) {
            touchPads.add(new TouchPad());
        }
    }

    public int getNoOfLanes() {
        return noOfLanes;
    }

    public int getNoOfJudges() {
        return noOfJudges;
    }

    public int getNoOfSwimmers() {
        return noOfSwimmers;
    }

    public int getNoOfSpectators() {
        return noOfSpectators;
    }

    public List<Swimmer> getSwimmers() {
        return swimmers;
    }

    public Judge getActiveJudge() {
        return activeJudge;
    }

    public void setActiveJudge(Judge activeJudge) {
        this.activeJudge = activeJudge;
    }

    public int getLenght() {
        return lenght;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setTouchPad(int lane, double time, Swimmer swimmer) {
        this.touchPads.get(lane).setTime(time);
        this.touchPads.get(lane).setSwimmer(swimmer);
        scoreBoard.addScore(touchPads.get(lane));
    }
}
