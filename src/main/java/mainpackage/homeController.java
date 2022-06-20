package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController extends Controller implements Initializable{

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        solvedGames.setText(gameController.countRightGames+" games solved");
    }

    @FXML
    private Label solvedGames = null;

    @FXML
    protected void levelpressed(ActionEvent event) {
        Button activeButton = (Button) event.getSource();
        levelButton = activeButton;
        Games games = new Games(Integer.parseInt(levelButton.getId()));
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