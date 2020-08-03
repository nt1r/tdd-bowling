import java.util.ArrayList;
import java.util.List;

public class BowlingLine {
    private List<BowlingThrow> throwList = new ArrayList<>();
    private int MAX_PINS_PER_LINE = 10;
    private int MAX_THROWS_PER_LINE = 2;

    private BowlingLine nextLine;

    public BowlingLine(List<Integer> scores, int MAX_PINS_PER_LINE, int MAX_THROWS_PER_LINE) {
        this.MAX_PINS_PER_LINE = MAX_PINS_PER_LINE;
        this.MAX_THROWS_PER_LINE = MAX_THROWS_PER_LINE;
        if (checkScoresValidness(scores)) {
            for (int score : scores) {
                throwList.add(new BowlingThrow(score));
            }
        } else {
            throw new RuntimeException("Input invalid.");
        }
    }

    public BowlingLine getNextLine() {
        return nextLine;
    }

    public void setNextLine(BowlingLine nextLine) {
        this.nextLine = nextLine;
    }

    public List<BowlingThrow> getThrowList() {
        return throwList;
    }

    private boolean checkScoresValidness(List<Integer> scores) {
        if (scores.get(0) == MAX_PINS_PER_LINE && scores.size() == MAX_THROWS_PER_LINE) {
            return false;
        }
        return true;
    }

    int requireNextTwoThrowsScores() {
        if (throwList.size() < 2) {
            // next line or append line not null
            return MAX_PINS_PER_LINE + nextLine.requireNextThrowScore();
        } else {
            return throwList.get(0).getScore() + throwList.get(1).getScore();
        }
    }

    int requireNextThrowScore() {
        return throwList.get(0).getScore();
    }

    boolean isStrike() {
        return throwList.get(0).getScore() == MAX_PINS_PER_LINE;
    }

    boolean isSpare() {
        return !isStrike() && throwList.get(0).getScore() + throwList.get(1).getScore() == MAX_PINS_PER_LINE;
    }
}
