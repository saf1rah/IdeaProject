package com.main.mod6;

import com.main.data.Student;
import com.main.data.StudentDatabase;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentLoginScene {

    public static Scene getScene(Stage stage) {
        VBox loginPane = new VBox();
        Label nimLabel = new Label("NIM:");
        TextField nimField = new TextField();
        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            String nim = nimField.getText();
            Student student = StudentDatabase.getStudentByNim(nim);
            if (student != null) {
                stage.setScene(StudentMenuScene.getScene(stage, student));
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Student not found. Please try again.");
                alert.show();
            }
        });


        loginPane.getChildren().addAll(nimLabel, nimField, loginButton);
        return new Scene(loginPane, 300, 200);
    }
}