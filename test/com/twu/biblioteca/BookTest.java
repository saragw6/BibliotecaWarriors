package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BookTest {
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    private Book testBook;
    @Before
    public void createTestBook(){
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        Book book = new Book("B1", "Harry Potter and the Prisoner of Azkaban", "Rowling, J.K.", 1996, true);
        testBook = book;
    }

    @Test
    public void bookShouldHaveATitle(){
        assertNotEquals(testBook.title, "Nope");
        assertEquals(testBook.title, "Harry Potter and the Prisoner of Azkaban");
    }

    @Test
    public void bookShouldHaveAnAuthor(){
        assertNotEquals(testBook.creator, "Salinger, J.D.");
        assertEquals(testBook.creator, "Rowling, J.K.");
    }

    @Test
    public void bookShouldAPublicationDate(){
        assertNotEquals(testBook.pubDate, 1993);
        assertEquals(testBook.pubDate, 1996);
    }

    @Test
    public void bookShouldBeAvailableOrUnavailable(){
        testBook.toggleAvail();
        assertEquals(false, testBook.isAvailable());
        testBook.toggleAvail();
        assertTrue(testBook.availability);
    }

    @Test
    public void bookShouldHaveAnID(){
        assertEquals(testBook.id, 1);
    }
    
}
