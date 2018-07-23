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

public class MovieTest {
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    private Movie testMovie;
    @Before
    public void createTestMovie(){
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        Movie movie = new Movie(1, "Hush", "Mr. Spook", 2008, "5", true);
        testMovie = movie;
    }

    @Test
    public void movieShouldHaveATitle(){
        assertNotEquals(testMovie.title, "Nope");
        assertEquals(testMovie.title, "Hush");
    }

    @Test
    public void movieShouldHaveADirector(){
        assertNotEquals(testMovie.creator, "Salinger, J.D.");
        assertEquals(testMovie.creator, "Mr.Spook");
    }

    @Test
    public void movieShouldAPublicationDate(){
        assertNotEquals(testMovie.pubDate, 1993);
        assertEquals(testMovie.pubDate, 2008);
    }

    @Test
    public void movieShouldBeAvailableOrUnavailable(){
        testMovie.toggleAvail();
        assertEquals(false, testMovie.isAvailable());
        testMovie.toggleAvail();
        assertTrue(testMovie.availability);
    }

    @Test
    public void printDetailsShouldPrintTitleDateAuthorRating() {
        System.setOut(printStream);
        testMovie.printDetails();
        verify(printStream).println("Hush | Mr. Spook | 2008 | 5");
    }

}