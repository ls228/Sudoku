package mainpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SwitchingScenes extends Application {

    Stage window;
    static Scene scene1;
    static Scene scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage PrimaryStage) throws Exception {

        window = PrimaryStage;

        Label label1 = new Label("Welcome");

        //Button 1
        Button button1 = new Button("Go to scene 2");
        //button1.setScaleX(1);
        //button1.setScaleY(1);
        button1.setOnAction (e -> window.setScene(scene2));


        //Layout 1 - children are laid out in vertical column
        StackPane layout1 = new StackPane();
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 600, 600);

        //Button 2
        Button button2 = new Button("go back to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));

        //Button 3
        Button button3 = new Button("Exit");
        button3.setOnAction(e -> {
            boolean result = confirmBox("Sure?", "Are you sure you want to exit the game?");
        });

        //Layout 2
        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(button2, button3);
        scene2 = new Scene(layout2, 600, 600);

        window.setScene(scene1);
        window.setTitle("Title");
        window.show();

        display("Sudoku", "You won!");

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
    }


        public static void display(String title, String message) {
            Stage window = new Stage();

            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(title);
            window.setMinWidth(250);

           Label label = new Label();
           label.setText(message);


            VBox layout = new VBox(10);
            layout.getChildren().addAll(label);
            layout.setAlignment(Pos.CENTER);


            Scene scene =new Scene(layout);
            window.setScene(scene);
            window.show();
        }

    static boolean answer;

        public static boolean confirmBox(String title, String message) {
            Stage window = new Stage();

            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(title);
            window.setMinWidth(250);
            Label label = new Label();
            label.setText(message);


            Button yesButton = new Button("yes");
            Button noButton = new Button("No");

            yesButton.setOnAction(e -> {
                answer = true;
                window.setScene(scene1);
                //window.close();
            });

            noButton.setOnAction(e -> {
                answer = false;
                window.setScene(scene2);
                //window.close();
            });

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, yesButton, noButton);
            layout.setAlignment(Pos.CENTER);
            Scene scene =new Scene(layout);
            window.setScene(scene);
            window.showAndWait();

            return answer;
        }

        private void closeProgram(){
            Boolean answer = confirmBox("Exit", "Sure you want to exit?");
            if(answer)
                window.close();
        }
    }


