import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<BowlingLine> lineList = new ArrayList<>();

    private GameRule rule;

    public BowlingGame(GameRule rule, List<List<Integer>> downPinsList) {
        this.rule = rule;
        AddLinesFromDownPinsList(downPinsList);
        setNextPointer();
    }

    private void AddLinesFromDownPinsList(List<List<Integer>> downPinsList) {
        for (List<Integer> downPins : downPinsList) {
            lineList.add(new BowlingLine(downPins, rule.MAX_PINS_PER_LINE, rule.MAX_THROWS_PER_LINE));
        }
    }

    private void setNextPointer() {
        for (int index = 0; index < lineList.size() - 1; ++index) {
            lineList.get(index).setNextLine(lineList.get(index + 1));
        }
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
