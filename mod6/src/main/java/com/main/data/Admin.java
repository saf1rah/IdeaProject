package com.main.data;

import com.main.books.Book;
import com.main.exception.custom.IllegalAdminAccess;
import java.util.ArrayList;

public class Admin {
    private ArrayList<Book> bookList;

    public Admin(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public void borrowBook(Student student, String bookId, int days) {
        Book book = findBookById(bookId);
        if (book != null) {
            book.borrowBook(student, days);
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String bookId) {
        Book book = findBookById(bookId);
        if (book != null) {
            book.returnBook();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private Book findBookById(String bookId) {
        for (Book book : bookList) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    public void isAdmin(String username, String password) throws IllegalAdminAccess {
        if (!"admin".equals(username) || !"admin321".equals(password)) {
            throw new IllegalAdminAccess("Invalid credentials");
        }
    }
}
