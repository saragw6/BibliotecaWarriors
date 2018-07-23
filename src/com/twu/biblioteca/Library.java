package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> bookList;
    private Printer printer;

    public Library(ArrayList<Book> bookList, PrintStream printStream, BufferedReader bufferedRead) {
        this.bookList = bookList;
        this.printer = new Printer(printStream);
    }

    public void addBook(Book book){
        bookList.add(book);
    }

    public void listBooks(){
        if(bookList.isEmpty()) System.out.print("");
        else {
            for(int i = 0; i < bookList.size(); i++){
                if (bookList.get(i).isAvailable()) {
                    printer.printBookDetails(bookList.get(i));
                }
            }
        }
    }

    public ArrayList<Book> getBookList() {
        return this.bookList;
    }

    public void checkoutById(int id) {
        for (Book book : this.bookList) {
            if (book.getID() == id && book.isAvailable()) {
                printer.printCheckoutMsg(true);
                return;
            }
        }
        printer.printCheckoutMsg(false);

    }

    public void returnById(int id){
        for (Book book : this.bookList) {
            if (book.getID() == id && !book.isAvailable()) {
                printer.printReturnMsg(true);
                return;
            }
        }
        printer.printReturnMsg(false);
    }



}
