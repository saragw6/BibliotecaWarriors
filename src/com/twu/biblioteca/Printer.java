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

    static String passwordIncorrectMsg = "Incorrect Password, Try Again";
    static String passwordMatchMsg = "You are now logged in";

    static String checkOutMsg;
    static String returnMsg;

    static String successfulEmailSet = "You now have a new email";
    static String unsuccessfulEmailSet = "Invalid email; please try again";
    static String successfulPhoneSet = "You now have a new phone";
    static String unsuccessfulPhoneSet = "Invalid phone; please try again";

    public void printDetails(LibraryItem libItem) {
        ps.println(libItem.toString());
    }

     public static void printWelcome(){
         ps.println(welcomeMsg);
     }

     public static void printInvalidMenu(){
         ps.println(invalidMenuOptionMsg);
     }

     public static void  printLoginMsg(){
        ps.println("Please Enter your Library ID:");
     }

     public static void passwordMsg(){
        ps.println("Password: ");
     }

     public static void printCheckoutMsg(boolean success, String item){
         itemType = item;

         if(success){
             checkOutMsg = "Thank you! Enjoy the " + itemType + ".";
         } else {
             checkOutMsg = "That " + itemType + " is not available.";
         }

         ps.println(checkOutMsg);
     }

     public static void printReturnMsg(boolean success, String item){
         itemType = item;

         if(success){
             returnMsg = "Thank you for returning the " + itemType + ".";
         } else {
             returnMsg = "That is not a valid " + itemType + " to return.";
         }

         ps.println(returnMsg);
     }

     public static void printUserDetails(User user){
        ps.println(user.toString());
     }

     public static void printCheckPassword(boolean success){
        String returnMsg = success ? passwordMatchMsg : passwordIncorrectMsg;
        ps.println(returnMsg);
     }

     public static void printSetEmailResult(boolean result){
        String returnMsg = result ? successfulEmailSet : unsuccessfulEmailSet;
        ps.print(returnMsg);
     }

     public static void printSetPhoneResult(boolean result){
        String returnMsg = result ? successfulPhoneSet : unsuccessfulPhoneSet;
        ps.println(returnMsg);
     }


}
