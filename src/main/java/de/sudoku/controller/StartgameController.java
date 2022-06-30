package de.sudoku.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Class handling the start-screen and user-interaction with the buttons on it.
 */
public class StartgameController extends Controller {

    Stage window = new Stage();

    @FXML
    protected void playPressed(ActionEvent event) {
        loadNewScene(event, HOME_FXML);
    }

    @FXML
    protected void exitGame(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void resetGame() {
        readWrite.removeEntries(COUNTER_URL);
    }
}
