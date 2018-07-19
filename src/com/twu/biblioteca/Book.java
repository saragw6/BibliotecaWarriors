package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;

public class Book {
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    String title, author;
    int pubDate, id;
    boolean availability;
    Book(int id, String title, String author, int pubDate, boolean availability){
        this.id = id;
        this.title = title;
        this.author = author;
        this.pubDate = pubDate;
        this.availability = availability;
    }

    public void printDetails() {
        System.out.println(this.title + " | " + this.author + " | " + this.pubDate);
    }

    public void toggleAvail() {
        availability = !availability;

    }

    public boolean isAvailable() {
        return availability;
    }

    public Object getID() {
        return id;
    }
}
