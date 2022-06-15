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
        primaryStage.setResizable(false);

        window = primaryStage;
        window.setTitle("Sudoku");
        window.show();

        // Game start
        //Games games = new Games(); // -> Games Class (generate random number, set puzzle & solution board)


       /*
        Line line= new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(200);
        line.setStrokeWidth(6);
        line.setStroke(Color.BLACK);

        root.getChildren().add(line);*/



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


    // get puzzle & solution Boards level1
    public static Board puzzleBoard = Games.getPuzzle_board();
    public static Board solutionBoard = Games.getSolution_board();

    // get puzzle & solution Boards level2
   // public static Board puzzleBoard2 = Games2.getPuzzle_board2();
    //public static Board solutionBoard2 = Games2.getSolution_board2();

    public static boolean gameFinished = false;


    public static void main(String[] args) {
        launch(args); // calls start-method
    }
}