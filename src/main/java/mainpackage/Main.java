package mainpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

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

    /***
     *  Hauptablauf des Spiels
     */
    public void startRound() {
        System.out.println("Rätsel: ");
        System.out.println(puzzleBoard.toString());

        System.out.println("Lösung: ");
        System.out.println(solutionBoard.toString());

        // board.checkWinning();
    }

    public static void main(String[] args) {
        launch(args);
    }
}