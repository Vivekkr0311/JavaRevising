package com.Vivek.LLD.LibrarySystem.interfaces;

import java.util.UUID;

public class Books {
    private String bookId;
    private String title;
    private String author;
    private boolean isIssued;
    private String bookIssuedTo;

    public Books(String title, String author) {
        this.bookId = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.isIssued = false;
        this.bookIssuedTo = null;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public String getBookIssuedTo() {
        return bookIssuedTo;
    }

    public void setBookIssuedTo(String bookIssuedTo) {
        this.bookIssuedTo = bookIssuedTo;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isIssued=" + isIssued +
                ", bookIssuedTo='" + bookIssuedTo + '\'' +
                '}';
    }
}