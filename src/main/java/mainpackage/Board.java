package mainpackage;

import java.util.Arrays;
import java.util.HashSet;

public class Board {

    private int[][] board_scheme = new int [SIZE][SIZE];
    public static final int SIZE = 9; // size of square / arrays

    public static Board getInstance() { return board; }

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

    public void setValueInBrett(int column, int row, int value) {
        this.board_scheme[column][row] = value;
    }

    /**
     * Set ganzes Brett auf einmal über 2 dimensionales Array mit allen Werten (zeilenweise)
     */
    public void setGanzesBrett(int [][] values) {
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                this.setValueInBrett(i, j, values[i][j]);
            }
        }
    }


    public int getNumberAtIdx(int row, int col){
        return board_scheme[row][col];
    }


    public boolean checkWinning() {

        boolean rt = true;

        //checks if any row has duplicates

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {
                set.add(board_scheme[i][j]);
            }
            if (set.size() != SIZE) {
                System.out.println("Duplicates found in a row");
                rt = false;
            } else if (set.size() == SIZE) {
                System.out.println("Set has size of 9 found in a row");
            }
            set.clear();

        }

        //checks if any column has duplicates

        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {
                set.add(board_scheme[j][i]);
            }
            if (set.size() != SIZE) {
                System.out.println("Duplicates found in a column");
                rt = false;
            } else if (set.size() == SIZE) {
                System.out.println("Set has size of 9 found in a column");
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
                    System.out.println("Quadrant doesnt contain all numbers");
                    rt = false;
                    System.out.println(set.size());
                }
                else if(set.size() == 9){
                    System.out.println("Quadrant contains all numbers");
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
                    System.out.println("Quadrant doesnt contain all numbers");
                    rt = false;
                    System.out.println(set.size());
                }
                else if(set.size() == 9){
                    System.out.println("Quadrant contains all numbers");
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
                    System.out.println("Quadrant doesnt contain all numbers");
                    rt = false;
                    System.out.println(set.size());
                }
                else if(set.size() == 9){
                    System.out.println("Quadrant contains all numbers");
                }
                set.clear();
            }
        }

        System.out.println("Finished checking winning");
        return rt;
    }
/*
    // return true if any value occurs more than once
    private boolean checkForDuplicates(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int cur = arr[i];

            for(int j = 0; j < arr.length; j++){
                if(j != i){
                    if(cur == arr[j]) return false;
                }
            }
        }
        return true;
    }*/
}