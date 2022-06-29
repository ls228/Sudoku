package de.sudoku.game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;

/**
 * Class handling the backend-structure of the sudoku-grid as a 2D-Array
 */
public class Board {

    private static final Logger log = LogManager.getLogger(Board.class);

    public int[][] board_scheme = new int [SIZE][SIZE];
    public static final int SIZE = 9; // size of square / arrays


    public Board getInstance() { return board; }

    private static Board board = new Board();


    @Override
    public String toString(){
        StringBuffer buf = new StringBuffer();
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                buf.append("|");
                buf.append(board_scheme[i][j]);
            }
            buf.append("|\n");
        }
        return buf.toString();
    }

    public boolean checkIfFinished(){
        boolean notDone=true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(getNumberAtIdx(i,j)!=0){
                    notDone=false;
                }else {
                    notDone=true;
                    return notDone;
                }
            }
        }
        return notDone;
    }
    /*
    //Vergleicht 2 Boards
    public boolean equalsBoard(Board b){

        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(this.getNumberAtIdx(i,j) == b.getNumberAtIdx(i,j));
                else return false;
            }
        }
        return true;
    }

     */

    /**
     * Set value at corresponding coordinates/position in Board
     * @param column index of column
     * @param row index of row
     * @param value value to be set at that location in the sudoku grid
     */
    public void setValueInBrett(int column, int row, int value) {
        this.board_scheme[column][row] = value;
    }

    /**
     * Set entire Board at once using a 2D-Array filled with all values (each array is a row in the sudoku)
     */
    public void setCompletedBoard(int [][] values) {
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                this.setValueInBrett(i, j, values[i][j]);
            }
        }
        log.info("New board has been set");
    }

    /**
     * @param row index of row
     * @param col index of column
     * @return value at given index
     */
    public int getNumberAtIdx(int row, int col){
        return board_scheme[row][col];
    }


    /**
     * Checks whether all inserted numbers still agree with the basic sudoku-rules.
     * @return true if no duplicate numbers are found in a row/column/3x3-square, else return false.
     */
    public boolean checkWinning() {

        boolean rt = true;

        //checks if any row has duplicates

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {
                set.add(board_scheme[i][j]);
            }
            if (set.size() != SIZE) {
                log.info("Duplicates found in a row");
                rt = false;
            } else if (set.size() == SIZE) {
                log.info("Set has size of 9 found in a row");
            }
            set.clear();
        }

        //checks if any column has duplicates

        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {
                set.add(board_scheme[j][i]);
            }
            if (set.size() != SIZE) {
                log.info("Duplicates found in a column");
                rt = false;
            } else if (set.size() == SIZE) {
                log.info("Set has size of 9 found in a column");
            }
            set.clear();
        }

        //checks if any 3x3 square has duplicates in the first column

        set.clear();
        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < 3; j++) {
                set.add(board_scheme[i][j]);
            }
            if(i == 2 || i == 5 || i == 8){
                if(set.size() != 9){
                    log.info("Quadrant doesnt contain all numbers");
                    rt = false;
                    System.out.println(set.size());
                }
                else if(set.size() == 9){
                    log.info("Quadrant contains all numbers");
                }
                set.clear();
            }
        }

        //checks if any 3x3 square has duplicates in the second column

        set.clear();
        for (int i = 0; i < SIZE; i++) {

            for (int j = 3; j < 6; j++) {
                set.add(board_scheme[i][j]);
            }
            if(i == 2 || i == 5 || i == 8){
                if(set.size() != 9){
                    log.info("Quadrant does not contain all numbers");
                    rt = false;
                    log.info(set.size()+" size");
                }
                else if(set.size() == 9){
                    log.info("Quadrant contains all numbers");
                }
                set.clear();
            }
        }

        //checks if any 3x3 square has duplicates in the third column

        set.clear();
        for (int i = 0; i < SIZE; i++) {

            for (int j = 6; j < 9; j++) {
                set.add(board_scheme[i][j]);
            }
            if(i == 2 || i == 5 || i == 8){
                if(set.size() != 9){
                    log.info("Quadrant doesnt contain all numbers");
                    rt = false;
                    log.info(set.size()+" size");
                }
                else if(set.size() == 9){
                    log.info("Quadrant contains all numbers");
                }
                set.clear();
            }
        }

        log.info("Finished checking winning");
        return rt;
    }
}