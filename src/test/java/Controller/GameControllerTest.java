package Controller;

import Game.Board;
import Game.Sudokus;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class GameControllerTest {
    GameController gamesTest = new GameController();
    Board testBoard = new Board();
    Sudokus sudokuTest = new Sudokus(1,5);

    @Test
    void checkInput() {
        testBoard.setCompletedBoard(sudokuTest.solutionBoard);
        Assumptions.assumeFalse(gamesTest.checkInput(1,gamesTest.getRowCol("Label_0_0")));
    }
}