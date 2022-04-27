package mainpackage;

import java.util.Arrays;
import java.util.HashSet;

public class Board {


    private int[][] brett= new int [size][size];
    public static final int size = 9; // size of square / arrays

    public int[][] getBrett() {
        return brett;
    }

    private Board() {
    }

    private static Board board = new Board();

    public static Board getInstance() {
        return board;
    }


    @Override
    public String toString(){
        StringBuffer buf = new StringBuffer();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                buf.append("|");
                buf.append(brett[i][j]);
            }
            buf.append('\n');
        }
        return buf.toString();
    }

    /*
     *
     * @param row index
     * @param column index
     * @param value to be set at given position
     */
    public void setBrett(int row,int column, int value) {
        this.brett[row][column] = value;
    }

    /*
     *
     * @param row index
     * @param col index
     * @return value at given position on the board
     */
    public int getNumberAtIdx(int row, int col){
        return brett[row][col];
    }


    public boolean checkWinning() {

        boolean rt = true;

        //checks if any row has duplicates
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                set.add(brett[i][j]);
            }
            if (set.size() != size) {
                System.out.println("Duplicates found in a row");
                rt = false;
            } else if (set.size() == size) {
                System.out.println("Set has size of 9 found in a row");
            }
            set.clear();

        }

        //checks if any column has duplicates
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                set.add(brett[j][i]);
            }
            if (set.size() != size) {
                System.out.println("Duplicates found in a column");
                rt = false;
            } else if (set.size() == size) {
                System.out.println("Set has size of 9 found in a column");
            }
            set.clear();

        }



        //checks if any 3x3 square has duplicates in the first column

        set.clear();
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < 3; j++) {
                set.add(brett[i][j]);
            }
            if(i == 2 || i == 5 || i == 8){
                if(set.size() != 9){
                    System.out.println("Quadrant doesnt contain all numbers");
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
        for (int i = 0; i < size; i++) {

            for (int j = 3; j < 6; j++) {
                set.add(brett[i][j]);
            }
            if(i == 2 || i == 5 || i == 8){
                if(set.size() != 9){
                    System.out.println("Quadrant doesnt contain all numbers");
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
        for (int i = 0; i < size; i++) {

            for (int j = 6; j < 9; j++) {
                set.add(brett[i][j]);
            }
            if(i == 2 || i == 5 || i == 8){
                if(set.size() != 9){
                    System.out.println("Quadrant doesnt contain all numbers");
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
     *
     * @param arr Array
     * @return true if any value occurs more than once
     */
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
    }
}