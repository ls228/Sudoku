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
        URL fxmlFileUrl = getClass().getClassLoader().getResource("Scenebuilder.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));
        primaryStage.setTitle("Very cool Sudoku");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Games games=new Games();

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