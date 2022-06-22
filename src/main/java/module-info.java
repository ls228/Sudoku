module SE2StartupProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires log4j;

    opens Game to javafx.controls, javafx.fxml, javafx.graphics;
    opens Controller to javafx.controls, javafx.fxml, javafx.graphics;
}
