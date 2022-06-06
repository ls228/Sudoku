package mainpackage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class gameController {
    @FXML private Label MyFirstLabel;
    @FXML private GridPane MyFirstPanel;
    public static int value=0;

    public void startRound(int value) {

        int numberToSet;

        while (!Main.gameFinished) {
            System.out.println("Rätsel: ");
            System.out.println(Main.puzzleBoard.toString());

            System.out.println("Lösung: (auskommentiert)");

            System.out.println("added number "+ value);

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
        startRound(value);
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
        //Games.read().add(value);
        startRound(value);

        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("1");
    }

    @FXML
    protected void auswahl2() {
        this.value=2;
        setValue(value);
        startRound(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("2");
    }
    @FXML
    protected void auswahl3() {
        this.value=3;
        setValue(value);
        startRound(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("3");
    }
    @FXML
    protected void auswahl4() {
        this.value=4;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("4");
    }
    @FXML
    protected void auswahl5() {
        this.value=5;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("5");
    }
    @FXML
    protected void auswahl6() {
        this.value=6;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("6");
    }
    @FXML
    protected void auswahl7() {
        this.value=7;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("7");
    }
    @FXML
    protected void auswahl8() {
        this.value=8;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("8");
    }
    @FXML
    protected void auswahl9() {
        this.value=9;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("9");

        Background bg = new Background(new BackgroundFill(Color.CADETBLUE, null, null));
        this.MyFirstLabel.setBackground(bg);
    }


    @FXML
    private void MyFirstPanelClicked(MouseEvent event) {
        // code in this method is executed when the mouse is pressed
        // on a node with onMousePressed="#handleMousePress"
    }


    Label LastselctedLabel = null;
    Label SelectedLabel = null;

    @FXML
    private void MyFrstLabelClicked(MouseEvent event) {
        // code in this method is executed when the mouse is pressed
        // on a node with onMousePressed="#handleMousePress"

        Label label = (Label) event.getSource();
        SelectedLabel = label;

        if(LastselctedLabel!=null)
            LastselctedLabel.setBackground(null);

        LastselctedLabel = label;

        Background bg = new Background(new BackgroundFill(Color.CADETBLUE, null, null));
        label.setBackground(bg);
    }

    @FXML
    private void OnMouseMovedOnLabel(MouseEvent event) {
        Label label = (Label) event.getSource();

        if(LastselctedLabel!=null)
            LastselctedLabel.setBackground(null);

        LastselctedLabel = label;

        Background bg = new Background(new BackgroundFill(Color.WHEAT, null, null));
        label.setBackground(bg);
    }


    public void setValue(int value) {
       this.value=value;
    }

    public static int getValue() {
        return value;
    }
}
