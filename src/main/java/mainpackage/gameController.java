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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class gameController extends Controller implements Initializable {

    @FXML
    private GridPane sudokuGridPane;
    @FXML
    Label counter;
    Board finishedBoard = new Board();


    boolean labelAreInitialized = false;
    boolean wrongValue = false;
    boolean restartGame = true;

    Label LastselctedLabel = null;
    Label SelectedLabel = null;
    Button pressedButton = null;

    Background blue = new Background(new BackgroundFill(Color.CADETBLUE, null, null));
    Background lightblue = new Background(new BackgroundFill(Color.BEIGE, null, null));
    Background white = new Background(new BackgroundFill(Color.WHITE, null, null));
    Background pink = new Background(new BackgroundFill(Color.PINK, null, null));

    int count = 0;


    /**
     * Method initialize to start a new round
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (!labelAreInitialized) {
            this.setLabels();
            labelAreInitialized = true;
        }
        startRound();
    }

    /**
     * Method to load new Sudoku values in labels
     */

    private void startRound() {

        int size = sudokuGridPane.getChildren().size();
        Label label = null;
        if (sudokuGridPane != null && size > 0) {
            //for each Schleife um jedes Label zu testen
            for (Node node : sudokuGridPane.getChildren()) {
                try {
                    //to make sure that node is a label
                    //if it is label stays a node
                    label = (Label) node;
                } catch (Exception e) {
                    System.out.println("Exception. Node not a Label");
                }

                if (label != null) {
                    Position position = getRowCol(node.getId());
                    int valuePuzzleBoardAtIndex = puzzleBoard.getNumberAtIdx(position.col, position.row);
                    //to create labels that can be changed by user input
                    if (valuePuzzleBoardAtIndex == 0) {
                        label.setText(null);
                        label.setStyle("-fx-text-fill: grey;-fx-font: 24 arial;");
                    } else {
                        //given numbers can't be changed
                        label.setText(Integer.toString(valuePuzzleBoardAtIndex));
                        label.setBackground(lightblue);
                        label.setDisable(true);
                    }
                }
            }

        }
        //finishedBoard.setGanzesBrett(Games.solutionBoard);
        finishedBoard.setGanzesBrett(Games.puzzleBoard);
        System.out.println(finishedBoard);
    }

    /**
     * Method is setting labels when startGame button is clicked
     */

    public void setLabels() {
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
                //Mouse clicked is implicitly implemented to mark the selected label mark
                label.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Label label = (Label) event.getSource();
                        SelectedLabel = label;

                        if (LastselctedLabel != null)
                            LastselctedLabel.setBackground(null);

                        LastselctedLabel = label;
                        label.setBackground(blue);
                    }
                });
                if (sudokuGridPane != null) {
                    sudokuGridPane.add(label, i, j);
                }

            }
        }
    }

    /**
     * new class to enable input of labelId and output of col & row in method getRowCol
     */
    private class Position {
        public int row = 0;
        public int col = 0;
    }

    private Position getRowCol(String labelId) {
        char rowchar = labelId.charAt(6);
        char colchar = labelId.charAt(8);

        Position position = new Position();

        position.row = Integer.parseInt(String.valueOf(rowchar));
        position.col = Integer.parseInt(String.valueOf(colchar));

        return position;
    }

    /**
     * This method compares the input with the solutionBoard
     * If input is valse, the label turns red and counts one mistake
     *
     * @param value
     * @return boolean
     */

    private boolean checkInput(int value) {
        Position position = getRowCol(SelectedLabel.getId());
        int valueSolved = solutionBoard.getNumberAtIdx(position.col, position.row);
        if (value == valueSolved) {
            SelectedLabel.setBackground(white);
            return true;
        }
        wrongInput();
        wrongValue = true;
        if (count < 2) {
            count++;
            counter.setText("Wrong input counter: " + count + "/3");
            counter.setStyle("-fx-font: 12 arial;");
        } else {
            counter.setText("Wrong input counter: 3/3");
            display("YOU LOST");
            count = 0;
            counter.setText("Wrong input counter: " + count + "/3");
        }
        return false;
    }

    private void switchToHome() {
        if (!restartGame) {
            URL fxmlFileUrl = getClass().getClassLoader().getResource("home.fxml");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(fxmlFileUrl);
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Main.getMainWindow().setScene(scene);
                Main.getMainWindow().show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //to show a new window
    private void display(String status) {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        window.setMinWidth(200);
        window.setMinHeight(200);

        Label label1 = new Label();
        label1.setText(status);
        Label label2 = new Label();
        label2.setText("");
        Button restartButton = new Button("restart Game");
        restartButton.setStyle("-fx-background-color: #194e70;");
        restartButton.setStyle("-fx-text-fill: white;");

        restartButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                restartButton.setStyle("-fx-background-color:#abdbe7");
                restartButton.setStyle("-fx-text-fill: white;");
            }
        });

        restartButton.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                restartButton.setStyle("-fx-background-color:#194e70;");
                restartButton.setStyle("-fx-text-fill: white;");
            }
        });

        restartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
                restartGame = true;
                if (!labelAreInitialized) {
                    setLabels();
                    labelAreInitialized = true;
                }
            }
        });

        Button startNewGameButton = new Button("Home");
        startNewGameButton.setStyle("-fx-background-color: #194e70;");
        startNewGameButton.setStyle("-fx-text-fill: white;");
        startNewGameButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent f) {
                restartButton.setStyle("-fx-background-color:#abdbe7");
                startNewGameButton.setStyle("-fx-text-fill: white;");
            }
        });

        startNewGameButton.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent f) {
                restartButton.setStyle("-fx-background-color:#194e70;");
                startNewGameButton.setStyle("-fx-text-fill: white;");
            }
        });

        startNewGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
                restartGame = false;
                switchToHome();
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1);
        layout.getChildren().addAll(restartButton, startNewGameButton);
        layout.getChildren().addAll(label2);
        layout.setAlignment(Pos.CENTER);

        startRound();

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    @FXML
    protected void checkGame() {
        if (finishedBoard.checkWinning()) {
            display("YOU WON");
        } else {
            display("YOU LOST");
        }
    }

    @FXML
    protected void resetGame() {
        if (!labelAreInitialized) {
            this.setLabels();
            labelAreInitialized = true;
        }
        count = 0;
        counter.setText("Wrong input counter: " + count + "/3");
        startRound();
    }

    @FXML
    protected void goBackPressed(ActionEvent event) {
        String url = "home.fxml";
        loadNewScene(event, url);
    }

    /**
     * Button for input 1 to 9
     */

    @FXML
    protected void inputButton(ActionEvent event) {

        Button activeButton = (Button) event.getSource();
        pressedButton = activeButton;

        //get pressed value
        String id = pressedButton.getId();
        char choiceChar = id.charAt(7);
        int choiceInt = Integer.parseInt(String.valueOf(choiceChar));
        String choiceString = String.valueOf(choiceChar);

        if (this.SelectedLabel != null)
            this.SelectedLabel.setText(choiceString);
        checkInput(choiceInt);

        //to check the user input after the game is finished
        Position position = getRowCol(SelectedLabel.getId());
        finishedBoard.setValueInBrett(position.col, position.row, choiceInt);
        System.out.println(finishedBoard);

        if (!(finishedBoard.checkIfFinished())) {
            if (finishedBoard.checkWinning()) {
                display("YOU WON");
            } else {
                display("YOU LOST");
            }
        }
    }

    /*
    @FXML
    protected void auswahl2() {
        Position position = getRowCol(SelectedLabel.getId());
        finalBoard.setValueInBrett(position.row,position.col,2);
        if (this.SelectedLabel != null)
            this.SelectedLabel.setText("2");
        checkInput(2);
    }

    @FXML
    protected void auswahl3() {
        if (this.SelectedLabel != null)
            this.SelectedLabel.setText("3");
        checkInput(3);
    }

    @FXML
    protected void auswahl4() {
        if (this.SelectedLabel != null)
            this.SelectedLabel.setText("4");
        checkInput(4);
    }

    @FXML
    protected void auswahl5() {
        if (this.SelectedLabel != null)
            this.SelectedLabel.setText("5");
        checkInput(5);
    }

    @FXML
    protected void auswahl6() {
        if (this.SelectedLabel != null)
            this.SelectedLabel.setText("6");
        checkInput(6);
    }

    @FXML
    protected void auswahl7() {
        if (this.SelectedLabel != null)
            this.SelectedLabel.setText("7");
        checkInput(7);
    }

    @FXML
    protected void auswahl8() {
        if (this.SelectedLabel != null)
            this.SelectedLabel.setText("8");
        checkInput(8);
    }

    @FXML
    protected void auswahl9() {
        if (this.SelectedLabel != null)
            this.SelectedLabel.setText("9");
        checkInput(9);
    } */

    //delete last input
    @FXML
    protected void backPressed() {
        Position position = getRowCol(SelectedLabel.getId());
        SelectedLabel.setBackground(white);
        SelectedLabel.setText(null);
        finishedBoard.setValueInBrett(position.col, position.row, 0);
        System.out.println(finishedBoard);
    }

    //wrong input, red Background
    @FXML
    private void wrongInput() {
        SelectedLabel.setBackground(pink);
    }

}
