public class NormalGameRule extends GameRule {
    public NormalGameRule() {
        this.MAX_LINES = 10;
        this.MAX_PINS = 10;
    }

    @Override
    public int getLineScore(BowlingLine bowlingLine) {
        if (bowlingLine.isStrike(MAX_PINS)) {
            // assert bowlingLine.getNextLine() != null;
            return MAX_PINS + bowlingLine.getNextLine().requireNextTwoThrowsScores(MAX_PINS);
        } else if (bowlingLine.isSpare(MAX_PINS)) {
            return MAX_PINS + bowlingLine.getNextLine().requireNextThrowScore();
        } else {
            return bowlingLine.sumOfThrows();
        }
    }
}
