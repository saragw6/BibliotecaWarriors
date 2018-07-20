package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;



public class LibraryTest {
    private ArrayList<Book> testBookList;
    private Library testLibrary;

    private Printer printer;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() {
        testBookList = new ArrayList<Book>();
        printStream = mock(PrintStream.class);
        printer = new Printer(printStream);
        bufferedReader = mock(BufferedReader.class);
        testLibrary = new Library(testBookList, printStream, bufferedReader);
        System.setOut(printStream);
    }
    
    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        testLibrary.listBooks();
        verify(printStream).print("");
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        Book testBook = new Book(1, "Flowers for Algernon", "Daniel Keyes", 1959, true);

        testLibrary.addBook(testBook);
        testLibrary.listBooks();

        verify(printStream).println(testBook.id + " | " + testBook.title + " | " + testBook.author + " | " + testBook.pubDate);
    }


    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        Book bookTwo = new Book(2, "Modern Romance", "Aziz Ansari", 2015, true);
        Book bookOne = new Book(1, "Flowers for Algernon", "Daniel Keyes", 1959, true);

        testLibrary.addBook(bookOne);
        testLibrary.addBook(bookTwo);

        testLibrary.listBooks();
        verify(printStream).println(bookOne.id + " | " + bookOne.title + " | " + bookOne.author + " | " + bookOne.pubDate);
        verify(printStream).println(bookTwo.id + " | " + bookTwo.title + " | " + bookTwo.author + " | " + bookTwo.pubDate);

    }

    @Test
    public void bookNotInLibrary(){
        Book bookOne = new Book(1, "Flowers for Algernon", "Daniel Keyes", 1959, true);
        assertFalse(testLibrary.getBookList().contains(bookOne));
    }

    @Test
    public void bookInLibrary(){
        Book bookOne = new Book(1, "Flowers for Algernon", "Daniel Keyes", 1959, true);
        testLibrary.addBook(bookOne);
        assertTrue(testLibrary.getBookList().contains(bookOne));
    }

    @Test
    public void correctBookCheckedOut() {
        Book bookOne = new Book(1, "Flowers for Algernon", "Daniel Keyes", 1959, true);
        testLibrary.addBook(bookOne);
        testLibrary.checkoutById(1);
        verify(printStream).println("Thank you! Enjoy the book.");
    }

    @Test
    public void unsuccessfulCheckoutByUnavailableBook() {
        Book bookOne = new Book(1, "Flowers for Algernon", "Daniel Keyes", 1959, false);
        testLibrary.addBook(bookOne);
        testLibrary.checkoutById(1);
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void unsuccessfulCheckoutByDoesNotExist() {
        testLibrary.checkoutById(10);
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void correctBookReturned(){
        Book bookOne = new Book(1, "Flowers for Algernon", "Daniel Keyes", 1959, false);
        testLibrary.addBook(bookOne);
        testLibrary.returnById(1);
        verify(printStream).println("Thank you for returning the book.");

    }

    @Test
    public void unsuccessfulReturnByAvailableBook(){
        Book bookOne = new Book(1, "Flowers for Algernon", "Daniel Keyes", 1959, true);
        testLibrary.addBook(bookOne);
        testLibrary.returnById(1);
        verify(printStream).println("That is not a valid book to return.");
    }

    @Test
    public void unsuccessfulReturnByDoesNotExist(){
        testLibrary.returnById(10);
        verify(printStream).println("That is not a valid book to return.");

    }

    @Test
    public void printOnlyAvailBooks() {
        Book bookOne = new Book(1, "Flowers for Algernon", "Daniel Keyes", 1959, false);
        testLibrary.addBook(bookOne);
        Book bookTwo = new Book(2, "Modern Romance", "Aziz Ansari", 2015, true);
        testLibrary.addBook(bookTwo);
        testLibrary.listBooks();
        verify(printStream).println(bookTwo.id + " | " + bookTwo.title + " | " + bookTwo.author + " | " + bookTwo.pubDate);
    }
}
