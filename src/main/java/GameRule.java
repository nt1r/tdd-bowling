public abstract class GameRule {
    protected int MAX_LINES;
    protected int MAX_PINS;

    public abstract int getLineScore(BowlingLine bowlingLine);
}
