package com.twu.biblioteca;

public class Movie extends LibraryItem {

    String rating;

    Movie(String id, String title, String author, int pubDate, String rating, boolean availability){
        this.id = id;
        this.title = title;
        this.creator = author;
        this.pubDate = pubDate;
        this.rating = rating;
        this.availability = availability;
    }

    @Override
    public String toString() {
        return this.id + " | " + this.title + " | " + this.creator + " | " + this.pubDate + " | " + this.rating;
    }

}
