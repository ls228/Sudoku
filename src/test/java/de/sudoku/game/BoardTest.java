package de.sudoku.game;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    Board testBoard = new Board();
    Sudokus getSudoku = new Sudokus();

    @Test
    public void getNumberAtIdx() {
        getSudoku.chosenSudoku(1,5);
        try {
            assertEquals(0, testBoard.getNumberAtIdx(1, 1), "is equal");
        } catch (Exception e) {
            throw new RuntimeException();

        }
    }

    @Test
    void checkWinning() {
        try {
            testBoard.setCompletedBoard(getSudoku.getPuzzleBoard().getBoardArray());
            testBoard.checkWinning();
            System.out.println(testBoard.checkWinning());
        } catch (Exception e) {
            throw new RuntimeException();
        }
        Assumptions.assumeFalse(testBoard.checkWinning());
    }

    @Test
    void checkIfFinished() {
        try {
            testBoard.setCompletedBoard(Sudokus.puzzleBoard);
            testBoard.checkIfFinished();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        Assumptions.assumeTrue(testBoard.checkIfFinished());
    }

    @Test
    void setValueInBrett() {
        try {
            testBoard.setCompletedBoard(Sudokus.puzzleBoard);
            testBoard.setValueInBoard(1, 1, 1);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        assertEquals(1, testBoard.getNumberAtIdx(1, 1));
    }


}
