package com.Vivek.LLD.LibrarySystem.Library;

import com.Vivek.LLD.LibrarySystem.classes.Members.Member;
import com.Vivek.LLD.LibrarySystem.interfaces.Books;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Books> booksList;
    private List<Member> members;

    public Library() {
        this.booksList = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addMember(Member newMember) {
        this.members.add(newMember);
    }

    public void addBook(Books newBook) {
        this.booksList.add(newBook);
    }

    public void displayAllBooks() {
        for (Books books : booksList) {
            System.out.println(books);
        }
    }

    public void findStatusOfBook(String bookId) {
        Books book = null;
        for (Books books : booksList) {
            if (books.getBookId().equals(bookId)) {
                book = books;
                break;
            }
        }

        if (book == null) {
            System.out.println("Book does not exist");
        } else {
            System.out.println(book);
        }
    }
}
