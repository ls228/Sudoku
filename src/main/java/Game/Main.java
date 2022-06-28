package Game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Objects;

public class Main extends Application{

    private static final Logger log = LogManager.getLogger(Main.class);
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

        //log4j
        //org.apache.log4j.BasicConfigurator.configure();
        //Logger.getRootLogger().setLevel(Level.DEBUG);

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
        log.info(LocalDateTime.now()+": Scene loaded successfully");

        mainWindow.setOnCloseRequest(windowEvent -> {
            Platform.exit();
            System.exit(0);
            log.info("Scene closed successfully");
        });

    }

    public static void main(String[] args) {
        launch(args); // calls start-method
    }
}