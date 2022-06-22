package Game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Objects;

public class Main extends Application{

    public static Stage getMainWindow() {
        return mainWindow;
    }

    static Stage mainWindow;

    /**
     * Sets up starting screen of the game
     * @param primaryStage
     * @throws Exception
     */
    String startGame = "startgame.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        // JavaFX stuff
        URL fxmlFileUrl = getClass().getClassLoader().getResource(startGame);
        Parent root = FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));
        primaryStage.setTitle("Sudoku");
        Scene myScene = new Scene(root, 600, 400);
        primaryStage.setScene(myScene);
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);


        mainWindow = primaryStage;
        mainWindow.setTitle("Sudoku");
        mainWindow.show();

        mainWindow.setOnCloseRequest(windowEvent -> {
            Platform.exit();
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch(args); // calls start-method
    }
}