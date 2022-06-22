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
        }catch (Exception e){
            throw new RuntimeException();
        }
    }


    @Test
    void checkWinning() {
        try{
            testBoard.setGanzesBrett(getSudoku.solutionBoard);
            testBoard.checkWinning();
        }catch (Exception e){
            throw new RuntimeException();
        }
        Assumptions.assumeTrue(testBoard.checkWinning());
    }


    @Test
    void checkIfFinished() {
        try{
            testBoard.setGanzesBrett(Sudokus.puzzleBoard);
            testBoard.checkIfFinished();
        }catch (Exception e){
            throw new RuntimeException();
        }
        Assumptions.assumeTrue(testBoard.checkIfFinished());
    }


    @Test
    void setValueInBrett() {
        try{
            testBoard.setGanzesBrett(Sudokus.puzzleBoard);
            testBoard.setValueInBrett(1, 1,1);
            testBoard.setValueInBrett(2, 3,5);
            testBoard.setValueInBrett(5, 5,8);
            testBoard.setValueInBrett(6, 7,9);
            testBoard.setValueInBrett(8, 2,4);

        }catch (Exception e){
            throw new RuntimeException();
        }
        assertEquals(1,testBoard.getNumberAtIdx(1, 1));
        assertEquals(5,testBoard.getNumberAtIdx(2, 3));
        assertEquals(8,testBoard.getNumberAtIdx(5, 5));
        assertEquals(9,testBoard.getNumberAtIdx(6, 7));
        assertEquals(4,testBoard.getNumberAtIdx(8, 2));
    }


    @Test
    void setGanzesBrett() {

        int[][] gameValues = {
                {3, 5, 7, 2, 4, 8, 9, 1, 6},
                {9, 1, 4, 5, 6, 3, 7, 8, 2},
                {6, 2, 8, 1, 9, 7, 5, 3, 4},
                {4, 9, 5, 8, 3, 6, 2, 7, 1},
                {1, 8, 6, 7, 2, 9, 4, 5, 3},
                {7, 3, 2, 4, 5, 1, 8, 6, 9},
                {5, 6, 1, 9, 7, 4, 3, 2, 8},
                {2, 4, 3, 6, 8, 5, 1, 9, 7},
                {8, 7, 9, 3, 1, 2, 6, 4, 5},
        };
        testBoard.setGanzesBrett(gameValues);

        // row 1
        assertEquals(3, testBoard.getNumberAtIdx(0,0));
        assertEquals(5, testBoard.getNumberAtIdx(0,1));
        assertEquals(7, testBoard.getNumberAtIdx(0,2));
        assertEquals(2, testBoard.getNumberAtIdx(0,3));
        assertEquals(4, testBoard.getNumberAtIdx(0,4));
        assertEquals(8, testBoard.getNumberAtIdx(0,5));
        assertEquals(9, testBoard.getNumberAtIdx(0,6));
        assertEquals(1, testBoard.getNumberAtIdx(0,7));
        assertEquals(6, testBoard.getNumberAtIdx(0,8));

        // last row as another sample
        assertEquals(8, testBoard.getNumberAtIdx(8,0));
        assertEquals(7, testBoard.getNumberAtIdx(8,1));
        assertEquals(9, testBoard.getNumberAtIdx(8,2));
        assertEquals(3, testBoard.getNumberAtIdx(8,3));
        assertEquals(1, testBoard.getNumberAtIdx(8,4));
        assertEquals(2, testBoard.getNumberAtIdx(8,5));
        assertEquals(6, testBoard.getNumberAtIdx(8,6));
        assertEquals(4, testBoard.getNumberAtIdx(8,7));
        assertEquals(5, testBoard.getNumberAtIdx(8,8));

        // some more sample tests at random indexes
        assertEquals(4, testBoard.getNumberAtIdx(5,3));
    }
}
