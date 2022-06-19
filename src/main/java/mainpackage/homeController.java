package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController extends Controller {


    @FXML
    protected void levelpressed(ActionEvent event) {
        Button activeButton = (Button) event.getSource();
        levelButton = activeButton;
        Games games = new Games(Integer.parseInt(levelButton.getId()));
        String url = "game"+levelButton.getId()+".fxml";
        loadNewScene(event, url);
    }

    /*
    @FXML
    protected void level2pressed(ActionEvent event) {
        Games games = new Games(2);
        String url = "game2.fxml";
        loadNewScene(event, url);
    }

    @FXML
    protected void level3pressed(ActionEvent event) {
        Games games = new Games(3);
        String url = "game3.fxml";
        loadNewScene(event, url);
    }

     */

    @FXML
    protected void goBackHome(ActionEvent event) {
        String url = "startgame.fxml";
        loadNewScene(event, url);
    }

}