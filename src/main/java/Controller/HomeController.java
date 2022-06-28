package Controller;

import Game.ReaderWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import Game.Sudokus;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController extends Controller implements Initializable{

    ReaderWriter readWrite = new ReaderWriter();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblSolvedGames.setText(readWrite.read(counterUrl).size() +" games solved");
    }

    @FXML
    private Label lblSolvedGames = null;

    @FXML
    protected void levelPressed(ActionEvent event) {
        Button activeButton = (Button) event.getSource();
        btnLevel = activeButton;
        Sudokus games = new Sudokus(Integer.parseInt(btnLevel.getId()),randomNumber);
        //eigentlich nur noch eine fxml datei benötigt
        loadNewScene(event, level);
    }

    @FXML
    protected void goBackHome(ActionEvent event) {
        loadNewScene(event, startGame);
    }
}