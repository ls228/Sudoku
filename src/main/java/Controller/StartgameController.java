package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Class handling the start-screen and user-interaction with the buttons on it.
 */
public class StartgameController extends Controller {
    Stage window= new Stage();
    public Button button;

    @FXML private javafx.scene.control.Button exit;

    @FXML
    protected void playPressed(ActionEvent event) {
        loadNewScene(event, homeFxml);
    }

    @FXML
    protected void exitGame(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void goBackSettingsPressed(ActionEvent event) {
        loadNewScene(event, startGame);
    }

    @FXML
    protected void settingsPressed(ActionEvent event) {
        loadNewScene(event, settings);
    }
}
