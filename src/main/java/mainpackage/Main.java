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

    }


    public static Board puzzleBoard = Games.getPuzzle_board();
    public static Board solutionBoard = Games.getSolution_board();


    public static boolean gameFinished = false;

    public static void main(String[] args) {
        launch(args);
    }
}