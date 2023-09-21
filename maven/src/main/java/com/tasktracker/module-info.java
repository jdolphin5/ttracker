module com.tasktracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.tasktracker to javafx.fxml;

    exports com.tasktracker;
}