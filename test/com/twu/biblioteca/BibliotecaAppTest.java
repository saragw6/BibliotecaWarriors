package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    private PrintStream printStream;
    private Scanner scanner;
    private BibliotecaApp app;
    private Library library, testLibrary;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Book checkedOutBook;

    @Before
    public void setUp(){
        app = new BibliotecaApp();
        printStream = new PrintStream(outContent);
        System.setOut(printStream);
        library = mock (Library.class);
        testLibrary = app.createDefaultLibrary(printStream);
        checkedOutBook = new Book("B3", "The Sound and the Fury", "Faulkner, William", 1923, false);
        testLibrary.addItem(checkedOutBook);

    }

    @Test(expected = NoSuchElementException.class)
    public void listBooksTest() {
        ByteArrayInputStream input = new ByteArrayInputStream("list books".getBytes());
        System.setIn(input);


        app.main(null);
        verify(library, times(1)).listItems();

    }

    @Test
    public void checkoutTest() {
        library = app.createDefaultLibrary(printStream);
        String id = library.getCatalog().get(0).getID();
        ByteArrayInputStream input = new ByteArrayInputStream(id.getBytes());
        System.setIn(input);
        app.libraryFunctions(true, testLibrary, printStream);
        assertEquals("Type the ID of the book you would like to checkout:\nThank you! Enjoy the book.\n", outContent.toString());

    }

    @Test
    public void returnTest() {
        String id = checkedOutBook.getID();
        ByteArrayInputStream input = new ByteArrayInputStream(id.getBytes());
        System.setIn(input);
        app.libraryFunctions(false, testLibrary, printStream);

        assertEquals("Type the ID of the book you would like to return:\nThank you for returning the book.\n", outContent.toString());

    }

    @Test(expected = NoSuchElementException.class)
    public void invalidMenuOptions(){
        ByteArrayInputStream input = new ByteArrayInputStream("INVALID".getBytes());
        System.setIn(input);

        app.main(null);
        verify(printStream).println("Invalid Menu Option");
    }

    @Test
    public void quitTest(){
        ByteArrayInputStream input2 = new ByteArrayInputStream("quit".getBytes());
        System.setIn(input2);

        app.main(null);
        assertFalse(app.isRunning);
    }



}