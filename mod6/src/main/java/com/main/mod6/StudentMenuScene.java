package com.main.mod6;

import com.main.data.Student;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentMenuScene {

    public static Scene getScene(Stage stage, Student student) {
        VBox studentMenu = new VBox();
        Label label = new Label("Student Menu");
        Button displayInfoButton = new Button("Display Personal Information");
        Button displayBooksButton = new Button("Display Available Books");
        Button showBorrowedBooksButton = new Button("Show Borrowed Books");
        Button returnBooksButton = new Button("Return Books");
        Button logoutButton = new Button("Logout");

        displayInfoButton.setOnAction(e -> student.displayInfo());
        displayBooksButton.setOnAction(e -> student.choiceBook());
        showBorrowedBooksButton.setOnAction(e -> student.showBorrowedBooks());
        returnBooksButton.setOnAction(e -> student.returnBooks());
        logoutButton.setOnAction(e -> student.logout());

        studentMenu.getChildren().addAll(label, displayInfoButton, displayBooksButton, showBorrowedBooksButton, returnBooksButton, logoutButton);
        return new Scene(studentMenu, 300, 200);
    }
}