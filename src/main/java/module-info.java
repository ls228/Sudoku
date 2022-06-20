module SE2StartupProject {
    requires javafx.controls;
    requires javafx.fxml;

    opens Game to javafx.controls, javafx.fxml, javafx.graphics;
    opens Controller to javafx.controls, javafx.fxml, javafx.graphics;
}
