package com.twu.biblioteca;

public class Movie extends LibraryItem {

    String rating;

    Movie(int id, String title, String author, int pubDate, String rating, boolean availability){
        this.id = id;
        this.title = title;
        this.creator = author;
        this.pubDate = pubDate;
        this.rating = rating;
        this.availability = availability;
    }

    public void printDetails() {
        System.out.println(this.title + " | " + this.creator + " | " + this.pubDate + " | " + this.rating);
    }

}
