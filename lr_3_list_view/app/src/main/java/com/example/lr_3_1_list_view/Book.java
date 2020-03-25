package com.example.lr_3_1_list_view;

import java.io.Serializable;

public class Book implements Serializable {

    private int image;
    private String bookTitle;
    private String author;
    private String txt;

    public Book(int image, String bookTitle, String author, String txt) {
        this.image = image;
        this.bookTitle = bookTitle;
        this.author = author;
        this.txt = txt;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
