package mainpackage;

import javafx.event.ActionEvent;
import javafx.event.Event;
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
import java.util.ResourceBundle;

public class gameController implements Initializable {

    @FXML private GridPane sudokuGridPane;
    @FXML Label counter;

    boolean labelAreInitialized=false;
    boolean wrongValue=false;
    boolean youLost=false;

    Label LastselctedLabel = null;
    Label SelectedLabel = null;

    Background blue = new Background(new BackgroundFill(Color.CADETBLUE, null, null));
    Background lightblue = new Background(new BackgroundFill(Color.BEIGE, null, null));
    Background white = new Background(new BackgroundFill(Color.WHITE, null, null));
    Background pink = new Background(new BackgroundFill(Color.PINK, null, null));

    public static int value=0;
    int count=0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(!labelAreInitialized) {
            this.setLabels();
            labelAreInitialized = true;
        }
        startRound();
    }

    /**
     * Method to load new Sudoku values in labels
     */
    public void startRound(){

            int size = sudokuGridPane.getChildren().size();
            Label label=null;
            if(sudokuGridPane!=null && size>0) {
                //for each Schleife um jedes Label zu testen
                for (Node node : sudokuGridPane.getChildren()) {
                   try {
                        //to make sure that node is a label
                        //if it is label stays a node
                        label = (Label) node;
                    }
                    catch(Exception e)
                    {
                        System.out.println("Exception. Node not a Label");
                    }

                    if(label!=null) {
                        Position position = getRowCol(node.getId());
                        int valuePuzzleBoardAtIndex = Main.puzzleBoard.getNumberAtIdx(position.col,position.row);
                        //to create labels that can be changed by user input
                        if(valuePuzzleBoardAtIndex==0) {
                            label.setText(null);
                            label.setStyle("-fx-text-fill: grey;-fx-font: 24 arial;");
                            //label.setStyle("-fx-font: 24 arial;");
                        }else{
                            //given numbers can't be changed
                            label.setText(Integer.toString(valuePuzzleBoardAtIndex));
                            label.setBackground(lightblue);
                            label.setDisable(true);
                        }
                    }
                }

        }
        //board.checkWinning();
    }

    /**
     * Method is setting labels when startGame button is clicked
     */

    private void setLabels(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //every label is getting a value of 0
                Label label = new Label();
                label.setVisible(true);
                label.setId("Label_" + i + "_" + j);
                label.setAlignment(Pos.CENTER);
                //position
                label.setPrefHeight(44.0);
                label.setPrefWidth(46.0);
                label.setStyle("-fx-font: 24 arial;");
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
                        label.setBackground(blue);
                    }
                });
                if(sudokuGridPane!=null) {
                    sudokuGridPane.add(label, i, j);
                }
            }
        }
    }



    /**
     * new class to enable input of labelId and output of col & row in method getRowCol
     */
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

    /**
     * This method compares the input with the solutionBoard
     * If input is valse, the label turns red and counts one mistake
     * @param value
     * @return boolean
     */

    public boolean checkInput(int value){
        String id = SelectedLabel.getId();
        char rowchar=id.charAt(6);
        char colchar=id.charAt(8);
        int row= Integer.parseInt( String.valueOf(rowchar) );
        int col= Integer.parseInt( String.valueOf(colchar) );
        int valueSolved=Main.solutionBoard.getNumberAtIdx(col,row);
        if(value==valueSolved){
            SelectedLabel.setBackground(white);
            return true;
        }
        wrongInput();
        wrongValue=true;
        if(count<2){
            count++;
            counter.setText("Wrong input counter: "+count+"/3");
            counter.setStyle("-fx-font: 12 arial;");
        } else {
            counter.setText("Wrong input counter: 3/3");
            display();
        }
        return false;
    }

    //to show a new window

    public void display() {
        youLost=true;

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        window.setMinWidth(200);
        window.setMinHeight(200);

        Label label1 = new Label();
        label1.setText("You lost");
        Label label2 = new Label();
        label2.setText("");
        Button backButton=new Button("Close");
        //EventHandler<ActionEvent> actionEventEventHandler = goBackPressed(event);
        //backButton.setOnAction(actionEventEventHandler);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Close");
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            }});


        Button startNewGameButton = new Button("start new Game");

        startNewGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("new Game");
                Node source = (Node) event.getSource();
                Stage window = (Stage) source.getScene().getWindow();
                window.close();
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
            }});


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1);
        layout.getChildren().addAll(backButton, startNewGameButton);
        layout.getChildren().addAll(label2);
        layout.setAlignment(Pos.CENTER);

        Scene scene =new Scene(layout);
        window.setScene(scene);
        window.show();
    }



    /**
     * Method to enable start playing
     * @param event
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

    /**
     * Buttons for input 1 to 9
     */

    @FXML
    protected void auswahl1() {
        this.value=1;
        setValue(value);
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

    //delete last input
    @FXML
    protected void backPressed(){
        SelectedLabel.setBackground(white);
        SelectedLabel.setText(null);
    }

    //für falschen Input rotes Feld
    @FXML
    private void wrongInput() {
        SelectedLabel.setBackground(pink);
    }

    public void setValue(int value) {
       this.value=value;
    }

}
