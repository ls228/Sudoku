package Controller;

import Game.ReaderWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import Game.Board;
import Game.Sudokus;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;

/***
 * Controller Class, parent class for the other controller-classes responsible for handling the GUI setup.
 */
public class Controller {

    private static final Logger log = LogManager.getLogger(Controller.class);
    ReaderWriter readWrite = new ReaderWriter();
    Button levelButton = new Button();
    String counterUrl="src/main/resources/counter.txt";
    String level = "level.fxml";
    String startGame = "startgame.fxml";
    String homeFxml = "home.fxml";
    int randomNumber = (int) (10 * Math.random());

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
            log.info("Scene loaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Stage can't be loaded.");
        }
    }

    // get puzzle & solution Boards
    Board puzzleBoard = Sudokus.getPuzzle_board();
    Board solutionBoard = Sudokus.getSolution_board();
}


