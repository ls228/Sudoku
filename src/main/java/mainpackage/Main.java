package mainpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class Main extends Application {

    Stage window;
    static Scene scene1;
    static Scene scene2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL fxmlFileUrl = getClass().getClassLoader().getResource("sample.fxml");
        // URL fxmlFileUrl = getClass().getClassLoader().getResource("Scenebuilder.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));
        primaryStage.setTitle("Very cool Sudoku");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        window = primaryStage;

        Label label1 = new Label("Welcome");

        //Button 1
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction (e -> window.setScene(scene2));

        //Layout 1 - children are laid out in vertical column
        StackPane layout1 = new StackPane();
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 600, 600);

        //Button 2
        Button button2 = new Button("go back to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));

        //Layout 2
        //VBox layout2 = new VBox(20);
        //StackPane layout2 = new StackPane();
        GridPane layout2 = new GridPane();
        layout2.getChildren().addAll(button2);
        scene2 = new Scene(layout2, 600, 600);


        window.setScene(scene1);
        window.setTitle("Sudoku");
        window.show();


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