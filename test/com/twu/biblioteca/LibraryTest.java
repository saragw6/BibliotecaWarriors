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
    @Ignore
    public void setUp() throws Exception {
        testBookList = new ArrayList();
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        testLibrary = new Library(testBookList, printStream, bufferedReader);
    }

    @Test
    @Ignore
    public void shouldPrintNothingWhenThereAreNoBooks() {
        System.setOut(printStream);
        testLibrary.listBooks();
        verify(printStream).println("");
    }

    @Test
    @Ignore
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        String title = "Book Title";
        System.setOut(printStream);
        testLibrary.listBooks();
        verify(printStream).println(title + "\n");
    }


    @Test
    @Ignore
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        String title = "Book Title";
        String title2 = "Book Title 2";
        System.setOut(printStream);
        testLibrary.listBooks();
        verify(printStream).println(title + "\n" + title2 + "\n");
    }
}
