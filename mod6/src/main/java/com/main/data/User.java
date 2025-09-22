package com.main.data;

import com.main.books.Book;

import java.util.ArrayList;

public class User {
    private static ArrayList<Book> bookList = new ArrayList<>();

    public void displayBooks() {
        System.out.println("List Buku tersedia:");
        System.out.printf("%-10s%-50s%-27s%-20s%-10s\n", "ID", "Title", "Author", "Category", "Stock");
        for (Book book : bookList) {
            System.out.println(book.getBookId() + "\t" + book.getTitle() + "\t" + book.getAuthor() + "\t"
                    + book.getCategory() + "\t" + book.getStock());
        }
    }

    public static void addBook(Book book) {
        bookList.add(book); // Menambahkan buku ke dalam bookList
        System.out.println("Book added successfully!");
    }

    public static Book[] getBookList() {
        return bookList.toArray(new Book[0]);
    }
}
