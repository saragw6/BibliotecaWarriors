package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {

    private PrintStream printStream;
    private Scanner scanner;
    private BibliotecaApp app;

    @Before
    public void setUp(){
        app = new BibliotecaApp();
        printStream = mock(PrintStream.class);
        scanner = mock(Scanner.class);
    }
    @Test
    public void listBooksTest(){
        app.main(null);
        when(scanner.nextLine()).thenReturn("list books");
        verify(printStream).print("");


    }



}