package mainpackage;

import java.util.Arrays;

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

    /***
     *
     * @param row index
     * @param column index
     * @param value to be set at given position
     */
    public void setBrett(int row,int column, int value) {
        this.brett[row][column] = value;
    }

    /***
     *
     * @param row index
     * @param col index
     * @return value at given position on the board
     */
    public int getNumberAtIdx(int row, int col){
        return brett[row][col];
    }


    public void checkWinning(){

        // Zeilen
        for(int i = 0; i < size; i++) {

            int[] currentRow = new int[size];
            int top = 0;

            for (int j = 0; j < size; j++) {
                currentRow[top] = getNumberAtIdx(i, top);
                top++;
            }
            // System.out.println("Duplicate found: " + Arrays.toString(currentRow));
            System.out.println(checkForDuplicates(currentRow));
        }

        // Spalten


        // boolean foundDuplicate = checkForDuplicates(currentCol);


        // Blöcke
    }


    /***
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
