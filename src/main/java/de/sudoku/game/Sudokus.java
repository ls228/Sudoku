package de.sudoku.game;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sudokus {

    private static final Logger log = LogManager.getLogger(Sudokus.class);

    private static Board bSolutionBoard = new Board(); // solved board (solution)
    private static Board bPuzzleBoard = new Board(); // game that has to be solved (quest)

    /**
     * This class holds the sudoku puzzles, from which one will be randomly chosen once the game is starting.
     * The Board will be filled with the numbers from that random Sudoku.s
     * Depending on chosen level, the generated sudoku will be chosen from the corresponding of the three groups
     * (Level 1 - easy to solve, Level 2 - medium, Level 3 - difficult to solve).
     *
     * @param currentlevel
     */
    public void allSudokus(int currentlevel, int randomNumber) {

        log.info("Random Number: " + randomNumber);
        log.info("Level is set to Level " + currentlevel);

        //if-function with current level chooses different difficulty
        if (currentlevel == 1) {
            switch (randomNumber) {
                //easy:
                case 1:

                    int[][] gameSolutionValues1 = {
                            {8, 3, 1, 6, 9, 5, 7, 4, 2},
                            {7, 5, 4, 8, 1, 2, 6, 9, 3},
                            {9, 2, 6, 3, 7, 4, 8, 5, 1},
                            {2, 6, 7, 9, 5, 3, 4, 1, 8},
                            {5, 4, 3, 7, 8, 1, 2, 6, 9},
                            {1, 9, 8, 2, 4, 6, 3, 7, 5},
                            {6, 7, 9, 5, 3, 8, 1, 2, 4},
                            {4, 8, 2, 1, 6, 9, 5, 3, 7},
                            {3, 1, 5, 4, 2, 7, 9, 8, 6},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues1);


                    int[][] gamePuzzleValues1 = {
                            {8, 3, 1, 0, 0, 0, 7, 4, 2},
                            {7, 0, 4, 0, 0, 0, 6, 0, 3},
                            {0, 0, 6, 3, 0, 4, 8, 0, 0},
                            {2, 0, 0, 9, 0, 3, 0, 0, 8},
                            {5, 0, 3, 0, 0, 0, 2, 0, 9},
                            {1, 0, 0, 2, 0, 6, 0, 0, 5},
                            {0, 0, 9, 5, 0, 8, 1, 0, 0},
                            {4, 0, 2, 0, 0, 0, 5, 0, 7},
                            {3, 1, 5, 0, 0, 0, 9, 8, 6},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues1);


                    break;


                case 2:
                    int[][] gameSolutionValues2 = {
                            {6, 4, 1, 5, 3, 2, 8, 9, 7},
                            {9, 8, 2, 7, 1, 4, 3, 6, 5},
                            {7, 3, 5, 8, 9, 6, 1, 4, 2},
                            {8, 6, 3, 1, 4, 5, 7, 2, 9},
                            {4, 1, 7, 3, 2, 9, 5, 8, 6},
                            {5, 2, 9, 6, 7, 8, 4, 1, 3},
                            {3, 7, 4, 2, 6, 1, 9, 5, 8},
                            {1, 5, 6, 9, 8, 3, 2, 7, 4},
                            {2, 9, 8, 4, 5, 7, 6, 3, 1},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues2);


                    int[][] gamePuzzleValues2 = {
                            {0, 0, 0, 5, 3, 2, 0, 0, 0},
                            {9, 0, 2, 0, 0, 0, 3, 0, 5},
                            {0, 3, 0, 8, 0, 6, 0, 4, 0},
                            {8, 6, 3, 1, 0, 5, 7, 2, 9},
                            {0, 0, 0, 3, 0, 9, 0, 0, 0},
                            {5, 2, 9, 6, 0, 8, 4, 1, 3},
                            {0, 7, 0, 2, 0, 1, 0, 5, 0},
                            {1, 0, 6, 0, 0, 0, 2, 0, 4},
                            {0, 0, 0, 4, 5, 7, 0, 0, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues2);

                    break;


                case 3:
                    int[][] gameSolutionValues3 = {
                            {3, 7, 4, 5, 1, 6, 9, 8, 2},
                            {1, 5, 8, 9, 3, 2, 7, 4, 6},
                            {9, 2, 6, 7, 4, 8, 3, 5, 1},
                            {4, 3, 7, 1, 2, 9, 5, 6, 8},
                            {2, 1, 9, 6, 8, 5, 4, 7, 3},
                            {6, 8, 5, 4, 7, 3, 1, 2, 9},
                            {8, 4, 1, 3, 6, 7, 2, 9, 5},
                            {5, 6, 3, 2, 9, 4, 8, 1, 7},
                            {7, 9, 2, 8, 5, 1, 6, 3, 4},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues3);


                    int[][] gamePuzzleValues3 = {
                            {3, 7, 0, 0, 0, 0, 0, 8, 2},
                            {1, 0, 8, 0, 0, 0, 7, 0, 6},
                            {0, 2, 6, 7, 0, 8, 3, 5, 0},
                            {0, 0, 7, 1, 0, 9, 5, 0, 0},
                            {0, 0, 9, 6, 0, 5, 4, 0, 0},
                            {0, 0, 5, 4, 0, 3, 1, 0, 0},
                            {0, 4, 1, 3, 0, 7, 2, 9, 0},
                            {5, 0, 3, 0, 0, 0, 8, 0, 7},
                            {7, 9, 0, 0, 0, 0, 0, 3, 4},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues3);

                    break;


                case 4:
                    int[][] gameSolutionValues4 = {
                            {2, 6, 4, 7, 5, 9, 1, 8, 3},
                            {5, 8, 7, 4, 3, 1, 2, 9, 6},
                            {9, 1, 3, 2, 6, 8, 7, 4, 5},
                            {3, 4, 6, 8, 1, 7, 5, 2, 9},
                            {8, 2, 5, 3, 9, 6, 4, 1, 7},
                            {1, 7, 9, 5, 2, 4, 6, 3, 8},
                            {7, 5, 8, 9, 4, 2, 3, 6, 1},
                            {4, 9, 1, 6, 7, 3, 8, 5, 2},
                            {6, 3, 2, 1, 8, 5, 9, 7, 4},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues4);


                    int[][] gamePuzzleValues4 = {
                            {0, 6, 4, 0, 0, 0, 1, 8, 0},
                            {0, 0, 0, 4, 0, 1, 0, 0, 0},
                            {9, 0, 3, 2, 0, 8, 7, 0, 5},
                            {0, 0, 6, 8, 1, 7, 5, 0, 0},
                            {8, 0, 5, 3, 0, 6, 4, 0, 7},
                            {0, 0, 9, 5, 2, 4, 6, 0, 0},
                            {7, 0, 8, 9, 0, 2, 3, 0, 1},
                            {0, 0, 0, 6, 0, 3, 0, 0, 0},
                            {0, 3, 2, 0, 0, 0, 9, 7, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues4);

                    break;


                case 5:
                    int[][] gameSolutionValues5 = {
                            {9, 3, 7, 1, 6, 2, 4, 8, 5},
                            {8, 2, 5, 4, 9, 7, 3, 1, 6},
                            {1, 4, 6, 3, 5, 8, 9, 7, 2},
                            {3, 7, 1, 6, 2, 4, 5, 9, 8},
                            {5, 8, 2, 9, 3, 1, 7, 6, 4},
                            {4, 6, 9, 8, 7, 5, 2, 3, 1},
                            {6, 5, 8, 7, 4, 9, 1, 2, 3},
                            {9, 2, 3, 5, 1, 6, 8, 4, 7},
                            {7, 1, 4, 2, 8, 3, 6, 5, 9},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues5);


                    int[][] gamePuzzleValues5 = {
                            {9, 0, 0, 0, 0, 0, 0, 0, 5},
                            {0, 0, 5, 4, 9, 7, 3, 0, 0},
                            {0, 4, 6, 3, 5, 8, 9, 7, 0},
                            {0, 0, 1, 6, 0, 4, 5, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 9, 8, 0, 5, 2, 0, 0},
                            {0, 5, 8, 7, 4, 9, 1, 2, 0},
                            {0, 0, 3, 5, 1, 6, 8, 0, 0},
                            {7, 0, 0, 0, 0, 0, 0, 0, 9},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues5);

                    break;


                case 6:
                    int[][] gameSolutionValues6 = {
                            {4, 5, 2, 8, 9, 3, 7, 1, 6},
                            {6, 3, 7, 5, 4, 1, 8, 9, 2},
                            {1, 8, 9, 6, 2, 7, 5, 4, 3},
                            {8, 2, 6, 1, 5, 9, 3, 7, 4},
                            {5, 9, 1, 3, 7, 4, 6, 2, 8},
                            {7, 4, 3, 2, 8, 6, 1, 5, 9},
                            {2, 7, 5, 9, 3, 8, 4, 6, 1},
                            {3, 6, 4, 7, 1, 2, 9, 8, 5},
                            {9, 1, 8, 4, 6, 5, 2, 3, 7},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues6);


                    int[][] gamePuzzleValues6 = {
                            {4, 0, 2, 0, 0, 0, 7, 0, 6},
                            {6, 3, 0, 5, 0, 1, 0, 9, 2},
                            {1, 0, 0, 0, 2, 0, 0, 0, 3},
                            {0, 2, 0, 0, 5, 0, 0, 7, 0},
                            {0, 9, 1, 0, 0, 0, 6, 2, 0},
                            {0, 4, 0, 0, 8, 0, 0, 5, 0},
                            {2, 0, 0, 0, 3, 0, 0, 0, 1},
                            {3, 6, 0, 7, 0, 2, 0, 8, 5},
                            {9, 0, 8, 0, 0, 0, 2, 0, 7},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues6);

                    break;


                case 7:
                    int[][] gameSolutionValues7 = {
                            {8, 7, 5, 1, 4, 6, 3, 2, 9},
                            {3, 9, 2, 8, 7, 5, 4, 6, 1},
                            {6, 4, 1, 3, 2, 9, 7, 5, 8},
                            {2, 8, 6, 5, 1, 7, 9, 4, 3},
                            {9, 1, 3, 2, 6, 4, 8, 7, 5},
                            {4, 5, 7, 9, 8, 3, 6, 1, 2},
                            {5, 6, 9, 7, 3, 2, 1, 8, 4},
                            {7, 2, 8, 4, 9, 1, 5, 3, 6},
                            {1, 3, 4, 6, 5, 8, 2, 9, 7},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues7);


                    int[][] gamePuzzleValues7 = {
                            {0, 7, 0, 1, 0, 6, 0, 2, 0},
                            {3, 0, 0, 8, 0, 5, 0, 0, 1},
                            {0, 4, 0, 3, 0, 9, 0, 5, 0},
                            {2, 0, 0, 0, 1, 0, 0, 0, 3},
                            {9, 0, 3, 2, 0, 4, 8, 0, 5},
                            {4, 0, 0, 0, 8, 0, 0, 0, 2},
                            {0, 6, 0, 7, 0, 2, 0, 8, 0},
                            {7, 0, 0, 4, 0, 1, 0, 0, 6},
                            {0, 3, 0, 6, 0, 8, 0, 9, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues7);

                    break;


                case 8:
                    int[][] gameSolutionValues8 = {
                            {4, 8, 6, 3, 5, 2, 9, 7, 1},
                            {2, 3, 9, 1, 7, 4, 5, 6, 8},
                            {7, 1, 5, 8, 9, 6, 2, 4, 3},
                            {1, 5, 7, 4, 2, 9, 3, 8, 6},
                            {9, 6, 4, 7, 8, 3, 1, 2, 5},
                            {8, 2, 3, 6, 1, 5, 4, 9, 7},
                            {3, 7, 2, 5, 4, 8, 6, 1, 9},
                            {6, 4, 8, 9, 3, 1, 7, 5, 2},
                            {5, 9, 1, 2, 6, 7, 8, 3, 4},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues8);


                    int[][] gamePuzzleValues8 = {
                            {0, 0, 0, 3, 0, 2, 0, 0, 0},
                            {2, 3, 9, 0, 0, 0, 5, 6, 8},
                            {0, 1, 0, 8, 0, 6, 0, 4, 0},
                            {0, 0, 7, 4, 0, 9, 3, 0, 0},
                            {0, 6, 4, 0, 0, 0, 1, 2, 0},
                            {0, 0, 3, 6, 0, 5, 4, 0, 0},
                            {0, 7, 0, 5, 0, 8, 0, 1, 0},
                            {6, 4, 8, 0, 0, 0, 7, 5, 2},
                            {0, 0, 0, 2, 0, 7, 0, 0, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues8);
                    break;


                case 9:
                    int[][] gameSolutionValues9 = {
                            {6, 8, 2, 3, 5, 4, 1, 9, 7},
                            {5, 1, 3, 9, 7, 6, 4, 8, 2},
                            {7, 9, 4, 2, 8, 1, 3, 6, 5},
                            {2, 7, 8, 4, 6, 9, 5, 1, 3},
                            {3, 6, 9, 1, 2, 5, 7, 4, 8},
                            {4, 5, 1, 7, 3, 8, 9, 2, 6},
                            {9, 3, 6, 5, 4, 2, 8, 7, 1},
                            {1, 2, 7, 8, 9, 3, 6, 5, 4},
                            {8, 4, 5, 6, 1, 7, 2, 3, 9},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues9);

                    int[][] gamePuzzleValues9 = {
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {5, 1, 0, 0, 7, 0, 0, 8, 2},
                            {0, 9, 4, 2, 8, 1, 3, 6, 0},
                            {0, 0, 8, 4, 6, 9, 5, 0, 0},
                            {0, 0, 9, 0, 0, 0, 7, 0, 0},
                            {0, 0, 1, 7, 3, 8, 9, 0, 0},
                            {0, 3, 6, 5, 4, 2, 8, 7, 0},
                            {1, 2, 0, 0, 9, 0, 0, 5, 4},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues9);
                    break;


                case 10:
                    int[][] gameSolutionValues10 = {
                            {8, 4, 2, 7, 5, 6, 9, 3, 1},
                            {7, 3, 9, 4, 1, 8, 2, 5, 6},
                            {5, 1, 6, 9, 2, 3, 7, 4, 8},
                            {4, 5, 1, 2, 6, 7, 3, 8, 9},
                            {6, 2, 3, 5, 8, 9, 1, 7, 4},
                            {9, 8, 7, 3, 4, 1, 6, 2, 5},
                            {2, 9, 4, 6, 3, 5, 8, 1, 7},
                            {1, 6, 5, 8, 7, 2, 4, 9, 3},
                            {3, 7, 8, 1, 9, 4, 5, 6, 2},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues10);


                    int[][] gamePuzzleValues10 = {
                            {8, 0, 0, 7, 0, 6, 0, 0, 1},
                            {0, 3, 9, 0, 1, 0, 2, 5, 0},
                            {0, 0, 6, 0, 0, 0, 7, 0, 0},
                            {4, 5, 0, 2, 0, 7, 0, 8, 9},
                            {0, 0, 3, 0, 0, 0, 1, 0, 0},
                            {9, 8, 0, 3, 0, 1, 0, 2, 5},
                            {0, 0, 4, 0, 0, 0, 8, 0, 0},
                            {0, 6, 5, 0, 7, 0, 4, 9, 0},
                            {3, 0, 0, 1, 0, 4, 0, 0, 2},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues10);

                    break;

                default:
                    log.info("Default case game was selected (not intended to ever happen).");

                    int[][] gameSolutionValuesX = {
                            {2, 8, 9, 6, 4, 3, 5, 1, 7},
                            {5, 7, 4, 9, 2, 1, 8, 6, 3},
                            {1, 3, 6, 7, 8, 5, 2, 9, 4},
                            {8, 6, 1, 5, 3, 9, 4, 7, 2},
                            {4, 5, 2, 8, 1, 7, 6, 3, 9},
                            {3, 9, 7, 2, 6, 4, 1, 8, 5},
                            {6, 4, 8, 3, 9, 2, 7, 5, 1},
                            {9, 2, 5, 1, 7, 8, 3, 4, 6},
                            {7, 1, 3, 4, 5, 6, 9, 2, 8},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValuesX);

                    int[][] gamePuzzleValuesX = {
                            {2, 8, 0, 0, 0, 0, 0, 1, 7},
                            {0, 0, 0, 9, 0, 1, 0, 0, 0},
                            {0, 0, 6, 0, 8, 0, 0, 0, 4},
                            {0, 6, 0, 5, 0, 0, 0, 7, 0},
                            {0, 0, 0, 0, 1, 0, 0, 0, 9},
                            {0, 0, 7, 0, 0, 0, 0, 8, 0},
                            {0, 0, 0, 3, 0, 0, 0, 5, 0},
                            {0, 0, 5, 0, 0, 0, 3, 0, 0},
                            {0, 1, 0, 4, 0, 0, 9, 0, 8},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValuesX);
                    break;
            }
        } else if (currentlevel == 2) {
            switch (randomNumber) {

                //medium:
                case 1:
                    int[][] gameSolutionValues11 = {
                            {1, 9, 4, 3, 2, 7, 8, 6, 5},
                            {7, 2, 5, 8, 1, 6, 4, 3, 9},
                            {6, 3, 8, 4, 9, 5, 2, 1, 7},
                            {4, 5, 6, 9, 7, 1, 3, 2, 8},
                            {8, 1, 9, 5, 3, 2, 6, 7, 4},
                            {3, 7, 2, 6, 4, 8, 5, 9, 1},
                            {9, 6, 1, 2, 8, 4, 7, 5, 3},
                            {2, 4, 3, 7, 5, 9, 1, 8, 6},
                            {5, 8, 7, 1, 6, 3, 9, 4, 2},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues11);

                    int[][] gamePuzzleValues11 = {
                            {0, 9, 0, 0, 0, 0, 0, 6, 0},
                            {0, 0, 5, 8, 1, 6, 4, 0, 0},
                            {6, 0, 8, 4, 0, 5, 2, 0, 7},
                            {4, 5, 0, 0, 0, 0, 0, 2, 8},
                            {0, 0, 9, 0, 0, 0, 6, 0, 0},
                            {3, 7, 0, 0, 0, 0, 0, 9, 1},
                            {9, 0, 1, 2, 0, 4, 7, 0, 3},
                            {0, 0, 3, 7, 5, 9, 1, 0, 0},
                            {0, 8, 0, 0, 0, 0, 0, 4, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues11);
                    break;


                case 2:
                    int[][] gameSolutionValues12 = {
                            {1, 4, 9, 3, 5, 7, 8, 6, 2},
                            {3, 2, 7, 1, 6, 8, 5, 9, 4},
                            {8, 5, 6, 4, 2, 9, 1, 7, 3},
                            {5, 1, 8, 6, 3, 2, 7, 4, 9},
                            {9, 7, 2, 8, 4, 1, 3, 5, 6},
                            {4, 6, 3, 7, 9, 5, 2, 1, 8},
                            {7, 9, 1, 2, 8, 6, 4, 3, 5},
                            {2, 3, 5, 9, 1, 4, 6, 8, 7},
                            {6, 8, 4, 5, 7, 3, 9, 2, 1},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues12);

                    int[][] gamePuzzleValues12 = {
                            {0, 4, 0, 0, 5, 0, 0, 6, 0},
                            {0, 2, 0, 1, 0, 8, 0, 9, 0},
                            {8, 0, 0, 0, 2, 0, 0, 0, 3},
                            {0, 0, 8, 6, 3, 2, 7, 0, 0},
                            {0, 0, 2, 0, 0, 0, 3, 0, 0},
                            {0, 0, 3, 7, 9, 5, 2, 0, 0},
                            {7, 0, 0, 0, 8, 0, 0, 0, 5},
                            {0, 3, 0, 9, 0, 4, 0, 8, 0},
                            {0, 8, 0, 0, 7, 0, 0, 2, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues12);

                    break;


                case 3:
                    int[][] gameSolutionValues13 = {
                            {8, 9, 7, 1, 4, 3, 2, 6, 5},
                            {4, 3, 1, 6, 2, 5, 9, 7, 8},
                            {5, 6, 2, 9, 7, 8, 1, 3, 4},
                            {7, 1, 4, 8, 6, 9, 5, 2, 3},
                            {6, 5, 3, 2, 1, 7, 4, 8, 9},
                            {2, 8, 9, 5, 3, 4, 7, 1, 6},
                            {3, 4, 8, 7, 5, 1, 6, 9, 2},
                            {1, 2, 5, 3, 9, 6, 8, 4, 7},
                            {9, 7, 6, 4, 8, 2, 3, 5, 1},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues13);

                    int[][] gamePuzzleValues13 = {
                            {0, 0, 7, 1, 0, 3, 2, 0, 0},
                            {4, 0, 0, 0, 0, 0, 0, 0, 8},
                            {5, 0, 2, 0, 0, 0, 1, 0, 4},
                            {7, 0, 0, 8, 0, 9, 0, 0, 3},
                            {6, 5, 0, 0, 0, 0, 0, 8, 9},
                            {2, 0, 0, 5, 0, 4, 0, 0, 6},
                            {3, 0, 8, 0, 0, 0, 6, 0, 2},
                            {1, 0, 0, 0, 0, 0, 0, 0, 7},
                            {0, 0, 6, 4, 0, 2, 3, 0, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues13);

                    break;


                case 4:
                    int[][] gameSolutionValues14 = {
                            {3, 5, 6, 8, 7, 1, 9, 4, 2},
                            {1, 8, 2, 5, 9, 4, 3, 6, 7},
                            {9, 7, 4, 2, 3, 6, 5, 8, 1},
                            {8, 3, 5, 9, 1, 2, 6, 7, 4},
                            {4, 1, 9, 7, 6, 8, 2, 5, 3},
                            {2, 6, 7, 4, 5, 3, 8, 1, 9},
                            {6, 9, 8, 1, 2, 7, 4, 3, 5},
                            {5, 4, 1, 3, 8, 9, 7, 2, 6},
                            {7, 2, 3, 6, 4, 5, 1, 9, 8},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues14);

                    int[][] gamePuzzleValues14 = {
                            {0, 0, 0, 8, 0, 1, 0, 0, 0},
                            {1, 8, 0, 0, 0, 0, 0, 6, 7},
                            {9, 0, 0, 2, 3, 6, 0, 0, 1},
                            {8, 0, 5, 0, 0, 0, 6, 0, 4},
                            {0, 1, 0, 0, 0, 0, 0, 5, 0},
                            {2, 0, 7, 0, 0, 0, 8, 0, 9},
                            {6, 0, 0, 1, 2, 7, 0, 0, 5},
                            {5, 4, 0, 0, 0, 0, 0, 2, 6},
                            {0, 0, 0, 6, 0, 5, 0, 0, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues14);

                    break;


                case 5:
                    int[][] gameSolutionValues15 = {
                            {6, 8, 3, 4, 7, 1, 9, 5, 2},
                            {2, 7, 9, 5, 8, 6, 4, 3, 1},
                            {4, 5, 1, 2, 3, 9, 6, 7, 8},
                            {3, 4, 2, 6, 5, 7, 1, 8, 9},
                            {9, 1, 5, 3, 2, 8, 7, 4, 6},
                            {7, 6, 8, 1, 9, 4, 5, 2, 3},
                            {1, 2, 6, 7, 4, 3, 8, 9, 5},
                            {5, 9, 7, 8, 6, 2, 3, 1, 4},
                            {8, 3, 4, 9, 1, 5, 2, 6, 7},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues15);

                    int[][] gamePuzzleValues15 = {
                            {6, 0, 3, 0, 0, 0, 9, 0, 2},
                            {0, 7, 0, 0, 8, 0, 0, 3, 0},
                            {0, 0, 0, 2, 0, 9, 0, 0, 0},
                            {0, 4, 2, 6, 0, 7, 1, 8, 0},
                            {0, 1, 0, 0, 0, 0, 0, 4, 0},
                            {0, 6, 8, 1, 0, 4, 5, 2, 0},
                            {0, 0, 0, 7, 0, 3, 0, 0, 0},
                            {0, 9, 0, 0, 6, 0, 0, 1, 0},
                            {8, 0, 4, 0, 0, 0, 2, 0, 7},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues15);

                    break;


                case 6:
                    int[][] gameSolutionValues16 = {
                            {8, 5, 6, 9, 3, 4, 1, 2, 7},
                            {3, 2, 9, 5, 1, 7, 8, 4, 6},
                            {4, 1, 7, 8, 6, 2, 3, 9, 5},
                            {2, 6, 4, 3, 7, 8, 9, 5, 1},
                            {1, 9, 3, 6, 2, 5, 4, 7, 8},
                            {5, 7, 8, 4, 9, 1, 6, 3, 2},
                            {9, 3, 5, 7, 8, 6, 2, 1, 4},
                            {7, 8, 1, 2, 4, 9, 5, 6, 3},
                            {6, 4, 2, 1, 5, 3, 7, 8, 9},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues16);

                    int[][] gamePuzzleValues16 = {
                            {0, 5, 0, 0, 0, 0, 0, 2, 0},
                            {0, 2, 9, 5, 0, 7, 8, 4, 0},
                            {4, 0, 0, 0, 0, 0, 0, 0, 5},
                            {0, 0, 4, 3, 7, 8, 9, 0, 0},
                            {0, 0, 0, 6, 0, 5, 0, 0, 0},
                            {0, 0, 8, 4, 9, 1, 6, 0, 0},
                            {9, 0, 0, 0, 0, 0, 0, 0, 4},
                            {0, 8, 1, 2, 0, 9, 5, 6, 0},
                            {0, 4, 0, 0, 0, 0, 0, 8, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues16);

                    break;


                case 7:
                    int[][] gameSolutionValues17 = {
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
                    bSolutionBoard.setCompletedBoard(gameSolutionValues17);

                    int[][] gamePuzzleValues17 = {
                            {3, 0, 7, 2, 0, 8, 9, 0, 6},
                            {9, 0, 0, 0, 0, 0, 0, 0, 2},
                            {0, 0, 8, 1, 9, 7, 5, 0, 0},
                            {0, 0, 0, 8, 0, 6, 0, 0, 0},
                            {0, 0, 6, 0, 0, 0, 4, 0, 0},
                            {0, 0, 0, 4, 0, 1, 0, 0, 0},
                            {0, 0, 1, 9, 7, 4, 3, 0, 0},
                            {2, 0, 0, 0, 0, 0, 0, 0, 7},
                            {8, 0, 9, 3, 0, 2, 6, 0, 5},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues17);

                    break;


                case 8:
                    int[][] gameSolutionValues18 = {
                            {1, 4, 3, 6, 9, 7, 5, 2, 8},
                            {2, 6, 9, 8, 4, 5, 1, 7, 3},
                            {8, 7, 5, 3, 1, 2, 9, 6, 4},
                            {5, 3, 6, 7, 2, 9, 8, 4, 1},
                            {9, 2, 4, 1, 8, 3, 7, 5, 6},
                            {7, 1, 8, 5, 6, 4, 2, 3, 9},
                            {4, 9, 7, 2, 3, 1, 6, 8, 5},
                            {3, 8, 2, 9, 5, 6, 4, 1, 7},
                            {6, 5, 1, 4, 7, 8, 3, 9, 2},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues18);


                    int[][] gamePuzzleValues18 = {
                            {0, 0, 3, 6, 0, 7, 5, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {8, 7, 5, 0, 1, 0, 9, 6, 4},
                            {5, 0, 0, 0, 2, 0, 0, 0, 1},
                            {0, 0, 4, 1, 0, 3, 7, 0, 0},
                            {7, 0, 0, 0, 6, 0, 0, 0, 9},
                            {4, 9, 7, 0, 3, 0, 6, 8, 5},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 1, 4, 0, 8, 3, 0, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues18);

                    break;


                case 9:
                    int[][] gameSolutionValues19 = {
                            {8, 5, 9, 4, 1, 2, 6, 7, 3},
                            {1, 2, 3, 6, 5, 7, 9, 8, 4},
                            {4, 7, 6, 9, 8, 3, 2, 5, 1},
                            {7, 9, 1, 5, 6, 8, 4, 3, 2},
                            {3, 6, 4, 7, 2, 9, 5, 1, 8},
                            {5, 8, 2, 3, 4, 1, 7, 6, 9},
                            {9, 3, 5, 1, 7, 4, 8, 2, 6},
                            {2, 4, 7, 8, 3, 6, 1, 9, 5},
                            {6, 1, 8, 2, 9, 5, 3, 4, 7},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues19);

                    int[][] gamePuzzleValues19 = {
                            {0, 5, 0, 0, 0, 0, 0, 7, 0},
                            {0, 0, 0, 6, 5, 7, 0, 0, 0},
                            {4, 0, 0, 9, 0, 3, 0, 0, 1},
                            {7, 9, 1, 0, 0, 0, 4, 3, 2},
                            {0, 0, 4, 0, 0, 0, 5, 0, 0},
                            {5, 8, 2, 0, 0, 0, 7, 6, 9},
                            {9, 0, 0, 1, 0, 4, 0, 0, 6},
                            {0, 0, 0, 8, 3, 6, 0, 0, 0},
                            {0, 1, 0, 0, 0, 0, 0, 4, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues19);

                    break;


                case 10:
                    int[][] gameSolutionValues20 = {
                            {8, 9, 1, 6, 7, 5, 4, 3, 2},
                            {5, 2, 6, 9, 3, 4, 7, 8, 1},
                            {4, 7, 3, 8, 2, 1, 9, 6, 5},
                            {3, 1, 8, 4, 5, 9, 2, 7, 6},
                            {9, 5, 4, 7, 6, 2, 8, 1, 3},
                            {2, 6, 7, 3, 1, 8, 5, 4, 9},
                            {6, 3, 9, 2, 4, 7, 1, 5, 8},
                            {7, 8, 5, 1, 9, 3, 6, 2, 4},
                            {1, 4, 2, 5, 8, 6, 3, 9, 7},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues20);

                    int[][] gamePuzzleValues20 = {
                            {0, 9, 0, 6, 7, 5, 0, 3, 0},
                            {0, 2, 6, 9, 3, 4, 7, 8, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {3, 0, 0, 0, 5, 0, 0, 0, 6},
                            {0, 0, 0, 7, 0, 2, 0, 0, 0},
                            {2, 0, 0, 0, 1, 0, 0, 0, 9},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 8, 5, 1, 9, 3, 6, 2, 0},
                            {0, 4, 0, 5, 8, 6, 0, 9, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues20);

                    break;
                default:
                    log.info("Default case game was selected (not intended to ever happen)");

                    int[][] gameSolutionValuesX = {
                            {2, 8, 9, 6, 4, 3, 5, 1, 7},
                            {5, 7, 4, 9, 2, 1, 8, 6, 3},
                            {1, 3, 6, 7, 8, 5, 2, 9, 4},
                            {8, 6, 1, 5, 3, 9, 4, 7, 2},
                            {4, 5, 2, 8, 1, 7, 6, 3, 9},
                            {3, 9, 7, 2, 6, 4, 1, 8, 5},
                            {6, 4, 8, 3, 9, 2, 7, 5, 1},
                            {9, 2, 5, 1, 7, 8, 3, 4, 6},
                            {7, 1, 3, 4, 5, 6, 9, 2, 8},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValuesX);

                    int[][] gamePuzzleValuesX = {
                            {2, 8, 0, 0, 0, 0, 0, 1, 7},
                            {0, 0, 0, 9, 0, 1, 0, 0, 0},
                            {0, 0, 6, 0, 8, 0, 0, 0, 4},
                            {0, 6, 0, 5, 0, 0, 0, 7, 0},
                            {0, 0, 0, 0, 1, 0, 0, 0, 9},
                            {0, 0, 7, 0, 0, 0, 0, 8, 0},
                            {0, 0, 0, 3, 0, 0, 0, 5, 0},
                            {0, 0, 5, 0, 0, 0, 3, 0, 0},
                            {0, 1, 0, 4, 0, 0, 9, 0, 8},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValuesX);

                    break;
            }
        } else if (currentlevel == 3) {
            switch (randomNumber) {

                //difficult:
                case 1:
                    int[][] gameSolutionValues21 = {
                            {5, 4, 9, 1, 6, 8, 2, 3, 7},
                            {7, 8, 6, 3, 9, 2, 4, 5, 1},
                            {3, 1, 2, 7, 5, 4, 9, 8, 6},
                            {6, 9, 8, 4, 2, 1, 5, 7, 3},
                            {4, 5, 3, 9, 7, 6, 8, 1, 2},
                            {1, 2, 7, 8, 3, 5, 6, 9, 4},
                            {8, 7, 1, 2, 4, 9, 3, 6, 5},
                            {2, 3, 5, 6, 8, 7, 1, 4, 9},
                            {9, 6, 4, 5, 1, 3, 7, 2, 8},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues21);

                    int[][] gamePuzzleValues21 = {
                            {5, 4, 0, 0, 6, 0, 0, 3, 7},
                            {0, 8, 0, 0, 0, 0, 0, 5, 0},
                            {0, 0, 2, 7, 0, 4, 9, 0, 0},
                            {0, 0, 0, 4, 2, 1, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 8, 3, 5, 0, 0, 0},
                            {0, 0, 1, 2, 0, 9, 3, 0, 0},
                            {0, 3, 0, 0, 0, 0, 0, 4, 0},
                            {9, 6, 0, 0, 1, 0, 0, 2, 8},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues21);

                    break;


                case 2:
                    int[][] gameSolutionValues22 = {
                            {5, 1, 4, 2, 8, 3, 6, 9, 7},
                            {7, 9, 2, 1, 6, 5, 8, 3, 4},
                            {6, 8, 3, 4, 7, 9, 5, 1, 2},
                            {8, 7, 5, 6, 1, 2, 3, 4, 9},
                            {2, 3, 1, 9, 4, 8, 7, 6, 5},
                            {9, 4, 6, 5, 3, 7, 2, 8, 1},
                            {3, 2, 8, 7, 9, 4, 1, 5, 6},
                            {4, 6, 7, 3, 5, 1, 9, 2, 8},
                            {1, 5, 9, 8, 2, 6, 4, 7, 3},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues22);

                    int[][] gamePuzzleValues22 = {
                            {0, 1, 0, 0, 8, 0, 0, 9, 0},
                            {7, 0, 0, 0, 0, 0, 0, 0, 4},
                            {0, 0, 3, 4, 0, 9, 5, 0, 0},
                            {0, 0, 5, 0, 1, 0, 3, 0, 0},
                            {0, 3, 0, 9, 0, 8, 0, 6, 0},
                            {0, 0, 6, 0, 3, 0, 2, 0, 0},
                            {0, 0, 8, 7, 0, 4, 1, 0, 0},
                            {4, 0, 0, 0, 0, 0, 0, 0, 8},
                            {0, 5, 0, 0, 2, 0, 0, 7, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues22);

                    break;


                case 3:
                    int[][] gameSolutionValues23 = {
                            {8, 3, 2, 4, 6, 9, 7, 5, 1},
                            {7, 9, 6, 1, 5, 3, 8, 2, 4},
                            {4, 1, 5, 2, 8, 7, 3, 9, 6},
                            {3, 4, 1, 7, 2, 5, 6, 8, 9},
                            {6, 2, 7, 9, 3, 8, 4, 1, 5},
                            {5, 8, 9, 6, 1, 4, 2, 7, 3},
                            {9, 5, 8, 3, 4, 2, 1, 6, 7},
                            {2, 6, 4, 5, 7, 1, 9, 3, 8},
                            {1, 7, 3, 8, 9, 6, 5, 4, 2},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues23);

                    int[][] gamePuzzleValues23 = {
                            {0, 3, 0, 4, 0, 9, 0, 5, 0},
                            {7, 0, 0, 1, 0, 3, 0, 0, 4},
                            {0, 0, 5, 0, 0, 0, 3, 0, 0},
                            {0, 0, 1, 7, 0, 5, 6, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 9, 6, 0, 4, 2, 0, 0},
                            {0, 0, 8, 0, 0, 0, 1, 0, 0},
                            {2, 0, 0, 5, 0, 1, 0, 0, 8},
                            {0, 7, 0, 8, 0, 6, 0, 4, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues23);

                    break;


                case 4:
                    int[][] gameSolutionValues24 = {
                            {2, 9, 4, 8, 3, 1, 7, 6, 5},
                            {3, 1, 7, 5, 2, 6, 8, 9, 4},
                            {5, 6, 8, 4, 9, 7, 1, 3, 2},
                            {1, 3, 6, 7, 8, 5, 4, 2, 9},
                            {8, 2, 5, 9, 1, 4, 6, 7, 3},
                            {4, 7, 9, 2, 6, 3, 5, 1, 8},
                            {9, 4, 3, 6, 7, 8, 2, 5, 1},
                            {6, 8, 2, 1, 5, 9, 3, 4, 7},
                            {7, 5, 1, 3, 4, 2, 9, 8, 6},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues24);

                    int[][] gamePuzzleValues24 = {
                            {2, 9, 0, 0, 3, 0, 0, 6, 5},
                            {0, 0, 0, 5, 0, 6, 0, 0, 0},
                            {0, 0, 8, 0, 0, 0, 1, 0, 0},
                            {1, 0, 0, 7, 0, 5, 0, 0, 9},
                            {8, 0, 0, 0, 0, 0, 0, 0, 3},
                            {4, 0, 0, 2, 0, 3, 0, 0, 8},
                            {0, 0, 3, 0, 0, 0, 2, 0, 0},
                            {0, 0, 0, 1, 0, 9, 0, 0, 0},
                            {7, 5, 0, 0, 4, 0, 0, 8, 6},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues24);

                    break;


                case 5:
                    int[][] gameSolutionValues25 = {
                            {7, 9, 6, 2, 3, 8, 1, 5, 4},
                            {1, 3, 5, 4, 6, 7, 2, 9, 8},
                            {2, 4, 8, 1, 9, 5, 7, 3, 6},
                            {6, 1, 3, 5, 8, 4, 9, 2, 7},
                            {9, 2, 7, 3, 1, 6, 4, 8, 5},
                            {5, 8, 4, 7, 2, 9, 3, 6, 1},
                            {3, 7, 1, 8, 5, 2, 6, 4, 9},
                            {4, 5, 9, 6, 7, 3, 8, 1, 2},
                            {8, 6, 2, 9, 4, 1, 5, 7, 3},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues25);

                    int[][] gamePuzzleValues25 = {
                            {0, 0, 0, 0, 3, 0, 0, 0, 0},
                            {0, 0, 5, 0, 6, 0, 2, 0, 0},
                            {2, 0, 0, 1, 0, 5, 0, 0, 6},
                            {0, 1, 3, 0, 0, 0, 9, 2, 0},
                            {0, 0, 7, 3, 0, 6, 4, 0, 0},
                            {0, 8, 4, 0, 0, 0, 3, 6, 0},
                            {3, 0, 0, 8, 0, 2, 0, 0, 9},
                            {0, 0, 9, 0, 7, 0, 8, 0, 0},
                            {0, 0, 0, 0, 4, 0, 0, 0, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues25);

                    break;


                case 6:
                    int[][] gameSolutionValues26 = {
                            {5, 9, 3, 2, 8, 1, 4, 6, 7},
                            {7, 8, 2, 4, 6, 9, 3, 1, 5},
                            {1, 6, 4, 5, 7, 3, 2, 9, 8},
                            {4, 7, 9, 8, 2, 6, 5, 3, 1},
                            {3, 2, 8, 1, 5, 7, 6, 4, 9},
                            {6, 5, 1, 3, 9, 4, 8, 7, 2},
                            {9, 3, 5, 7, 4, 8, 1, 2, 6},
                            {8, 4, 7, 6, 1, 2, 9, 5, 3},
                            {2, 1, 6, 9, 3, 5, 7, 8, 4},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues26);

                    int[][] gamePuzzleValues26 = {
                            {5, 9, 0, 0, 0, 0, 0, 6, 7},
                            {0, 0, 2, 0, 0, 0, 3, 0, 0},
                            {0, 6, 0, 5, 0, 3, 0, 9, 0},
                            {4, 0, 0, 8, 0, 6, 0, 0, 1},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {6, 0, 0, 3, 0, 4, 0, 0, 2},
                            {0, 3, 0, 7, 0, 8, 0, 2, 0},
                            {0, 0, 7, 0, 0, 0, 9, 0, 0},
                            {2, 1, 0, 0, 0, 0, 0, 8, 4},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues26);

                    break;


                case 7:
                    int[][] gameSolutionValues27 = {
                            {8, 9, 3, 4, 1, 7, 6, 2, 5},
                            {7, 4, 1, 6, 2, 5, 3, 8, 9},
                            {6, 2, 5, 9, 3, 8, 1, 4, 7},
                            {4, 1, 6, 7, 9, 3, 2, 5, 8},
                            {5, 3, 7, 8, 6, 2, 9, 1, 4},
                            {9, 8, 2, 5, 4, 1, 7, 3, 6},
                            {3, 7, 9, 1, 8, 4, 5, 6, 2},
                            {2, 6, 8, 3, 5, 9, 4, 7, 1},
                            {1, 5, 4, 2, 7, 6, 8, 9, 3},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues27);

                    int[][] gamePuzzleValues27 = {
                            {0, 0, 3, 4, 0, 7, 6, 0, 0},
                            {7, 0, 0, 0, 0, 0, 0, 0, 9},
                            {0, 2, 0, 0, 3, 0, 0, 4, 0},
                            {0, 1, 0, 7, 9, 3, 0, 5, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 8, 0, 5, 4, 1, 0, 3, 0},
                            {0, 7, 0, 0, 8, 0, 0, 6, 0},
                            {2, 0, 0, 0, 0, 0, 0, 0, 1},
                            {0, 0, 4, 2, 0, 6, 8, 0, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues27);

                    break;


                case 8:
                    int[][] gameSolutionValues28 = {
                            {3, 5, 7, 8, 2, 9, 6, 1, 4},
                            {8, 9, 1, 6, 5, 4, 7, 3, 2},
                            {2, 6, 4, 1, 3, 7, 9, 8, 5},
                            {5, 4, 8, 3, 9, 6, 1, 2, 7},
                            {6, 2, 3, 7, 1, 5, 8, 4, 9},
                            {1, 7, 9, 2, 4, 8, 3, 5, 6},
                            {7, 8, 2, 5, 6, 1, 4, 9, 3},
                            {4, 1, 5, 9, 7, 3, 2, 6, 8},
                            {9, 3, 6, 4, 8, 2, 5, 7, 1},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues28);

                    int[][] gamePuzzleValues28 = {
                            {3, 0, 0, 0, 2, 0, 0, 0, 4},
                            {0, 0, 1, 0, 0, 0, 7, 0, 0},
                            {0, 6, 0, 1, 0, 7, 0, 8, 0},
                            {0, 4, 0, 3, 9, 6, 0, 2, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 7, 0, 2, 4, 8, 0, 5, 0},
                            {0, 8, 0, 5, 0, 1, 0, 9, 0},
                            {0, 0, 5, 0, 0, 0, 2, 0, 0},
                            {9, 0, 0, 0, 8, 0, 0, 0, 1},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues28);

                    break;


                case 9:
                    int[][] gameSolutionValues29 = {
                            {9, 7, 3, 5, 8, 1, 2, 4, 6},
                            {4, 8, 2, 6, 3, 7, 5, 9, 1},
                            {5, 6, 1, 4, 2, 9, 3, 8, 7},
                            {7, 4, 9, 2, 6, 8, 1, 5, 3},
                            {1, 3, 6, 7, 5, 4, 8, 2, 9},
                            {8, 2, 5, 1, 9, 3, 6, 7, 4},
                            {2, 9, 7, 3, 1, 5, 4, 6, 8},
                            {3, 5, 8, 9, 4, 6, 7, 1, 2},
                            {6, 1, 4, 8, 7, 2, 9, 3, 5},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues29);

                    int[][] gamePuzzleValues29 = {
                            {9, 0, 0, 5, 8, 1, 0, 0, 6},
                            {0, 0, 0, 6, 0, 7, 0, 0, 0},
                            {0, 0, 1, 0, 2, 0, 3, 0, 0},
                            {0, 4, 0, 0, 6, 0, 0, 5, 0},
                            {1, 0, 0, 0, 0, 0, 0, 0, 9},
                            {0, 2, 0, 0, 9, 0, 0, 7, 0},
                            {0, 0, 7, 0, 1, 0, 4, 0, 0},
                            {0, 0, 0, 9, 0, 6, 0, 0, 0},
                            {6, 0, 0, 8, 7, 2, 0, 0, 5},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues29);

                    break;


                case 10:
                    int[][] gameSolutionValues30 = {
                            {7, 2, 1, 3, 8, 6, 9, 5, 4},
                            {4, 5, 8, 2, 7, 9, 6, 3, 1},
                            {6, 3, 9, 4, 1, 5, 2, 8, 7},
                            {1, 8, 6, 7, 9, 4, 3, 2, 5},
                            {3, 4, 7, 6, 5, 2, 1, 9, 8},
                            {5, 9, 2, 8, 3, 1, 7, 4, 6},
                            {9, 1, 4, 5, 2, 7, 8, 6, 3},
                            {8, 7, 5, 9, 6, 3, 4, 1, 2},
                            {2, 6, 3, 1, 4, 8, 5, 7, 9},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValues30);

                    int[][] gamePuzzleValues30 = {
                            {0, 0, 0, 3, 0, 6, 0, 0, 0},
                            {0, 5, 0, 0, 7, 0, 0, 3, 0},
                            {0, 0, 9, 0, 0, 0, 2, 0, 0},
                            {0, 0, 6, 7, 9, 4, 3, 0, 0},
                            {0, 4, 7, 0, 0, 0, 1, 9, 0},
                            {0, 0, 2, 8, 3, 1, 7, 0, 0},
                            {0, 0, 4, 0, 0, 0, 8, 0, 0},
                            {0, 7, 0, 0, 6, 0, 0, 1, 0},
                            {0, 0, 0, 1, 0, 8, 0, 0, 0},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValues30);

                    break;
                default:
                    log.info("Default case game was selected (not intended to ever happen)");

                    int[][] gameSolutionValuesX = {
                            {2, 8, 9, 6, 4, 3, 5, 1, 7},
                            {5, 7, 4, 9, 2, 1, 8, 6, 3},
                            {1, 3, 6, 7, 8, 5, 2, 9, 4},
                            {8, 6, 1, 5, 3, 9, 4, 7, 2},
                            {4, 5, 2, 8, 1, 7, 6, 3, 9},
                            {3, 9, 7, 2, 6, 4, 1, 8, 5},
                            {6, 4, 8, 3, 9, 2, 7, 5, 1},
                            {9, 2, 5, 1, 7, 8, 3, 4, 6},
                            {7, 1, 3, 4, 5, 6, 9, 2, 8},
                    };
                    bSolutionBoard.setCompletedBoard(gameSolutionValuesX);

                    int[][] gamePuzzleValuesX = {
                            {2, 8, 0, 0, 0, 0, 0, 1, 7},
                            {0, 0, 0, 9, 0, 1, 0, 0, 0},
                            {0, 0, 6, 0, 8, 0, 0, 0, 4},
                            {0, 6, 0, 5, 0, 0, 0, 7, 0},
                            {0, 0, 0, 0, 1, 0, 0, 0, 9},
                            {0, 0, 7, 0, 0, 0, 0, 8, 0},
                            {0, 0, 0, 3, 0, 0, 0, 5, 0},
                            {0, 0, 5, 0, 0, 0, 3, 0, 0},
                            {0, 1, 0, 4, 0, 0, 9, 0, 8},
                    };
                    bPuzzleBoard.setCompletedBoard(gamePuzzleValuesX);
                    break;
            }
        }
    }
    public Board getSolutionBoard() {
        return bSolutionBoard;
    }
    public Board getPuzzleBoard() {
        return bPuzzleBoard;
    }



}