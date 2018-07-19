package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class BookTest {

    private Book testBook;
    @Before
    public void createTestBook(){
        Book book = new Book(1, "Harry Potter and the Prisoner of Azkaban", "Rowling, J.K.", 1996, true);
        testBook = book;
    }

    @Test
    public void bookShouldHaveATitle(){
        assertNotEquals(testBook.title, "Nope");
        assertEquals(testBook.title, "Harry Potter and the Prisoner of Azkaban");
    }

    @Test
    public void bookShouldHaveAnAuthor(){
        assertNotEquals(testBook.author, "Salinger, J.D.");
        assertEquals(testBook.author, "Rowling, J.K.");
    }

    @Test
    public void bookShouldAPublicationDate(){
        assertNotEquals(testBook.pubDate, 1993);
        assertEquals(testBook.pubDate, 1996);
    }

    @Test
    public void bookShouldBeAvailableOrUnavailable(){
        assertTrue(testBook.availability);
    }

    @Test
    public void bookShouldHaveAnID(){
        assertEquals(testBook.id, 1);
    }

}
