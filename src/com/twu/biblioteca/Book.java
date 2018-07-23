package com.twu.biblioteca;

public class Book extends LibraryItem {

    Book(int id, String title, String author, int pubDate, boolean availability){
        this.id = id;
        this.title = title;
        this.creator = author;
        this.pubDate = pubDate;
        this.availability = availability;
    }
    
}
