package com.tasktracker;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TaskManagerGUI {

    public static void display() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Task Manager");

        // Create a VBox to hold all UI elements
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        // Create a ListView to display tasks
        ListView<String> taskListView = new ListView<>();
        taskListView.setPrefHeight(300);

        // Create a TextField for task input
        TextField taskInput = new TextField();
        taskInput.setPromptText("Enter a new task");

        // Create a Button to add tasks
        Button addButton = new Button("Add Task");
        addButton.setOnAction(e -> {
            String task = taskInput.getText();
            if (!task.isEmpty()) {
                taskListView.getItems().add(task);
                taskInput.clear();
            }
        });

        // Create a Button to remove selected tasks
        Button removeButton = new Button("Remove Selected");
        removeButton.setOnAction(e -> {
            int selectedIndex = taskListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                taskListView.getItems().remove(selectedIndex);
            }
        });

        // Add UI elements to the VBox
        root.getChildren().addAll(taskListView, taskInput, addButton, removeButton);

        // Create the scene and set it to the stage
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
