package Controller;

import javafx.application.Platform;
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
import Game.*;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class gameController extends Controller implements Initializable {

    @FXML
    private GridPane sudokuGridPane;
    @FXML
    Label counter;
    @FXML
    Label timer;

    Board finishedBoard = new Board();
    ReaderWriter readWrite = new ReaderWriter();
    homeController home = new homeController();

    boolean labelAreInitialized = false;
    boolean wrongValue = false;
    boolean restartGame = true;

    private timerCount timerCount;

    Label LastselctedLabel = null;
    Label SelectedLabel = null;

    Button pressedButton = null;

    Background blue = new Background(new BackgroundFill(Color.CADETBLUE, null, null));
    Background lightblue = new Background(new BackgroundFill(Color.BEIGE, null, null));
    Background white = new Background(new BackgroundFill(Color.WHITE, null, null));
    Background pink = new Background(new BackgroundFill(Color.PINK, null, null));

    int count = 0;

    //Timer
    int secondsPassed = 0;
    int time;


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
        timerCount = new timerCount();
        timerCount.setIsrunning(true);
        timerCount.start();

        timer.setText("Time passed:  " + Integer.toString(timerCount.getCount()) + " s");
        //timerCount.update();
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
        finishedBoard.setGanzesBrett(Sudokus.puzzleBoard);
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
            timer.setText("Time passed:  " + Integer.toString(timerCount.getCount()) + " s");
            return true;

        }
        wrongInput();
        wrongValue = true;
        if (count < 2) {
            count++;
            counter.setText("Wrong input counter: " + count + "/3");
            //counter.setStyle("-fx-font: 12 arial;");
        } else {
            counter.setText("Wrong input counter: 3/3");
            display("YOU LOST");
            count = 0;
            counter.setText("Wrong input counter: " + count + "/3");
           // gameFinished = true;
            //secondTimer.cancel();
            time = secondsPassed;
            timer.setText("Time passed:  " + time + " s");
        }
        timer.setText("Time passed:  " + Integer.toString(timerCount.getCount()) + " s");

        return false;
    }


    private void switchToHome() {
        if (!restartGame) {
            URL fxmlFileUrl = getClass().getClassLoader().getResource(homeFxml);
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
        timerCount.setIsrunning(false);

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        window.setMinWidth(200);
        window.setMinHeight(200);

        Label label1 = new Label();
        label1.setText(status);
        Button restartButton = new Button("restart Game");
        restartButton.setStyle("-fx-text-fill: white; -fx-background-color: #194e70;");

        restartButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                restartButton.setStyle("-fx-text-fill: white; -fx-background-color: #abdbe7;");
            }
        });

        restartButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                restartButton.setStyle("-fx-text-fill: white; -fx-background-color: #194e70;");
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
                timerCount = new timerCount();
                timerCount.setIsrunning(true);
                timerCount.start();
            }
        });

        Button homeButton = new Button("Home");
        homeButton.setStyle("-fx-background-color: #194e70; -fx-text-fill: white; ");

        homeButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent f) {
                homeButton.setStyle("-fx-text-fill: white; -fx-background-color:#abdbe7");
            }
        });

        homeButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent f) {
                homeButton.setStyle("-fx-text-fill: white; -fx-background-color:#194e70;");
            }
        });

        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
                restartGame = false;
                switchToHome();
                timerCount.setIsrunning(false);
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1);
        layout.getChildren().addAll(restartButton, homeButton);
        layout.setAlignment(Pos.CENTER);

        startRound();

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
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
        timerCount = new timerCount();
        timerCount.setIsrunning(true);
        timerCount.start();
    }

    @FXML
    protected void goBackPressed(ActionEvent event) {
        loadNewScene(event, homeFxml);
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

                //Label das anzeigt wie viele Spiele schon gewonnen wurden
                readWrite.write(1,counterUrl);

            } else {
                display("YOU LOST");
            }
        }
    }

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

    /*public void closeWindow(){
        Main.getMainWindow.new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // close sockets, etc
            }
        });
    }*/
}
