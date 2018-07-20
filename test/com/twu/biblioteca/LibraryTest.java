package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;



public class LibraryTest {
    private ArrayList<Book> testBookList;
    private Library testLibrary;

    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() {
        testBookList = new ArrayList<Book>();
        printStream = mock(PrintStream.class);
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

        verify(printStream).println(testBook.title + " | " + testBook.author + " | " + testBook.pubDate);
    }


    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        Book bookTwo = new Book(2, "Modern Romance", "Aziz Ansari", 2015, true);
        Book bookOne = new Book(1, "Flowers for Algernon", "Daniel Keyes", 1959, true);

        testLibrary.addBook(bookOne);
        testLibrary.addBook(bookTwo);

        testLibrary.listBooks();
        verify(printStream).println(bookOne.title + " | " + bookOne.author + " | " + bookOne.pubDate);
        verify(printStream).println(bookTwo.title + " | " + bookTwo.author + " | " + bookTwo.pubDate);

    }

    @Test
    public void correctBookCheckedOut() {
        Book bookOne = new Book(1, "Flowers for Algernon", "Daniel Keyes", 1959, true);
        testLibrary.addBook(bookOne);
        Book userBook = testLibrary.getBookList().get(0);
        Book checkedoutBook = testLibrary.checkoutById(userBook.getID());
        assertEquals(userBook.getID(), checkedoutBook.getID());

    }

    @Test
    public void unsuccessfulCheckoutByUnavailableBook() {
        Book bookOne = new Book(1, "Flowers for Algernon", "Daniel Keyes", 1959, false);
        testLibrary.addBook(bookOne);
        Book userBook = testLibrary.getBookList().get(0);
        Book checkedOutBook = testLibrary.checkoutById(1);
        assertEquals(checkedOutBook,null);
    }

    @Test
    public void unsuccessfulCheckoutByDoesNotExist() {
        Book checkedOutBook = testLibrary.checkoutById(1);
        assertEquals(checkedOutBook,null);
    }

    @Test
    public void doNotPrintUnavailableBooks() {
        
    }
}
