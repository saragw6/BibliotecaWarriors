package com.twu.biblioteca;

public class LibraryItem {
    String title, creator, id;
    int pubDate;
    boolean availability;
    String ownerID = null;

    

    public void toggleAvail() {
        availability = !availability;
    }

    public boolean isAvailable() {
        return availability;
    }

    public String getID() {
        return id;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

}
