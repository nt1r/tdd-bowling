import java.util.ArrayList;
import java.util.List;

public class BowlingLine {
    private List<BowlingThrow> throwList = new ArrayList<>();

    private BowlingLine nextLine;

    public BowlingLine(List<Integer> scores) {
        for (int score : scores) {
            throwList.add(new BowlingThrow(score));
        }
    }

    public BowlingLine getNextLine() {
        return nextLine;
    }

    public void setNextLine(BowlingLine nextLine) {
        this.nextLine = nextLine;
    }

    int requireNextTwoThrowsScores(int MAX_PINS) {
        if (throwList.size() < 2 && nextLine != null) {
            return MAX_PINS + nextLine.requireNextThrowScore();
        } else {
            return throwList.get(0).getScore() + throwList.get(1).getScore();
        }
    }

    int requireNextThrowScore() {
        return throwList.get(0).getScore();
    }

    int sumOfThrows() {
        int sum = 0;
        for (BowlingThrow bowlingThrow : throwList) {
            sum += bowlingThrow.getScore();
        }
        return sum;
    }

    boolean isStrike(int MAX_PINS) {
        return throwList.get(0).getScore() == MAX_PINS;
    }

    boolean isSpare(int MAX_PINS) {
        return !isStrike(MAX_PINS) && throwList.get(0).getScore() + throwList.get(1).getScore() == MAX_PINS;
    }
}
