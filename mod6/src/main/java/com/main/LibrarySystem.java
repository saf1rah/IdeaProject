package com.main;

import com.main.books.Book;
import com.main.books.HistoryBook;
import com.main.books.TextBook;
import com.main.data.Admin;
import com.main.data.Student;
import com.main.mod6.AdminLoginScene;
import com.main.mod6.MainMenuScene;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem extends Application {
    private static ArrayList<Book> bookList = new ArrayList<>();
    private static Admin admin;
    private static Student student;
    private static ArrayList<Student> userStudents = new ArrayList<>();
    private static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        bookList.add(new HistoryBook("1", "resep kue", "ira", "Food", 100000000, 7));
        bookList.add(new TextBook("2", "kucing gemas", "firah", "Love", 1000000, 10));
        userStudents.add(new Student("199", "safirah", "Engineering", "Informatics"));
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library System");
        primaryStage.setScene(MainMenuScene.getScene(primaryStage));
        primaryStage.show();
    }

    public static Admin getAdmin() {
        return admin;
    }

    public static Student getStudent() {
        return student;
    }

    public static ArrayList<Book> getBookList() {
        return bookList;
    }

    public static List<Student> getStudentList() {
        return userStudents;
    }

    public static void addStudent(Student student) {
        userStudents.add(student);
    }

    public static void addBook(Book book) {
        bookList.add(book);
    }

    public static Student getStudentByName(String name) {
        for (Student student : userStudents) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }
}
