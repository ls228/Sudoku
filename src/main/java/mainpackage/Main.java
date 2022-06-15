package mainpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // JavaFX stuff
        URL fxmlFileUrl = getClass().getClassLoader().getResource("startgame.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));
        primaryStage.setTitle("Sudoku");
        Scene myScene = new Scene(root, 600, 400);
        primaryStage.setScene(myScene);
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);

        window = primaryStage;
        window.setTitle("Sudoku");
        window.show();
    }


    // get puzzle & solution Boards
    public static Board puzzleBoard = Games.getPuzzle_board();
    public static Board solutionBoard = Games.getSolution_board();


    public static void main(String[] args) {
        launch(args); // calls start-method
    }
}