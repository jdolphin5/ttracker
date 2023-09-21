/*
 * GitHub:          jdolphin5
 * Task Tracker App
 * Java version:    17.0.8
 * JavaFX Version:  17.0.8
 */

package com.tasktracker;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TaskManagerGUI.display(); // Call the GUI class
    }
}
