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
    static Scene scene1;
    static Scene scene2;
    Stage fenster;
    Button button1, button2;
    Label label1,label2;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // JavaFX stuff
        URL fxmlFileUrl = getClass().getClassLoader().getResource("startgame.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));
        primaryStage.setTitle("Sudoku");
        Scene myScene = new Scene(root, 600, 400);
        primaryStage.setScene(myScene);
        primaryStage.setFullScreen(false);

        window = primaryStage;
        window.setTitle("Sudoku");
        window.show();

        // Game start
        Games games = new Games(); // -> Games Class (generate random number, set puzzle & solution board)

       /*
        Line line= new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(200);
        line.setStrokeWidth(6);
        line.setStroke(Color.BLACK);

        root.getChildren().add(line);*/

    }


    // get puzzle & solution Boards level1
    public static Board puzzleBoard = Games.getPuzzle_board();
    public static Board solutionBoard = Games.getSolution_board();

    public static boolean gameFinished = false;


    public static void main(String[] args) {
        launch(args); // calls start-method
    }
}