module SE2StartupProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;
    //requires log4j;

    opens de.sudoku.game to javafx.controls, javafx.fxml, javafx.graphics, org.apache.logging.log4j;
    opens de.sudoku.controller to javafx.controls, javafx.fxml, javafx.graphics, org.apache.logging.log4j;
}
