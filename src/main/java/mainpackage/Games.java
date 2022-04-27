package mainpackage;

public class Games {

    static Board board = Board.getInstance();

    public Games() {

        // BSP Brett
        board.setBrett(0, 0, 3);
        board.setBrett(0, 1, 0);
        board.setBrett(0, 2, 0);
        board.setBrett(0, 3, 9);
        board.setBrett(0, 4, 0);
        board.setBrett(0, 5, 0);
        board.setBrett(0, 6, 0);
        board.setBrett(0, 7, 0);
        board.setBrett(0, 8, 0);

        board.setBrett(0, 0, 3);
        board.setBrett(1, 0, 0);
        board.setBrett(2, 0, 0);
        board.setBrett(3, 0, 6);
        board.setBrett(4, 0, 0);
        board.setBrett(5, 0, 0);
        board.setBrett(6, 0, 0);
        board.setBrett(7, 0, 9);
        board.setBrett(8, 0, 0);

        board.setBrett(1, 0, 0);
        board.setBrett(1, 1, 4);
        board.setBrett(1, 2, 0);
        board.setBrett(1, 3, 0);
        board.setBrett(1, 4, 2);
        board.setBrett(1, 5, 0);
        board.setBrett(1, 6, 0);
        board.setBrett(1, 7, 5);
        board.setBrett(1, 8, 0);

        board.setBrett(0, 1, 0);
        board.setBrett(1, 1, 4);
        board.setBrett(2, 1, 8);
        board.setBrett(3, 1, 0);
        board.setBrett(4, 1, 5);
        board.setBrett(5, 1, 0);
        board.setBrett(6, 1, 2);
        board.setBrett(7, 1, 9);
        board.setBrett(8, 1, 3);

        board.setBrett(2, 0, 0);
        board.setBrett(2, 1, 8);
        board.setBrett(2, 2, 0);
        board.setBrett(2, 3, 0);
        board.setBrett(2, 4, 7);
        board.setBrett(2, 5, 0);
        board.setBrett(2, 6, 1);
        board.setBrett(2, 7, 6);
        board.setBrett(2, 8, 0);

        board.setBrett(0, 2, 0);
        board.setBrett(1, 2, 0);
        board.setBrett(2, 2, 0);
        board.setBrett(3, 2, 0);
        board.setBrett(4, 2, 0);
        board.setBrett(5, 2, 1);
        board.setBrett(6, 2, 7);
        board.setBrett(7, 2, 0);
        board.setBrett(8, 2, 0);

        board.setBrett(3, 0, 9);
        board.setBrett(3, 1, 0);
        board.setBrett(3, 2, 0);
        board.setBrett(3, 3, 3);
        board.setBrett(3, 4, 0);
        board.setBrett(3, 5, 4);
        board.setBrett(3, 6, 7);
        board.setBrett(3, 7, 0);
        board.setBrett(3, 8, 0);

        board.setBrett(0, 3, 6);
        board.setBrett(1, 3, 0);
        board.setBrett(2, 3, 0);
        board.setBrett(3, 3, 3);
        board.setBrett(4, 3, 0);
        board.setBrett(5, 3, 9);
        board.setBrett(6, 3, 0);
        board.setBrett(7, 3, 0);
        board.setBrett(8, 3, 0);

        board.setBrett(4, 0, 0);
        board.setBrett(4, 1, 5);
        board.setBrett(4, 2, 0);
        board.setBrett(4, 3, 0);
        board.setBrett(4, 4, 8);
        board.setBrett(4, 5, 0);
        board.setBrett(4, 6, 0);
        board.setBrett(4, 7, 2);
        board.setBrett(4, 8, 0);

        board.setBrett(0, 4, 0);
        board.setBrett(1, 4, 2);
        board.setBrett(2, 4, 7);
        board.setBrett(3, 4, 0);
        board.setBrett(4, 4, 8);
        board.setBrett(5, 4, 0);
        board.setBrett(6, 4, 3);
        board.setBrett(7, 4, 6);
        board.setBrett(8, 4, 0);

        board.setBrett(5, 0, 0);
        board.setBrett(5, 1, 0);
        board.setBrett(5, 2, 1);
        board.setBrett(5, 3, 9);
        board.setBrett(5, 4, 0);
        board.setBrett(5, 5, 0);
        board.setBrett(5, 6, 0);
        board.setBrett(5, 7, 0);
        board.setBrett(5, 8, 6);

        board.setBrett(0, 5, 0);
        board.setBrett(1, 5, 0);
        board.setBrett(2, 5, 0);
        board.setBrett(3, 5, 4);
        board.setBrett(4, 5, 0);
        board.setBrett(5, 5, 0);
        board.setBrett(6, 5, 0);
        board.setBrett(7, 5, 0);
        board.setBrett(8, 5, 5);

        board.setBrett(6, 0, 0);
        board.setBrett(6, 1, 2);
        board.setBrett(6, 2, 7);
        board.setBrett(6, 3, 0);
        board.setBrett(6, 4, 3);
        board.setBrett(6, 5, 0);
        board.setBrett(6, 6, 0);
        board.setBrett(6, 7, 4);
        board.setBrett(6, 8, 0);

        board.setBrett(0, 6, 0);
        board.setBrett(1, 6, 0);
        board.setBrett(2, 6, 1);
        board.setBrett(3, 6, 7);
        board.setBrett(4, 6, 0);
        board.setBrett(5, 6, 0);
        board.setBrett(6, 6, 0);
        board.setBrett(7, 6, 0);
        board.setBrett(8, 6, 0);

        board.setBrett(7, 0, 0);
        board.setBrett(7, 1, 9);
        board.setBrett(7, 2, 0);
        board.setBrett(7, 3, 0);
        board.setBrett(7, 4, 6);
        board.setBrett(7, 5, 0);
        board.setBrett(7, 6, 0);
        board.setBrett(7, 7, 1);
        board.setBrett(7, 8, 0);

        board.setBrett(0, 7, 9);
        board.setBrett(1, 7, 5);
        board.setBrett(2, 7, 6);
        board.setBrett(3, 7, 0);
        board.setBrett(4, 7, 2);
        board.setBrett(5, 7, 0);
        board.setBrett(6, 7, 4);
        board.setBrett(7, 7, 1);
        board.setBrett(8, 7, 0);

        board.setBrett(8, 0, 0);
        board.setBrett(8, 1, 3);
        board.setBrett(8, 2, 0);
        board.setBrett(8, 3, 0);
        board.setBrett(8, 4, 0);
        board.setBrett(8, 5, 5);
        board.setBrett(8, 6, 0);
        board.setBrett(8, 7, 0);
        board.setBrett(8, 8, 8);

        board.setBrett(0, 8, 0);
        board.setBrett(1, 8, 0);
        board.setBrett(2, 8, 0);
        board.setBrett(3, 8, 0);
        board.setBrett(4, 8, 0);
        board.setBrett(5, 8, 6);
        board.setBrett(6, 8, 0);
        board.setBrett(7, 8, 0);
        board.setBrett(8, 8, 8);
    }
}
