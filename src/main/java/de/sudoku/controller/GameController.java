package de.sudoku.controller;

import de.sudoku.game.Board;
import de.sudoku.game.Main;
import de.sudoku.game.Sudokus;
import de.sudoku.game.TimeCounter;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController extends Controller implements Initializable {

    private static final Logger log = LogManager.getLogger(GameController.class);

    public final Board finishedBoard = new Board();
    private final Background blue = new Background(new BackgroundFill(Color.CADETBLUE, null, null));
    private final Background lightblue = new Background(new BackgroundFill(Color.BEIGE, null, null));
    private final Background white = new Background(new BackgroundFill(Color.WHITE, null, null));
    private final Background pink = new Background(new BackgroundFill(Color.PINK, null, null));

    @FXML
    public GridPane sudokuGridPane;
    @FXML
    private Label lblCounter;
    @FXML
    private Label lblTimer;
    @FXML
    private Label lblLastSelected = null;
    @FXML
    private Label lblSelected = null;
    @FXML
    private Button btnNumberPressed = null;

    private boolean labelAreInitialized = false;
    private boolean restartGame = true;
    public boolean wrongValue = false;
    private int count = 0;

    private TimeCounter TimeCounter;

    AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            lblTimer.setText("Time passed:  " + TimeCounter.getCount() + " s");
        }
    };

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
        TimeCounter = new TimeCounter();
        TimeCounter.setIsRunning(true);
        TimeCounter.start();
        animationTimer.start();
    }

    /**
     * Method to load new Sudoku values in labels
     */

    private void startRound() {
        int size = sudokuGridPane.getChildren().size();
        Label label = null;
        if (sudokuGridPane != null && size > 1) {
            //for each loops to check every label
            for (Node node : sudokuGridPane.getChildren()) {

                if (!(node.getClass() == Group.class)) {
                    label = (Label) node;
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
        finishedBoard.setCompletedBoard(puzzleBoard.getBoardArray());
        log.info("\nBoard successfully set to: \n" + finishedBoard);
    }

    /**
     * Method is setting labels when startGame button is clicked
     */
    public void setLabels() {
        log.info("Setting labels on GUI ...");
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
                //Mouse clicked is implicitly implemented to mark the selected label
                label.setOnMouseClicked(event -> {
                    Label label1 = (Label) event.getSource();
                    lblSelected = label1;

                    if (lblLastSelected != null)
                        lblLastSelected.setBackground(null);
                    lblLastSelected = label1;
                    label1.setBackground(blue);
                });
                if (sudokuGridPane != null) {
                    sudokuGridPane.add(label, i, j);
                }
            }
        }
        log.info("Labels have been set successfully.");
    }

    /**
     * Method to return the row and col of a labelId
     * @param labelId id of the selected label
     * @return position of row and col
     */
    public Position getRowCol(String labelId) {
        char rowChar = labelId.charAt(6);
        char colChar = labelId.charAt(8);

        Position position = new Position();

        position.row = Integer.parseInt(String.valueOf(rowChar));
        position.col = Integer.parseInt(String.valueOf(colChar));

        return position;
    }

    /**
     * This method compares the input with the solutionBoard
     * If input is false, the label turns red and counts one mistake
     *
     * @param value
     * @return boolean
     */
    private boolean checkInput(int value, Position position) {

        int valueSolved = solutionBoard.getNumberAtIdx(position.col, position.row);
        if (value == valueSolved) {
            lblSelected.setBackground(white);
            return true;
        }

        wrongInput();
        wrongValue = true;

        if (count < 2) {
            count++;
            lblCounter.setText("Wrong input counter: " + count + "/3");
            //readWrite.removeEntries(COUNTER_URL);
        } else {
            lblCounter.setText("Wrong input counter: 3/3");
            display("YOU LOST");
            count = 0;
            lblCounter.setText("Wrong input counter: " + count + "/3");
            log.info("de.sudoku.Game lost");
        }
        return false;
    }


    private void switchToHome() {
        if (!restartGame) {
            URL fxmlFileUrl = getClass().getClassLoader().getResource(HOME_FXML);
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(fxmlFileUrl);
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Main.getMainWindow().setScene(scene);
                Main.getMainWindow().show();
            } catch (IOException e) {
                log.error(e.getStackTrace() + "Stage can't be loaded");
            }
        }
    }

    /**
     * to show a new window
     * @param status if you won or lost
     */
    private void display(String status) {

        TimeCounter.setIsRunning(false);

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        window.setMinWidth(200);
        window.setMinHeight(200);

        Label label1 = new Label();
        label1.setText(status);
        Button restartButton = new Button("restart Game");
        restartButton.setStyle("-fx-text-fill: white; -fx-background-color: #194e70;");

        restartButton.setOnMouseEntered(t -> restartButton.setStyle("-fx-text-fill: white; -fx-background-color: #abdbe7;"));

        restartButton.setOnMouseExited(t -> restartButton.setStyle("-fx-text-fill: white; -fx-background-color: #194e70;"));

        restartButton.setOnAction(event -> {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            restartGame = true;
            if (!labelAreInitialized) {
                setLabels();
                labelAreInitialized = true;
            }
            TimeCounter = new TimeCounter();
            TimeCounter.setIsRunning(true);
            TimeCounter.start();
            log.info("restart Game");
        });

        Button homeButton = new Button("Home");
        homeButton.setStyle("-fx-background-color: #194e70; -fx-text-fill: white; ");

        homeButton.setOnMouseEntered(f -> homeButton.setStyle("-fx-text-fill: white; -fx-background-color:#abdbe7"));

        homeButton.setOnMouseExited(f -> homeButton.setStyle("-fx-text-fill: white; -fx-background-color:#194e70;"));

        homeButton.setOnAction(event -> {
            window.close();
            restartGame = false;
            switchToHome();
            TimeCounter.setIsRunning(false);
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
    protected void btnResetGame() {
        if (!labelAreInitialized) {
            this.setLabels();
            labelAreInitialized = true;
        }
        count = 0;

        lblCounter.setText("Wrong input counter: " + count + "/3");

        startRound();

        TimeCounter.setIsRunning(false);
        TimeCounter = new TimeCounter();
        TimeCounter.setIsRunning(true);
        TimeCounter.start();
    }

    @FXML
    protected void btnBackToMenu(ActionEvent event) {
        loadNewScene(event, HOME_FXML);
        TimeCounter.setIsRunning(false);
    }

    /**
     * Button for input 1 to 9
     */

    @FXML
    protected void btnInput(ActionEvent event) {

        Button activeButton = (Button) event.getSource();
        btnNumberPressed = activeButton;

        try {
            //get pressed value
            Position position = getRowCol(lblSelected.getId());
            String id = btnNumberPressed.getId();
            char choiceChar = id.charAt(7);
            int choiceInt = Integer.parseInt(String.valueOf(choiceChar));
            String choiceString = String.valueOf(choiceChar);

            if (this.lblSelected != null)
                this.lblSelected.setText(choiceString);
            checkInput(choiceInt, position);

            //to check the user input after the game is finished
            finishedBoard.setValueInBoard(position.col, position.row, choiceInt);
            log.info("\nBoard after last user input: \n" + finishedBoard);

        } catch (NullPointerException e) {
            log.error("No selected Label" + e.getStackTrace());
        }

        if (!(finishedBoard.checkIfFinished())) {
            if (finishedBoard.checkWinning()) {
                display("YOU WON");
                log.info("Game won");
                //Label shows how many games have been solved by using writer
                readWrite.write(1, COUNTER_URL);

            } else {
                display("YOU LOST");
                log.info("Game lost");
                log.error("Too many wrong inputs");
            }
        }
    }

    /**
     * delete last input
     */

    @FXML
    protected void btnBackPressed() {
        if (this.lblSelected != null) {
            Position position = getRowCol(lblSelected.getId());
            lblSelected.setBackground(white);
            lblSelected.setText(null);
            finishedBoard.setValueInBoard(position.col, position.row, 0);
            log.info(finishedBoard);
            log.info("Number has been deleted");
        } else {
            log.info("no selected Label");
        }
    }

    /**
     * wrong input, red Background
     */
    @FXML
    private void wrongInput() {
        lblSelected.setBackground(pink);
        log.info("Wrong input");
    }

    /**
     * new class to enable input of labelId and output of col & row in method getRowCol
     */
    public class Position {
        public int row = 0;
        public int col = 0;
    }

}
