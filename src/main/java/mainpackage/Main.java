package mainpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class Main extends Application {

    Stage window;
    static Scene scene1;
    static Scene scene2;
    Stage fenster;
    Button button1, button2;
    Label label1,label2;
    //static int value = new gameController().value;

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxmlFileUrl = getClass().getClassLoader().getResource("startgame.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));
        primaryStage.setTitle("Sudoku");
        primaryStage.setScene(new Scene(root, 600, 400));

        //primaryStage.show();
        window = primaryStage;

        Label label1 = new Label("Welcome");

        window.setTitle("Sudoku");
        window.show();

        Games games = new Games();

        //startRound();
    }


    private Board puzzleBoard = Games.getPuzzle_board();
    private Board solutionBoard = Games.getSolution_board();
    private int value= gameController.getValue();

    private boolean gameFinished = false;



    /*
     *  Hauptablauf des Spiels
     */

    public void startRound() {

        int numberToSet;
        Scanner sc = new Scanner(System.in);

        // immer wieder nach input fragen, den eingegebenen input auf dem rätselbrett updaten, nach fehlern prüfen, ...
        while (!gameFinished) {
            System.out.println("Rätsel: ");
            System.out.println(puzzleBoard.toString());

            System.out.println("Lösung: (auskommentiert)");
            // System.out.println(solutionBoard.toString());


            // (der Teil wird später über die GUI umgesetzt)

            System.out.println("Enter line number: ");
            int lineNr = sc.nextInt() - 1;
            System.out.println("Enter column number: ");
            int colNr = sc.nextInt() - 1;
            System.out.println("Enter the number you want to set at (" + lineNr + 1 + "|" + colNr + 1 + "): ");
            numberToSet = gameController.getValue();
            System.out.println("added number "+ numberToSet);

            puzzleBoard.setValueInBrett(lineNr, colNr, numberToSet);
        }

        // board.checkWinning();
    }

    public static void main(String[] args) {
        launch(args);
    }
}