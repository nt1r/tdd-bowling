import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.BowlInputFileReader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    private final String allThrowZerosInputFilePath = "/Users/leqi/TWU_In-term/Week1-Day1/TDD_Fundamentals/tdd-bowling/src/test/java/data/all_throw_zeros.txt";
    private final String allThrowOnesInputFilePath = "/Users/leqi/TWU_In-term/Week1-Day1/TDD_Fundamentals/tdd-bowling/src/test/java/data/all_throw_ones.txt";
    private final String strikeNotTheLastInputFilePath = "/Users/leqi/TWU_In-term/Week1-Day1/TDD_Fundamentals/tdd-bowling/src/test/java/data/strike_not_the_last.txt";

    BowlingGame bowlingGame;
    GameRule gameRule = new NormalGameRule();


    @BeforeEach
    private void initGame() {
        if (bowlingGame != null) {
            bowlingGame.clear();
        }
    }

    @Test
    public void should_get_zero_when_all_throws_are_zeros() {
        // Given
        List<List<Integer>> downPinsListAllZeros = BowlInputFileReader.readDownPinsListFromFile(allThrowZerosInputFilePath);
        bowlingGame = new BowlingGame(gameRule, downPinsListAllZeros);

        // When
        int actualScores = bowlingGame.calculateTotalLinesScore();
        int expectScores = 0;

        // Then
        assertEquals(actualScores, expectScores);
    }

    @Test
    public void should_get_twenty_when_all_throws_are_one() {
        // Given
        List<List<Integer>> downPinsListAllOnes = BowlInputFileReader.readDownPinsListFromFile(allThrowOnesInputFilePath);
        // System.out.println(BowlInputFileReader.outputDebug(downPinsListAllOnes));
        bowlingGame = new BowlingGame(gameRule, downPinsListAllOnes);

        // When
        int actualScores = bowlingGame.calculateTotalLinesScore();
        int expectScores = 20;

        // Then
        assertEquals(actualScores, expectScores);
    }

    @Test
    public void should_get_right_when_throw_contains_strike_not_contains_spare() {
        // Given
        List<List<Integer>> downPinsListStrikeNotTheLast = BowlInputFileReader.readDownPinsListFromFile(strikeNotTheLastInputFilePath);
        bowlingGame = new BowlingGame(gameRule, downPinsListStrikeNotTheLast);

        // When
        int actualScores = bowlingGame.calculateTotalLinesScore();
        int expectScores = 82;

        // Then
        assertEquals(actualScores, expectScores);
    }
}
