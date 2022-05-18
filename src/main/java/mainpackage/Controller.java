package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private void sayHello(ActionEvent event) {
        System.out.println("Game starting");
    }

    @FXML
    private Label label1;

    public void initialize() {
        label1.setText("Blabla");
    }


}
