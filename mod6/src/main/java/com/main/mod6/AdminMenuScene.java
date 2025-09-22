package com.main.mod6;

import com.main.LibrarySystem;
import com.main.data.Admin;
import com.main.data.Student;
import com.main.books.Book;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminMenuScene {
    private Admin admin;
    private Scene scene;

    public AdminMenuScene(Stage stage) {
        this.admin = LibrarySystem.getAdmin();
        initialize(stage);
    }

    private void initialize(Stage stage) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        // Borrow Book
        GridPane borrowGrid = new GridPane();
        borrowGrid.setPadding(new Insets(10, 10, 10, 10));
        borrowGrid.setVgap(8);
        borrowGrid.setHgap(10);

        Label borrowLabel = new Label("Borrow Book:");
        GridPane.setConstraints(borrowLabel, 0, 0);

        TextField studentNameInput = new TextField();
        studentNameInput.setPromptText("Student Name");
        GridPane.setConstraints(studentNameInput, 1, 0);

        TextField bookIdInput = new TextField();
        bookIdInput.setPromptText("Book ID");
        GridPane.setConstraints(bookIdInput, 2, 0);

        TextField daysInput = new TextField();
        daysInput.setPromptText("Days");
        GridPane.setConstraints(daysInput, 3, 0);

        Button borrowButton = new Button("Borrow Book");
        GridPane.setConstraints(borrowButton, 4, 0);
        borrowButton.setOnAction(e -> {
            String studentName = studentNameInput.getText();
            String bookId = bookIdInput.getText();
            int days = Integer.parseInt(daysInput.getText());
            Student student = LibrarySystem.getStudentByName(studentName);
            if (student != null) {
                admin.borrowBook(student, bookId, days);
            } else {
                System.out.println("Student not found.");
            }
        });

        borrowGrid.getChildren().addAll(borrowLabel, studentNameInput, bookIdInput, daysInput, borrowButton);

        // Return Book
        GridPane returnGrid = new GridPane();
        returnGrid.setPadding(new Insets(10, 10, 10, 10));
        returnGrid.setVgap(8);
        returnGrid.setHgap(10);

        Label returnLabel = new Label("Return Book:");
        GridPane.setConstraints(returnLabel, 0, 1);

        TextField returnBookIdInput = new TextField();
        returnBookIdInput.setPromptText("Book ID");
        GridPane.setConstraints(returnBookIdInput, 1, 1);

        Button returnButton = new Button("Return Book");
        GridPane.setConstraints(returnButton, 2, 1);
        returnButton.setOnAction(e -> {
            String bookId = returnBookIdInput.getText();
            admin.returnBook(bookId);
        });

        returnGrid.getChildren().addAll(returnLabel, returnBookIdInput, returnButton);

        GridPane addBookGrid = new GridPane();
        addBookGrid.setPadding(new Insets(10, 10, 10, 10));
        addBookGrid.setVgap(8);
        addBookGrid.setHgap(10);

        Label addBookLabel = new Label("Add Book:");
        GridPane.setConstraints(addBookLabel, 0, 3);

        TextField bookTitleInput = new TextField();
        bookTitleInput.setPromptText("Book Title");
        GridPane.setConstraints(bookTitleInput, 1, 3);

        TextField bookIdInputNew = new TextField();
        bookIdInputNew.setPromptText("Book ID");
        GridPane.setConstraints(bookIdInputNew, 2, 3);

        TextField bookAuthorInput = new TextField();
        bookAuthorInput.setPromptText("Author");
        GridPane.setConstraints(bookAuthorInput, 3, 3);

        TextField bookPagesInput = new TextField();
        bookPagesInput.setPromptText("Number of Pages");
        GridPane.setConstraints(bookPagesInput, 4, 3);

        Button addBookButton = new Button("Add Book");
        GridPane.setConstraints(addBookButton, 5, 3);
        addBookButton.setOnAction(e -> {
            String title = bookTitleInput.getText();
            String bookId = bookIdInputNew.getText();
            String author = bookAuthorInput.getText();
            int numberOfPages = Integer.parseInt(bookPagesInput.getText());
            Book book = new Book(title, bookId, author, numberOfPages);
            LibrarySystem.addBook(book);
        });

        addBookGrid.getChildren().addAll(addBookLabel, bookTitleInput, bookIdInputNew, bookAuthorInput, bookPagesInput, addBookButton);

        // Add Student Section
        GridPane addStudentGrid = new GridPane();
        addStudentGrid.setPadding(new Insets(10, 10, 10, 10));
        addStudentGrid.setVgap(8);
        addStudentGrid.setHgap(10);

        Label addStudentLabel = new Label("Add Student:");
        GridPane.setConstraints(addStudentLabel, 0, 2);

        TextField studentNameInputNew = new TextField();
        studentNameInputNew.setPromptText("Student Name");
        GridPane.setConstraints(studentNameInputNew, 1, 2);

        TextField studentNimInput = new TextField();
        studentNimInput.setPromptText("NIM");
        GridPane.setConstraints(studentNimInput, 2, 2);

        Button addStudentButton = new Button("Add Student");
        GridPane.setConstraints(addStudentButton, 3, 2);
        addStudentButton.setOnAction(e -> {
            String name = studentNameInputNew.getText();
            String nim = studentNimInput.getText();
            Student student = new Student(name, nim, "Major", "Department");
            LibrarySystem.addStudent(student);
        });

        addStudentGrid.getChildren().addAll(addStudentLabel, studentNameInputNew, studentNimInput, addStudentButton);

        // Add Book

        // Display Students
        Label displayStudentsLabel = new Label("Students:");
        ListView<String> studentListView = new ListView<>();
        for (Student student : LibrarySystem.getStudentList()) {
            studentListView.getItems().add(student.getName() + " - " + student.getNim());
        }
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> stage.setScene(MainMenuScene.getScene(stage)));
        layout.getChildren().addAll(studentListView, borrowGrid, returnGrid, addStudentGrid, addBookGrid, displayStudentsLabel);

        scene = new Scene(layout, 800, 600);
    }

    public Scene getScene() {
        return scene;
    }
}
