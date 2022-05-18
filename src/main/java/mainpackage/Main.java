package mainpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL fxmlFileUrl = getClass().getClassLoader().getResource("sample.fxml");
        // URL fxmlFileUrl = getClass().getClassLoader().getResource("Scenebuilder.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));
        primaryStage.setTitle("Very cool Sudoku");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Games games = new Games();

        startRound();
    }

    private Board puzzleBoard = Games.getPuzzle_board();
    private Board solutionBoard = Games.getSolution_board();

    private boolean gameFinished = false;

    /***
     *  Hauptablauf des Spiels
     */
    public void startRound() {


        Scanner sc = new Scanner(System.in);

        // immer wieder nach input fragen, den eingegebenen input auf dem rätselbrett updaten, nach fehlern prüfen, ...
        while(!gameFinished){
            System.out.println("Rätsel: ");
            System.out.println(puzzleBoard.toString());

            System.out.println("Lösung: (auskommentiert)");
            // System.out.println(solutionBoard.toString());


            // (der Teil wird später über die GUI umgesetzt)
            System.out.println("Where do you want to set another number?");
            System.out.println("Enter line number: ");
            int lineNr = sc.nextInt() - 1;
            System.out.println("Enter column number: ");
            int colNr = sc.nextInt() - 1;
            System.out.println("Enter the number you want to set at (" + lineNr+1 + "|" + colNr+1 + "): ");
            int numberToSet = sc.nextInt();

            puzzleBoard.setValueInBrett(lineNr, colNr, numberToSet);
        }

        // board.checkWinning();
    }

    public static void main(String[] args) {
        launch(args);
    }
}