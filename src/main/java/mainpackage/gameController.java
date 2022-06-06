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
    int count=0;

    /*
    public void sceneLoader(URL fxmlFileUrl,ActionEvent event){
        try {
            Parent root = FXMLLoader.load(fxmlFileUrl);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void startRound() {

        while (!Main.gameFinished) {

            //Games game = new Games();
            //System.out.println(Main.puzzleBoard.toString());

            // System.out.println("Bei (1|1) ist: " + Main.puzzleBoard.getNumberAtIdx(1,1));

            System.out.println("Set new sudoku");
            //GridPane sudokuGridPane = new GridPane();
            //ID vom Label
            String idLabel;
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {

                    idLabel = "Label_" + row + "_" +col;
                    System.out.println(idLabel);

                    //Label bekommt Wert vom puzzleboard
                    //Zahlen Wert an Index
                    int valuePuzzleBoardAtIndex = Main.puzzleBoard.getNumberAtIdx(row,col);

                    Label currentlySelectedLabel = new Label();
                    currentlySelectedLabel.setText(idLabel);
                    currentlySelectedLabel.setText(Integer.toString(valuePuzzleBoardAtIndex));
                }
            }

            // sudokuGridPane.getChildren().add(Games.getPuzzle_board());

            /*
            System.out.println("Rätsel: ");
            System.out.println(Main.puzzleBoard.toString());

            System.out.println("Lösung: (auskommentiert)");

            System.out.println("added number "+ value);
            */
            break;
        }
        //board.checkWinning();
    }

    public boolean checkInput(int value){

        String id = SelectedLabel.getId();
        char rowchar=id.charAt(6);
        char colchar=id.charAt(8);
        int row= Integer.parseInt( String.valueOf(rowchar) );
        int col= Integer.parseInt( String.valueOf(colchar) );
        int valueSolved=Main.solutionBoard.getNumberAtIdx(row,col);
        if(value==valueSolved){
            Background bg = new Background(new BackgroundFill(Color.WHITE, null, null));
            SelectedLabel.setBackground(bg);
            System.out.println("true");
            return true;
        }
        System.out.println("false");
        Background bg = new Background(new BackgroundFill(Color.PINK, null, null));
        SelectedLabel.setBackground(bg);
        if(count<3){
            count++;
        } else{
            startRound();
        }
        return false;
    }

    @FXML
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
        //Games.read().add(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("1");
        checkInput(value);
    }

    @FXML
    protected void auswahl2() {
        this.value=2;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("2");
        checkInput(value);
    }
    @FXML
    protected void auswahl3() {
        this.value=3;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("3");
        checkInput(value);
    }
    @FXML
    protected void auswahl4() {
        this.value=4;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("4");
        checkInput(value);
    }
    @FXML
    protected void auswahl5() {
        this.value=5;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("5");
        checkInput(value);
    }
    @FXML
    protected void auswahl6() {
        this.value=6;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("6");
        checkInput(value);
    }
    @FXML
    protected void auswahl7() {
        this.value=7;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("7");
        checkInput(value);
    }
    @FXML
    protected void auswahl8() {
        this.value=8;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("8");
        checkInput(value);
    }
    @FXML
    protected void auswahl9() {
        this.value=9;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("9");
        checkInput(value);
    }

    @FXML
    protected void backPressed(){
        Background bg = new Background(new BackgroundFill(Color.WHITE, null, null));
        SelectedLabel.setBackground(bg);
        SelectedLabel.setText("0");
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
       /* Label label = (Label) event.getSource();

        if(LastselctedLabel!=null)
            LastselctedLabel.setBackground(null);

        LastselctedLabel = label;

        Background bg = new Background(new BackgroundFill(Color.WHEAT, null, null));
        label.setBackground(bg);*/
    }


    public void setValue(int value) {
       this.value=value;
    }

    public static int getValue() {
        return value;
    }
}
