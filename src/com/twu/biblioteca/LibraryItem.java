package com.twu.biblioteca;

public class LibraryItem {
    String title, creator, id;
    int pubDate;
    boolean availability;

    public void toggleAvail() {
        availability = !availability;
    }

    public boolean isAvailable() {
        return availability;
    }

    public String getID() {
        return id;
    }
}
