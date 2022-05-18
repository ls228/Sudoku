package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Controller {
    Stage window= new Stage();

    public Button button;
    @FXML
    TextArea textArea;

    @FXML
    private Label label;

    @FXML
    protected void buttonPressed() {
        String text = textArea.getText();
        label.setText(text);
        textArea.clear();
    }
    @FXML
    protected void playPressed() {

    }


    /*
    @FXML
    private void sayHello(ActionEvent event) {
        System.out.println("Game starting");
    }

    public void initialize() {
        label.setText("Blabla");
    }
    */
}