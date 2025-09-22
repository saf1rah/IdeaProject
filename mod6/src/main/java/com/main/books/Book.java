package com.main.books;

import com.main.data.Student;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private int stock;

    public Book(String bookId, String title, String author, int stock) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.stock = stock;
    }

    public void borrowBook(Student student, int days) {
        if (stock > 0) {
            stock--;
            System.out.println("Book " + title + " borrowed by " + student.getName() + " for " + days + " days.");
        } else {
            System.out.println("Book " + title + " is out of stock.");
        }
    }

    public void returnBook() {
        stock++;
    }

    public String getBookId() {
        return bookId;
    }

    public Object getTitle() {
        return title;
    }

    public Object getCategory() {
        return category;
    }

    public Object getStock() {
        return stock;
    }

    public Object getAuthor() {
        return author;
    }
}
