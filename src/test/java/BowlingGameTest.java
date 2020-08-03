import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.BowlInputFileReader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    private final String allThrowZerosInputFilePath = "src/test/java/data/all_throw_zeros.txt";
    private final String allThrowOnesInputFilePath = "src/test/java/data/all_throw_ones.txt";
    private final String strikeNotTheLastInputFilePath = "src/test/java/data/strike_not_the_last.txt";
    private final String strikeInTheLastInputFilePath = "src/test/java/data/strike_in_the_last.txt";
    private final String strikeContinuousInputFilePath = "src/test/java/data/strike_continuous.txt";
    private final String pinsAllDownInputFilePath = "src/test/java/data/all_pins_down.txt";
    private final String spareNotTheLastInputFilePath = "src/test/java/data/spare_not_the_last.txt";
    private final String spareContinuousInputFilePath = "src/test/java/data/spare_continuous.txt";
    private final String spareInTheLastInputFilePath = "src/test/java/data/spare_in_the_last.txt";

    BowlingGame bowlingGame;
    GameRule gameRule = new NormalGameRule();


    @BeforeEach
    private void clearGame() {
        if (bowlingGame != null) {
            bowlingGame.clear();
        }
    }

    @Test
    public void should_get_zero_when_all_throws_are_zeros() {
        // Given
        initBowlGameWithFile(allThrowZerosInputFilePath);

        // When
        int actualScores = bowlingGame.calculateTotalLinesScore();
        int expectScores = 0;

        // Then
        assertEquals(actualScores, expectScores);
    }

    @Test
    public void should_get_twenty_when_all_throws_are_one() {
        // Given
        initBowlGameWithFile(allThrowOnesInputFilePath);

        // When
        int actualScores = bowlingGame.calculateTotalLinesScore();
        int expectScores = 20;

        // Then
        assertEquals(actualScores, expectScores);
    }

    @Test
    public void when_throws_contain_strike_not_contains_spare() {
        // Given
        initBowlGameWithFile(strikeNotTheLastInputFilePath);

        // When
        int actualScores = bowlingGame.calculateTotalLinesScore();
        int expectScores = 82;

        // Then
        assertEquals(actualScores, expectScores);
    }

    @Test
    public void when_throws_contain_strike_in_the_last_line() {
        // Given
        initBowlGameWithFile(strikeInTheLastInputFilePath);

        // When
        int actualScores = bowlingGame.calculateTotalLinesScore();
        int expectScores = 102;

        // Then
        assertEquals(actualScores, expectScores);
    }

    @Test
    public void when_throws_contain_continuous_strikes() {
        // Given
        initBowlGameWithFile(strikeContinuousInputFilePath);

        // When
        int actualScores = bowlingGame.calculateTotalLinesScore();
        int expectScores = 125;

        // Then
        assertEquals(actualScores, expectScores);
    }

    @Test
    public void when_pins_are_all_down() {
        // Given
        initBowlGameWithFile(pinsAllDownInputFilePath);

        // When
        int actualScores = bowlingGame.calculateTotalLinesScore();
        int expectScores = 300;

        // Then
        assertEquals(actualScores, expectScores);
    }

    @Test
    public void when_throws_contain_spare_without_strike() {
        // Given
        initBowlGameWithFile(spareNotTheLastInputFilePath);

        // When
        int actualScores = bowlingGame.calculateTotalLinesScore();
        int expectScores = 87;

        // Then
        assertEquals(actualScores, expectScores);
    }

    @Test
    public void when_throws_contain_continuous_spares() {
        // Given
        initBowlGameWithFile(spareContinuousInputFilePath);

        // When
        int actualScores = bowlingGame.calculateTotalLinesScore();
        int expectScores = 113;

        // Then
        assertEquals(actualScores, expectScores);
    }

    @Test
    public void when_throws_contain_spare_in_the_last_line() {
        // Given
        initBowlGameWithFile(spareInTheLastInputFilePath);

        // When
        int actualScores = bowlingGame.calculateTotalLinesScore();
        int expectScores = 89;

        // Then
        assertEquals(actualScores, expectScores);
    }

    private void initBowlGameWithFile(String filePath) {
        List<List<Integer>> downPinsList = BowlInputFileReader.readDownPinsListFromFile(filePath);
        // System.out.println(BowlInputFileReader.outputDebug(downPinsListStrikeInTheLast));
        bowlingGame = new BowlingGame(gameRule, downPinsList);
    }
}
