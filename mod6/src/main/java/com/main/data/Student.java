package com.main.data;

import com.main.LibrarySystem;
import com.main.books.Book;
import com.main.util.iMenu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student implements iMenu {
    private String nim;
    private String name;
    private String faculty;
    private String programStudi;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Student(String nim, String name, String faculty, String programStudi) {
        this.nim = nim;
        this.name = name;
        this.faculty = faculty;
        this.programStudi = programStudi;
        this.borrowedBooks = new ArrayList<>();
        StudentDatabase.addStudent(this);
    }

    public Student(String studentName) {
        this.name = studentName;
    }

    public void displayInfo() {
        System.out.println("Student Information:");
        System.out.println("Name: " + name);
        System.out.println("Faculty: " + faculty);
        System.out.println("NIM: " + nim);
    }

    public void showBorrowedBooks() {
        if (borrowedBooks.size() == 0) {
            System.out.println("No books currently borrowed.");
        } else {
            System.out.println("Borrowed Books:");
            for (Book book : borrowedBooks) {
                System.out.println(book.getTitle());
            }
        }
    }

    public void logout() {
        if (borrowedBooks.size() == 0) {
            System.out.println("No books borrowed. Logging out. Goodbye, " + name + "!");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want to return books? (yes/no)");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("yes")) {
                for (Book book : borrowedBooks) {
                    book.returnBook();
                }
                borrowedBooks.clear();
                System.out.println("Books returned. Logging out. Goodbye, " + name + "!");
            } else {
                System.out.println("Returning to main menu. Goodbye, " + name + "!");
            }
        }
        System.exit(0);
    }

    public void choiceBook() {
        System.out.println("List of Available Books:");
        System.out.printf("%-5s%-30s%-17s%-10s%-5s\n", "ID", "Title", "Author", "Category", "Stock");
        for (Book book : LibrarySystem.getBookList()) {
            System.out.println(book.getBookId() + "\t" + book.getTitle() + "\t" + book.getAuthor() + "\t"
                    + book.getCategory() + "\t" + book.getStock());
        }
    }

    public void returnBooks() {
        if (borrowedBooks.size() == 0) {
            System.out.println("No books to return.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Borrowed Books:");
        for (int i = 0; i < borrowedBooks.size(); i++) {
            Book book = borrowedBooks.get(i);
            System.out.println((i + 1) + ". " + book.getTitle());
        }

        System.out.print("Enter the number of the book to return: ");
        int bookIndex = scanner.nextInt();

        if (bookIndex > 0 && bookIndex <= borrowedBooks.size()) {
            Book bookToReturn = borrowedBooks.get(bookIndex - 1);
            bookToReturn.returnBook();
            borrowedBooks.remove(bookToReturn);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Invalid choice. No book returned.");
        }
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Student Menu");
                System.out.println("1. Display Personal Information");
                System.out.println("2. Display Available Books");
                System.out.println("3. Show Borrowed Books");
                System.out.println("4. Return Books");
                System.out.println("5. Logout");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        displayInfo();
                        break;
                    case 2:
                        choiceBook();
                        break;
                    case 3:
                        showBorrowedBooks();
                        break;
                    case 4:
                        returnBooks();
                        break;
                    case 5:
                        logout();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("input tidak valid");
                scanner.next(); // clear the invalid input
            } catch (Exception e) {
                System.out.println("terjadi kesalahan. coba lagi");
            }
        }
    }

    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getProgramStudi() {
        return programStudi;
    }
}
