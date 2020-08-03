public abstract class GameRule {
    protected int MAX_LINES_PER_GAME;
    protected int MAX_PINS_PER_LINE;
    protected int MAX_THROWS_PER_LINE;

    public abstract int getLineScore(BowlingLine bowlingLine);
}
