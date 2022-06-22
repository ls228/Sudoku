package Game;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    Board testBoard = new Board();
    Sudokus getSudoku = new Sudokus(1);

    @Test
    public void getNumberAtIdx() {
        try {
            assertEquals(0, testBoard.getNumberAtIdx(1, 1), "is equal");
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Test
    void checkWinning() {
        try {
            testBoard.setGanzesBrett(getSudoku.solutionBoard);
            testBoard.checkWinning();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        Assumptions.assumeTrue(testBoard.checkWinning());
    }

    @Test
    void checkIfFinished() {
        try {
            testBoard.setGanzesBrett(Sudokus.puzzleBoard);
            testBoard.checkIfFinished();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        Assumptions.assumeTrue(testBoard.checkIfFinished());
    }

    @Test
    void setValueInBrett() {
        try {
            testBoard.setGanzesBrett(Sudokus.puzzleBoard);
            testBoard.setValueInBrett(1, 1, 1);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        assertEquals(1, testBoard.getNumberAtIdx(1, 1));
    }

    @Test
    void getInstance() {

    }

}
