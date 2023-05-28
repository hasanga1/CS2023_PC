import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScoreBoard {
    private List<TouchPad> touchPads;

    public ScoreBoard() {
        touchPads = new ArrayList<TouchPad>();
    }

    public void addScore(TouchPad touchPad) {
        synchronized (touchPads) {
            touchPads.add(touchPad);
            for (int i = 0; i < touchPads.size(); i++) {
                for (int j = 1; j < touchPads.size() - i; j++) {
                    if (touchPads.get(j - 1).getTime() > touchPads.get(j).getTime()) {
                        TouchPad temp = touchPads.get(j - 1);
                        touchPads.set(j - 1, touchPads.get(j));
                        touchPads.set(j, temp);
                    }
                }
            }
        }
    }

    public void display() {
            System.out.println("Name\t\tRank");
            for (TouchPad t: touchPads) {
                System.out.println(t.getSwimmer().getName() + "\t\t" + t.getTime());
        }
    }
}
