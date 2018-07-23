package com.twu.biblioteca;

import java.io.PrintStream;

public class Printer {
    private static PrintStream ps;

    public Printer(PrintStream ps){
        this.ps = ps;
    }

    static String itemType = null;
    static String welcomeMsg = "Welcome to Biblioteca";
    static String invalidMenuOptionMsg = "Select a valid option!";
    static String successCheckoutMsg = "Thank you! Enjoy the " + itemType + ".";
    static String failCheckoutMsg = "That " + itemType + " is not available.";
    static String successReturnMsg = "Thank you for returning the " + itemType + ".";
    static String failReturnMsg = "That is not a valid " + itemType + " to return.";


    public void printDetails(LibraryItem libItem) {
        ps.println(libItem);
    }

     public static void printWelcome(){
         ps.println(welcomeMsg);
     }

     public static void printInvalidMenu(){
         ps.println(invalidMenuOptionMsg);
     }

     public static void printCheckoutMsg(boolean success, String itemType){
         String checkOutMsg = success ? successCheckoutMsg : failCheckoutMsg;
         ps.println(checkOutMsg);
     }

     public static void printReturnMsg(boolean success, String itemType){
         String returnMsg = success ? successReturnMsg : failReturnMsg;
         ps.println(returnMsg);
     }


}
