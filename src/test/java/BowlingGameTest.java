import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.BowlInputFileReader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    private final String allLineZeroInputFilePath = "/Users/leqi/TWU_In-term/Week1-Day1/TDD_Fundamentals/tdd-bowling/src/test/java/data/all_line_zero.txt";

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
        List<List<Integer>> downPinsListAllZeros = BowlInputFileReader.readDownPinsListFromFile(allLineZeroInputFilePath);
        bowlingGame = new BowlingGame(gameRule, downPinsListAllZeros);

        // When
        int actualScores = bowlingGame.calculateTotalLinesScore();
        int expectScores = 0;

        // Then
        assertEquals(actualScores, expectScores);
    }
}
