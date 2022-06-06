package mainpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
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
        Scene myScene = new Scene(root, 600, 400);
        primaryStage.setScene(myScene);
        primaryStage.setFullScreen(false);

        window = primaryStage;

        Label label1 = new Label("Welcome");

        window.setTitle("Sudoku");
        window.show();

        Games games = new Games();

        //Scene myScene = primaryStage.getScene();

        GridPane sudokuGridPane = new GridPane();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Label label = new Label(String.valueOf(i));
                sudokuGridPane.getChildren().add(label);
            }
        }

        /*BorderPane sudokuBorderPane = new BorderPane();
        sudokuBorderPane.getChildren().add(sudokuGridPane);

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        Button button6 = new Button("Button 6");

        GridPane gridPane = new GridPane();

        gridPane.add(button1, 0, 0, 1, 1);
        gridPane.add(button2, 1, 0, 1, 1);
        gridPane.add(button3, 2, 0, 1, 1);
        gridPane.add(button4, 0, 1, 1, 1);
        gridPane.add(button5, 1, 1, 1, 1);
        gridPane.add(button6, 2, 1, 1, 1);

        sudokuBorderPane.getChildren().add(gridPane);
        Scene scene = new Scene(sudokuBorderPane, 240, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
        */

    }


    public static Board puzzleBoard = Games.getPuzzle_board();
    public static Board solutionBoard = Games.getSolution_board();

    public static boolean gameFinished = false;

    public static void main(String[] args) {
        launch(args);
    }
}