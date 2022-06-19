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

    Button levelButton = new Button();


    /**
     * This method is generating a new scene on top of the stage by loading the given fxml file
     *
     * @param event
     * @param url
     */
    public void loadNewScene(ActionEvent event, String url) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        URL fxmlFileUrl = getClass().getClassLoader().getResource(url);
        try {
            Parent root = FXMLLoader.load(fxmlFileUrl);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // get puzzle & solution Boards
    public static Board puzzleBoard = Games.getPuzzle_board();
    public static Board solutionBoard = Games.getSolution_board();

    /**
     * new class to enable input of labelId and output of col & row in method getRowCol
     */
    /*
    public class Position {
        public int row = 0;
        public int col = 0;
    }

    public Position getRowCol(String labelId) {
        char rowchar = labelId.charAt(6);
        char colchar = labelId.charAt(8);

        Position position = new Position();

        position.row = Integer.parseInt(String.valueOf(rowchar));
        position.col = Integer.parseInt(String.valueOf(colchar));

        return position;
    } */
}


