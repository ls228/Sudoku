package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class gameController {

    public static int value=0;

    public void startRound() {

        int numberToSet;

        while (!Main.gameFinished) {
            System.out.println("Rätsel: ");
            System.out.println(Main.puzzleBoard.toString());

            System.out.println("Lösung: (auskommentiert)");

            numberToSet = getValue();

            System.out.println("added number "+ numberToSet);

            break;
        }

        //board.checkWinning();
    }


    public void goBackPressed(ActionEvent event) {
        URL fxmlFileUrl = getClass().getClassLoader().getResource("home.fxml");
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
    @FXML
    protected void level1pressed(ActionEvent event){
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
        startRound();
    }
    @FXML
    protected void level2pressed(ActionEvent event){
        URL fxmlFileUrl = getClass().getClassLoader().getResource("game2.fxml");
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
    @FXML
    protected void level3pressed(ActionEvent event) {
        URL fxmlFileUrl = getClass().getClassLoader().getResource("game3.fxml");
        try {
            Parent root = FXMLLoader.load(fxmlFileUrl);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void auswahl1() {
        this.value=1;
        setValue(value);
    }

    @FXML
    protected void auswahl2() {
        this.value=value+2;
        setValue(value);
    }
    @FXML
    protected void auswahl3() {
        this.value=value+3;
        setValue(value);
    }
    @FXML
    protected void auswahl4() {
        this.value=value+4;
        setValue(value);
    }
    @FXML
    protected void auswahl5() {
        this.value=value+5;
        setValue(value);
    }
    @FXML
    protected void auswahl6() {
        this.value=value+6;
        setValue(value);
    }
    @FXML
    protected void auswahl7() {
        this.value=value+7;
        setValue(value);
    }
    @FXML
    protected void auswahl8() {
        this.value=value+8;
        setValue(value);
    }
    @FXML
    protected void auswahl9() {
        this.value=value+9;
        setValue(value);
    }

    public void setValue(int value) {
       this.value=value;
    }

    public static int getValue() {
        return value;
    }
}
