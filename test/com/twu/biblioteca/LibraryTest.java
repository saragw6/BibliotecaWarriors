package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
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
        verify(printStream).println(testBook.id + " | " + testBook.title + " | " + testBook.creator + " | " + testBook.pubDate);
    }


    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        Book bookTwo = new Book(2, "Modern Romance", "Aziz Ansari", 2015, true);
        Book bookOne = new Book(1, "Flowers for Algernon", "Daniel Keyes", 1959, true);

        testLibrary.addBook(bookOne);
        testLibrary.addBook(bookTwo);

        testLibrary.listBooks();
        verify(printStream).println(bookOne.id + " | " + bookOne.title + " | " + bookOne.creator + " | " + bookOne.pubDate);
        verify(printStream).println(bookTwo.id + " | " + bookTwo.title + " | " + bookTwo.creator + " | " + bookTwo.pubDate);

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
        verify(printStream).println(bookTwo.id + " | " + bookTwo.title + " | " + bookTwo.creator + " | " + bookTwo.pubDate);
    }

    /****************** Movie Tests ********************/

    @Test
    public void shouldPrintNothingWhenThereAreNoMovies() {
        testLibrary.listMovies();
        verify(printStream).print("");
    }

    @Test
    @Ignore
    public void shouldPrintMovieTitleWhenThereIsOneMovie() {
        Movie testMovie = new Movie(1, "Hush", "Mr. Spook", 2008, "5", true);

        testLibrary.addMovie(testMovie);
        testLibrary.listMovies();

        verify(printStream).println(testMovie.title + " | " + testMovie.creator + " | " + testMovie.pubDate + " | " + testMovie.rating);
    }


    @Test
    @Ignore
    public void shouldPrintBothMovieTitlesWhenThereAreTwoMovies() throws IOException {
        Movie movieTwo = new Movie(2, "Total Recall", "Arnold Schwarzneggar", 2015, "3", true);
        Movie movieOne = new Movie(1, "Hush", "Mr. Spook", 2008, "5", true);

        testLibrary.addMovie(movieOne);
        testLibrary.addMovie(movieTwo);

        testLibrary.listMovies();
        verify(printStream).println(movieOne.title + " | " + movieOne.creator + " | " + movieOne.pubDate + " | " + movieOne.rating);
        verify(printStream).println(movieTwo.title + " | " + movieTwo.creator + " | " + movieTwo.pubDate + " | " + movieTwo.rating);

    }

    @Test
    @Ignore
    public void correctMovieCheckedOut() {
        Movie movieOne = new Movie(1, "Cindarella Story", "Hillary Duff", 2003, "10", true);
        testLibrary.addBook(movieOne);
        Movie userMovie = testLibrary.getMovieList().get(0);
        Movie checkedoutMovie = testLibrary.checkoutById(userMovie.getID());
        assertEquals(userMovie.getID(), checkedoutMovie.getID());

    }

    @Test
    @Ignore
    public void unsuccessfulCheckoutByUnavailableMovie() {
        Movie movieOne = new Movie(1, "Cindarella Story", "Hillary Duff", 2003, "10", false);
        testLibrary.addMovie(movieOne);
        Movie userMovie = testLibrary.getMovieList().get(0);
        Movie checkedOutMovie = testLibrary.checkoutById(1);
        assertEquals(checkedOutMovie,null);
    }

    @Test
    @Ignore
    public void unsuccessfulCheckoutByDoesNotExist() {
        Movie checkedOutMovie = testLibrary.checkoutById(1);
        assertEquals(checkedOutMovie,null);
    }

    @Test
    @Ignore
    public void printOnlyAvailMovies() {
        Movie movieOne = new Movie(1, "Cindarella Story", "Hillary Duff", 2003, "10", false);
        testLibrary.addMovie(movieOne);
        Movie movieTwo = new Movie(2, "Total Recall", "Arnold Schwarzneggar", 2015, "3", true);
        testLibrary.addMovie(movieTwo);
        testLibrary.listBooks();
        verify(printStream).println(movieTwo.title + " | " + movieTwo.creator + " | " + movieTwo.pubDate + " | " + movieTwo.rating);
    }

}
