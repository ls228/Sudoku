package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Games {

    static Board solution_board = new Board(); // ausgefülltes Brett (Lösung)
    static Board puzzle_board = new Board(); // teilweise leeres Brett (Rätsel)

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
                System.out.println("(Default case game:)");

                int[][] gameSolutionValuesX = {
                        {2,8,9,6,4,3,5,1,7},
                        {5,7,4,9,2,1,8,6,3},
                        {1,3,6,7,8,5,2,9,4},
                        {8,6,1,5,3,9,4,7,2},
                        {4,5,2,8,1,7,6,3,9},
                        {3,9,7,2,6,4,1,8,5},
                        {6,4,8,3,9,2,7,5,1},
                        {9,2,5,1,7,8,3,4,6},
                        {7,1,3,4,5,6,9,2,8},
                };
                solution_board.setGanzesBrett(gameSolutionValuesX);

                int[][] gamePuzzleValuesX = {
                        {2,8,0,0,0,0,0,1,7},
                        {0,0,0,9,0,1,0,0,0},
                        {0,0,6,0,8,0,0,0,4},
                        {0,6,0,5,0,0,0,7,0},
                        {0,0,0,0,1,0,0,0,9},
                        {0,0,7,0,0,0,0,8,0},
                        {0,0,0,3,0,0,0,5,0},
                        {0,0,5,0,0,0,3,0,0},
                        {0,1,0,4,0,0,9,0,8},
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


    public static List<String> read() {

        List<String> entries = new ArrayList<>();
        try {
            BufferedReader newReader = new BufferedReader(new FileReader("games.txt"));
            String line;
            while ((line = newReader.readLine()) != null) {
                entries.add(line);
            }
            newReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

}
