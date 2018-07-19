package com.twu.biblioteca;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class LibraryTest {
    private Library testLibrary = new Library();

    @Test
    public void shouldCreateEmptyBookList() {
        assertTrue(testLibrary.bookList.isEmpty());
    }

    @Test
    @Ignore
    public void shouldShowBookDetails() {
        // implement me
    }

}
