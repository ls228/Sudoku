package de.sudoku.controller;

import de.sudoku.game.Board;
import de.sudoku.game.ReaderWriter;
import de.sudoku.game.Sudokus;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;

/***
 * de.sudoku.Controller Class, parent class for the other controller-classes responsible for handling the GUI setup.
 */
public class Controller {

    private static final Logger log = LogManager.getLogger(Controller.class);

    protected static String COUNTER_URL = "src/main/resources/counter.txt";
    protected static String LEVEL_FXML = "level.fxml";
    protected static String START_GAME_FXML = "startgame.fxml";
    protected static String HOME_FXML = "home.fxml";

    ReaderWriter readWrite = new ReaderWriter();
    Button btnLevel = new Button();
    int randomNumber = (int) (10 * Math.random());
    // get puzzle & solution Boards
    Board puzzleBoard = Sudokus.getPuzzleBoard();
    Board solutionBoard = Sudokus.getSolutionBoard();


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
            log.error(e.getStackTrace() + "Stage can't be loaded.");
        }
    }
}


