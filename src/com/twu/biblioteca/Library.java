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
                if (bookList.get(i).isAvailable()) {
                    bookList.get(i).printDetails();
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
                printMsg(true, true);
            }
        }
        printMsg(false, true);

    }

    public void returnById(int id){
        for (Book book : this.bookList) {
            if (book.getID() == id && !book.isAvailable()) {
                printMsg(true, false);
            }
        }
        printMsg(false, false);
    }

    public void printMsg(boolean success, boolean checkoutBook){
        String successCheckout = "Thank you! Enjoy the book.";
        String failCheckout = "That book is not available.";
        String successReturn = "Thank you for returning the book.";
        String failReturn = "That is not a valid book to return";

        String checkOutMsg = success ? successCheckout : failCheckout;
        String returnMsg = success ? successReturn : failReturn;

        if(checkoutBook) System.out.println(checkOutMsg);
        else System.out.println(returnMsg);
    }


}
