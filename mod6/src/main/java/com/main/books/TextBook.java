package com.main.books;

public class TextBook extends Book {
    private int duration;

    public TextBook(String bookId, String title, String author, String category, int stock, int duration) {
        super(bookId, title, author, stock);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
