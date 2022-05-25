package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Controller {
    Stage window= new Stage();

    public Button button;
    @FXML
    TextArea textArea;

    @FXML
    private Label label;
    private Object Node;

    @FXML
    protected void buttonPressed() {
        String text = textArea.getText();
        label.setText(text);
        textArea.clear();
    }
    @FXML
    protected void playPressed(ActionEvent event) {

        URL fxmlFileUrl = getClass().getClassLoader().getResource("game1.fxml");
        try {
            Parent root = FXMLLoader.load(fxmlFileUrl);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

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