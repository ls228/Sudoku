package de.sudoku.game;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    Board testBoard = new Board();
    Sudokus getSudoku = new Sudokus();


    @Test
    public void getNumberAtIdx() {
        getSudoku.allSudokus(1, 5);
        try {
            testBoard.setCompletedBoard(getSudoku.getSolutionBoard().getBoardArray());
        } catch (Exception e) {
            throw new RuntimeException();
        }
        assertEquals(2, testBoard.getNumberAtIdx(1, 1), "is equal");
        assertEquals(9, testBoard.getNumberAtIdx(0, 0), "is equal");
        assertEquals(6, testBoard.getNumberAtIdx(2, 2), "is equal");
    }

    @Test
    void checkWinning() {
        try {
            testBoard.setCompletedBoard(testBoard.boardScheme);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        Assumptions.assumeFalse(testBoard.checkWinning());
    }

    @Test
    void checkIfFinished() {
        try {
            testBoard.setCompletedBoard(getSudoku.getPuzzleBoard().getBoardArray());
        } catch (Exception e) {
            throw new RuntimeException();
        }
        Assumptions.assumeTrue(testBoard.checkIfFinished());
    }

    @Test
    void setValueInBoard() {
        try {
            testBoard.setCompletedBoard(getSudoku.getSolutionBoard().getBoardArray());
            testBoard.setValueInBoard(1, 1, 1);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        assertEquals(1, testBoard.getNumberAtIdx(1, 1));
    }


}