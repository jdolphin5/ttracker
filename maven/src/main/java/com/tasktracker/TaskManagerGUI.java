package com.tasktracker;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

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

        // Create an Edit Button
        Button editButton = new Button("Edit Selected");
        editButton.setOnAction(e -> {
            String selectedItem = taskListView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                openEditDialog(selectedItem, primaryStage);
            }
        });

        // Add UI elements to the VBox
        root.getChildren().addAll(taskListView, taskInput, addButton, removeButton, editButton);

        // Create the scene and set it to the stage
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private static void openEditDialog(String task, Window owner) {
        // Create a new stage for the edit dialog
        Stage editStage = new Stage();
        editStage.initModality(Modality.WINDOW_MODAL);
        editStage.initOwner(owner);
        editStage.initStyle(StageStyle.UTILITY);
        editStage.setTitle("Edit Task");
    
        // Create UI elements for editing
        Label startDateLabel = new Label("Start Date:");
        DatePicker startDatePicker = new DatePicker();
    
        Label startTimeLabel = new Label("Start Time:");
        TextField startTimeTextField = new TextField();
    
        Label endDateLabel = new Label("End Date:");
        DatePicker endDatePicker = new DatePicker();
    
        Label endTimeLabel = new Label("End Time:");
        TextField endTimeTextField = new TextField();
    
        Label detailsLabel = new Label("Details:");
        TextArea detailsTextArea = new TextArea();
    
        // Create a Save button to save the edited task
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            // Handle saving the edited task here
            // You can access the values from the fields and update the task
            // For example, retrieve values using startDatePicker.getValue(), startTimeTextField.getText(), etc.
            // Close the edit stage when done
            editStage.close();
        });
    
        // Create a layout for the edit dialog
        GridPane editRoot = new GridPane();
        editRoot.setHgap(10);
        editRoot.setVgap(10);
        editRoot.setPadding(new Insets(10));
        editRoot.addRow(0, startDateLabel, startDatePicker, startTimeLabel, startTimeTextField);
        editRoot.addRow(1, endDateLabel, endDatePicker, endTimeLabel, endTimeTextField);
        editRoot.addRow(2, detailsLabel, detailsTextArea);
        editRoot.add(saveButton, 1, 3);
    
        // Create the scene for the edit dialog
        Scene editScene = new Scene(editRoot, 400, 300);
        editStage.setScene(editScene);
    
        // Show the edit dialog
        editStage.showAndWait();
    }
    
}
