package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class startgameController extends Controller {
    Stage window= new Stage();
    public Button button;

    @FXML private javafx.scene.control.Button exit;

    @FXML
    protected void playPressed(ActionEvent event) {
        String url = "home.fxml";
        loadNewScene(event, url);
    }

    @FXML
    protected void exitGame(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void goBackSettingsPressed(ActionEvent event) {
        String url = "startgame.fxml";
        loadNewScene(event, url);
    }

    @FXML
    protected void settingsPressed(ActionEvent event) {
        String url = "settings.fxml";
        loadNewScene(event, url);
    }
}






