package com.twu.biblioteca;

public class LibraryItem {
    String title, creator;
    int pubDate, id;
    boolean availability;

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
