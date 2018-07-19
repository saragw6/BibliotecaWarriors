package com.twu.biblioteca;

import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;



public class LibraryTest {
    private ArrayList testBookList;
    private Library testLibrary;

    private PrintStream printStream;
    private BufferedReader bufferedReader;


    @Test
    @Ignore
    public void shouldShowBookDetails() {
        // implement me

    }

    @Test
    public void setUp() throws Exception {
        testBookList = new ArrayList();
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        testLibrary = new Library(testBookList, printStream, bufferedReader);
    }


    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        System.setOut(printStream);
        testLibrary.listBooks();
        verify(printStream).println("");
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        Book testBook = new Book(1, "Flowers for Algernon", "Daniel Keyes"., 1959);
        testLibrary.addBook(testBook);

        System.setOut(printStream);
        testLibrary.listBooks();
        verify(printStream).println(testBook.title + " | " + testBook.author + " | " + testBook.pubDate);
    }


    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        Book bookTwo = new Book(2, "Modern Romance", "Aziz Ansari", 2015);
        Book bookOne = new Book(1, "Flowers for Algernon", "Daniel Keyes"., 1959);
        testLibrary.addBook(bookOne);
        testLibrary.addBook(bookTwo);

        System.setOut(printStream);
        testLibrary.listBooks();
        verify(printStream).println(bookOne.title + " | " + bookOne.author + " | " + bookOne.pubDate);
        verify(printStream).println(bookTwo.title + " | " + bookTwo.author + " | " + bookTwo.pubDate);
}
