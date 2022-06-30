package de.sudoku.controller;

import de.sudoku.game.ReaderWriter;
import de.sudoku.game.Sudokus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController extends Controller implements Initializable {

    ReaderWriter readWrite = new ReaderWriter();

    @FXML
    private Label lblSolvedGames = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblSolvedGames.setText(readWrite.read(COUNTER_URL).size() + " games solved");
    }

    @FXML
    protected void levelPressed(ActionEvent event) {
        Button activeButton = (Button) event.getSource();
        btnLevel = activeButton;
        activeSudoku.allSudokus(Integer.parseInt(btnLevel.getId()), randomNumber);
        loadNewScene(event, LEVEL_FXML);
    }

    @FXML
    protected void goBackHome(ActionEvent event) {
        loadNewScene(event, START_GAME_FXML);
    }
}