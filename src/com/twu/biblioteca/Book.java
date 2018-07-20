package com.twu.biblioteca;

public class Book {

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

    public void toggleAvail() {
        availability = !availability;

    }

    public boolean isAvailable() {
        return availability;
    }

    public int getID() {
        return id;
    }
}
