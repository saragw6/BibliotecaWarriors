package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> bookList;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public Library(ArrayList<Book> bookList, PrintStream printStream, BufferedReader bufferedRead) {
        this.bookList = bookList;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void addBook(Book book){
        bookList.add(book);
    }

    public void listBooks(){
        if(bookList.isEmpty()) System.out.print("");
        else {
            for(int i = 0; i < bookList.size(); i++){
                bookList.get(i).printDetails();
            }
        }
    }

    public ArrayList<Book> getBookList() {
        return this.bookList;
    }

    public Book checkoutById(int id) {
        for (Book book : this.bookList) {
            if (book.getID() == id) {
                return book;
            }
        }

        return null;
    }
}
