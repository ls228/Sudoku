package Controller;

import Game.Board;
import Game.Sudokus;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    GameController gamesTest = new GameController();
    Board testBoard = new Board();
    Sudokus sudokuTest = new Sudokus(1);

    @Test
    void checkInput() {
        testBoard.setGanzesBrett(sudokuTest.solutionBoard);
        Assumptions.assumeFalse(gamesTest.checkInput(2));
    }
}