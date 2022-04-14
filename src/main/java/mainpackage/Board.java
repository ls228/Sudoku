package mainpackage;

public class Board {

    private final int[][] board;
    public static final int size = 9; // size of square / arrays

    public Board(int[][] board) {
        this.board = board;
    }



    public void print(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print("|");
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
