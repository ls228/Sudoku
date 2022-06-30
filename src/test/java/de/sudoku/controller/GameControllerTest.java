package de.sudoku.controller;

import de.sudoku.game.Board;
import de.sudoku.game.Sudokus;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class GameControllerTest {
    //funktioniert nicht
    Sudokus getSudoku=new Sudokus();
    GameController gameController = new GameController();
    Board testBoard = new Board();
    Sudokus sudokuTest = new Sudokus();

    @Test
    public void checkInput() {
        getSudoku.allSudokus(1, 1);
        //GameController.Position position = GameController.getRowCol("Label_0_0");
        testBoard.setCompletedBoard(sudokuTest.getSolutionBoard().getBoardArray());
        //Assumptions.assumeFalse(gameController.checkInput(8,position));
    }
/*
    @Test
    void getRowCol() {
            //assertEquals(0,gameController.getRowCol("Label_0_0"));
    }*/
}