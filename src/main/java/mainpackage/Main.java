package mainpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.Objects;

public class Main extends Application {

    static Board board = Board.getInstance();

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL fxmlFileUrl = getClass().getClassLoader().getResource("sample.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));
        primaryStage.setTitle("Very cool Sudoku");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();


        // BSP Brett
        board.setBrett(0,0, 1);
        board.setBrett(0,1,2);
        board.setBrett(0,2,3);
        board.setBrett(0,3,4);
        board.setBrett(0,4,5);
        board.setBrett(0,5,6);
        board.setBrett(0,6,7);
        board.setBrett(0,7,8);
        board.setBrett(0,8,9);

        board.setBrett(0,0, 1);
        board.setBrett(1,0,2);
        board.setBrett(2,0,3);
        board.setBrett(3,0,4);
        board.setBrett(4,0,5);
        board.setBrett(5,0,6);
        board.setBrett(6,0,7);
        board.setBrett(7,0,8);
        board.setBrett(8,0,9);

        board.setBrett(6,1, 1);
        board.setBrett(7,1,2);
        board.setBrett(8,1,3);
        board.setBrett(6,2,4);
        board.setBrett(7,2,5);
        board.setBrett(8,2,6);
        board.setBrett(6,3,7);
        board.setBrett(7,3,8);
        board.setBrett(8,3,9);


        board.setBrett(1,5,2);

        startRound();


    }

    public void startRound() {
        System.out.println(board.toString());

        board.checkWinning();
    }

    public static void main(String[] args) {
        launch(args);
    }
}