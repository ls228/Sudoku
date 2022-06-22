package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import Game.Board;
import Game.Sudokus;

import java.io.IOException;
import java.net.URL;

/***
 * Controller Class, parent class for the other controller-classes responsible for handling the GUI setup.
 */
public class Controller {

    Button levelButton = new Button();
    String counterUrl="src/main/resources/counter.txt";
    String level1 = "game1.fxml";
    String startGame = "startgame.fxml";
    String settings = "settings.fxml";
    String homeFxml = "home.fxml";

    /**
     * This method generates a new scene on top of the stage by loading the given fxml file
     *
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // get puzzle & solution Boards
    static Board puzzleBoard = Sudokus.getPuzzle_board();
    static Board solutionBoard = Sudokus.getSolution_board();
}


