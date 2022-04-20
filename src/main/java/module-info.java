module SE2StartupProject {
    requires javafx.controls;
    requires javafx.fxml;

    opens mainpackage to javafx.controls, javafx.graphics, javafx.fxml;
}
