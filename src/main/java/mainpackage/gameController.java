package mainpackage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class gameController {
    @FXML private Label MyFirstLabel;
    @FXML private GridPane sudokuGridPane;
    boolean labelAreInitialized=false;
    Label LastselctedLabel = null;
    Label SelectedLabel = null;

    public static int value=0;
    boolean wrongValue=false;
    int count=0;

    private void setLabels(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Label label = new Label("0");
                label.setVisible(true);
                label.setId("Label_" + i + "_" + j);
                label.setAlignment(Pos.CENTER);
                label.setPrefHeight(44.0);
                label.setPrefWidth(46.0);

                //Mouse clicked wird hier implizit implementiert um das selektierte Label zu
                //markieren.
                label.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Label label = (Label) event.getSource();
                        SelectedLabel = label;

                        if(LastselctedLabel!=null)
                            LastselctedLabel.setBackground(null);

                        LastselctedLabel = label;

                        Background bg = new Background(new BackgroundFill(Color.CADETBLUE, null, null));
                        label.setBackground(bg);
                    }
                });
                //GridPane.columnIndex="8" GridPane.rowIndex="8"
                if(sudokuGridPane!=null) {
                    sudokuGridPane.add(label, i, j);
                    //sudokuGridPane.getChildren().add(label);
                }
            }

        }
    }
       /*
    }

        */
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

    public class Position
    {
        public int row=0;
        public int col=0;
    }

    private Position getRowCol(String labelId) {
        char rowchar = labelId.charAt(6);
        char colchar = labelId.charAt(8);

        Position position=new Position();

        position.row = Integer.parseInt(String.valueOf(rowchar));
        position.col = Integer.parseInt(String.valueOf(colchar));

        return position;
    }

    //public void startRound() {
    public void startRound(){

        while (!Main.gameFinished) {

            //Games game = new Games();
            //System.out.println(Main.puzzleBoard.toString());

            // System.out.println("Bei (1|1) ist: " +
            // Main.puzzleBoard.getNumberAtIdx(1,1));
            System.out.println("Set new sudoku");
            int size = sudokuGridPane.getChildren().size();
            Label label=null;
            if(sudokuGridPane!=null && sudokuGridPane.getChildren().size()>0) {
                for (Node node : sudokuGridPane.getChildren()) {

                    try {
                        //Sicherstellen, dass node wirlich ein Label ist.
                        //Wenn nicht, wird eine exception geworfen. In diesem Fall
                        // bleibt label null und kann einfach ignoriert werden.
                        label = (Label) node;
                    }
                    catch(Exception e)
                        {

                        }
                    if(label!=null) {
                        Position position = getRowCol(node.getId());
                        int valuePuzzleBoardAtIndex = Main.puzzleBoard.getNumberAtIdx(position.row, position.col);
                        label.setText(Integer.toString(valuePuzzleBoardAtIndex));
                    }
                }

            }

            //GridPane sudokuGridPane = new GridPane();
            //ID vom Label
            /* hat nicht funktioniert
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
        wrongValue=true;
        if(count<3){


            count++;

        } else{
            //display();
            startRound();
        }
        return false;
    }


    /*
    public static void display() {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        window.setMinWidth(300);
        window.setMaxHeight(250);

        Label label1 = new Label();
        label1.setText("You won");
        Label label2 = new Label();
        label2.setText("Congratulation");


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1);
        layout.getChildren().addAll(label2);
        layout.setAlignment(Pos.CENTER);

        Scene scene =new Scene(layout);
        window.setScene(scene);
        window.show();

    }
     */
    @FXML
    public void OnStartGameClicked(MouseEvent event) {
        if(!labelAreInitialized) {
            this.setLabels();
            labelAreInitialized = true;
        }
        startRound();
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

        //startRound();
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
        //startRound();
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

    //für falschen Input rotes Feld
    @FXML
    private void wrongInput() {
        Background bg = new Background(new BackgroundFill(Color.PINK, null, null));
        SelectedLabel.setBackground(bg);
    }


    public void setValue(int value) {
       this.value=value;
    }
}
