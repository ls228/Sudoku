package mainpackage;

public class Games {

    static Board solution_board = Board.getInstance(); // ausgefülltes Brett (Lösung)
    static Board puzzle_board = Board.getInstance(); // teilweise leeres Brett (Rätsel)

    /***
     * Spielbrett wird mit einem zufälligen Schema befüllt
     */
    public Games() {

        // Man könnte z.B. Schwierigkeitsgrade machen je nach Nummer (1-20 leicht, 21-40 mittel, 41-50 schwer)
        int randomNumber = (int) (50 * Math.random());
        System.out.println("Random Number: " + randomNumber);


        switch (randomNumber){
            case 1:
                // Hier jeweils ausgefülltes Sudoku einfügen
                int[][] gameSolutionValues1 = {
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                };
                solution_board.setGanzesBrett(gameSolutionValues1);

                // Hier jeweils UNausgefülltes Sudoku einfügen
                int[][] gamePuzzleValues1 = {
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                };
                puzzle_board.setGanzesBrett(gamePuzzleValues1);

                break;



            case 2:
                int[][] gameSolutionValues2 = {
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                };
                solution_board.setGanzesBrett(gameSolutionValues2);

                int[][] gamePuzzleValues2 = {
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,5,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                };
                puzzle_board.setGanzesBrett(gamePuzzleValues2);

                break;




                /* (Hier insges. 50 cases einfügen für die Spiele, Name jeweils
                 gameSolutionValues1, gamePuzzleValues1, Zahl je nach case-Nummer anpassen!) */



            default:
                System.out.println("(Default case game:)"); // Kommt eigentlich nicht vor außer wenn Programmierfehler

                int[][] gameSolutionValuesX = {
                        {1,1,1,1,1,1,1,1,1},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                };
                solution_board.setGanzesBrett(gameSolutionValuesX);

                int[][] gamePuzzleValuesX = {
                        {0,0,0,0,0,0,0,0,0},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},
                };
                puzzle_board.setGanzesBrett(gamePuzzleValuesX);
        }
    }

    public static Board getSolution_board() {
        return solution_board;
    }

    public static Board getPuzzle_board() {
        return puzzle_board;
    }
}
