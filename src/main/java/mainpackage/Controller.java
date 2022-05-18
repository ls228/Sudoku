package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller {


    public Button button;
    @FXML
    TextArea textArea;

    @FXML
    private Label label;

    @FXML
    protected void buttonPressed(){
        String text = textArea.getText();
        label.setText(text);
        textArea.clear();
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