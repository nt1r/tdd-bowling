public class NormalGameRule extends GameRule {
    public NormalGameRule() {
        this.MAX_LINES_PER_GAME = 10;
        this.MAX_PINS_PER_LINE = 10;
        this.MAX_THROWS_PER_LINE = 2;
    }

    @Override
    public int getLineScore(BowlingLine bowlingLine) {
        if (isBowlingLineHasExtendThrow(bowlingLine)) {
            return sumLinesDownPins(bowlingLine);
        } else {
            if (bowlingLine.isStrike()) {
                return MAX_PINS_PER_LINE + bowlingLine.getNextLine().requireNextTwoThrowsScores();
            } else if (bowlingLine.isSpare()) {
                return MAX_PINS_PER_LINE + bowlingLine.getNextLine().requireNextThrowScore();
            } else {
                return sumLinesDownPins(bowlingLine);
            }
        }
    }

    private boolean isBowlingLineHasExtendThrow(BowlingLine bowlingLine) {
        return bowlingLine.getThrowList().size() > MAX_THROWS_PER_LINE;
    }

    private int sumLinesDownPins(BowlingLine bowlingLine) {
        int sum = 0;
        for (BowlingThrow bowlingThrow : bowlingLine.getThrowList()) {
            sum += bowlingThrow.getScore();
        }
        return sum;
    }
}
