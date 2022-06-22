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

public class homeController extends Controller implements Initializable{

    ReaderWriter readWrite = new ReaderWriter();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        solvedGames.setText(readWrite.read().size() +" games solved");
    }

    @FXML
    private Label solvedGames = null;

    @FXML
    protected void levelpressed(ActionEvent event) {
        Button activeButton = (Button) event.getSource();
        levelButton = activeButton;
        Sudokus games = new Sudokus(Integer.parseInt(levelButton.getId()));
        //eigentlich nur noch eine fxml datei benötigt
        String url = "game1.fxml";
        loadNewScene(event, url);
    }

    @FXML
    protected void goBackHome(ActionEvent event) {
        String url = "startgame.fxml";
        loadNewScene(event, url);
    }
}