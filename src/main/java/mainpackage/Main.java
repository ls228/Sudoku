package mainpackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
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

    /**
     * This method is generating a new scene on top of the stage by loading the given fxml file
     * @param event
     * @param url
     */
    public void loadNewScene(ActionEvent event, String url) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        URL fxmlFileUrl = getClass().getClassLoader().getResource(url);
        try {
            Parent root = FXMLLoader.load(fxmlFileUrl);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // get puzzle & solution Boards
    public static Board puzzleBoard = Games.getPuzzle_board();
    public static Board solutionBoard = Games.getSolution_board();


    public static void main(String[] args) {
        launch(args); // calls start-method
    }
}