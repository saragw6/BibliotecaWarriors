package com.twu.biblioteca;

import java.io.PrintStream;

public class Printer {
    private static PrintStream ps;

    public Printer(PrintStream ps){
        this.ps = ps;
    }

    static String welcomeMsg = "Welcome to Biblioteca";
    static String invalidMenuOptionMsg = "Select a valid option!";
    static String successCheckoutMsg = "Thank you! Enjoy the book.";
    static String failCheckoutMsg = "That book is not available.";
    static String successReturnMsg = "Thank you for returning the book.";
    static String failReturnMsg = "That is not a valid book to return.";


    public void printBookDetails(Book book) {
        ps.println(book.id + " | " + book.title + " | " + book.author + " | " + book.pubDate);
    }

     public static void printWelcome(){
         ps.println(welcomeMsg);
     }

     public static void printInvalidMenu(){
         ps.println(invalidMenuOptionMsg);
     }

     public static void printCheckoutMsg(boolean success){
         String checkOutMsg = success ? successCheckoutMsg : failCheckoutMsg;
         ps.println(checkOutMsg);
     }

     public static void printReturnMsg(boolean success){
         String returnMsg = success ? successReturnMsg : failReturnMsg;
         ps.println(returnMsg);
     }


}
