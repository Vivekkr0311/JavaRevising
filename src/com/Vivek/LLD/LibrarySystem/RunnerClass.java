package com.Vivek.LLD.LibrarySystem;

import com.Vivek.LLD.LibrarySystem.Library.Library;
import com.Vivek.LLD.LibrarySystem.classes.Books.FictionBook;
import com.Vivek.LLD.LibrarySystem.classes.Books.NonFictionBook;
import com.Vivek.LLD.LibrarySystem.classes.Books.ReferenceBook;
import com.Vivek.LLD.LibrarySystem.interfaces.Books;

public class RunnerClass {
    public static void main(String[] args) {
        Library library = new Library();
        Books fictionalBook = new FictionBook("fiction1", "author1");
        Books nonFictionalBook = new NonFictionBook("fiction2", "author2");
        Books referenceBook = new ReferenceBook("fiction3", "author3");

        library.addBook(fictionalBook);
        library.addBook(nonFictionalBook);
        library.addBook(referenceBook);


        library.displayAllBooks();
    }
}
