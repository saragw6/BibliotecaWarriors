package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
    private Library library;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        app = new BibliotecaApp();
        printStream = new PrintStream(outContent);
        System.setOut(printStream);
        library = mock (Library.class);
    }

    @Test(expected = NoSuchElementException.class)
    public void listBooksTest() {
        ByteArrayInputStream input = new ByteArrayInputStream("list books".getBytes());
        System.setIn(input);


        app.main(null);
        verify(library, times(1)).listBooks();

    }

    @Test
    public void checkoutTest() {
        library = app.createDefaultLibrary(printStream);
        String id = Integer.toString(library.getBookList().get(0).getID());
        ByteArrayInputStream input = new ByteArrayInputStream(id.getBytes());
        System.setIn(input);
        app.libraryCheckout(library, printStream);
        assertEquals("Type the ID of the book you would like to checkout:\nThank you! Enjoy the book.\n", outContent.toString());


    }

    @Test(expected = NoSuchElementException.class)
    public void returnTest() {
        ByteArrayInputStream input = new ByteArrayInputStream("return".getBytes());
        System.setIn(input);

//        Library library = mock (Library.Libraryclass);
        app.main(null);
//        verify(library, times(1)).();

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