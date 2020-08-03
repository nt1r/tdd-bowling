import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<BowlingLine> lineList = new ArrayList<>();

    private GameRule rule;

    public BowlingGame(GameRule rule, List<List<Integer>> downPinsList) {
        this.rule = rule;

        for (List<Integer> downPins : downPinsList) {
            lineList.add(new BowlingLine(downPins));
        }

        /* set next pointer in 'BowlingLine' */
        for (int index = 0; index < lineList.size() - 1; ++index) {
            lineList.get(index).setNextLine(lineList.get(index + 1));
        }
        /* set next pointer in 'BowlingLine' */
    }

    public int calculateTotalLinesScore() {
        int sum = 0;
        for (BowlingLine bowlingLine: lineList) {
            sum += rule.getLineScore(bowlingLine);
        }
        return sum;
    }

    public void clear() {
        lineList.clear();
    }
}
