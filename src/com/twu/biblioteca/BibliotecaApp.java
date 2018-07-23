package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static boolean isRunning;
    public static Printer printer;

    public static void main(String[] args) {

        welcomeMessage();

        Scanner userInput = new Scanner(System.in);
        PrintStream stream = new PrintStream(System.out);
        Library library = createDefaultLibrary(stream);
        printer = new Printer(stream);
        isRunning = mainMenu(library, userInput, stream);


    }

    public static void welcomeMessage(){
        System.out.println("Welcome to Biblioteca!");
    }

    public static Library createDefaultLibrary(PrintStream stream){
        Library library = new Library(new ArrayList<LibraryItem>(), stream, new BufferedReader(new InputStreamReader(System.in)));

        Book bookTwo = new Book("B2", "Modern Romance", "Aziz Ansari", 2015, true);
        Book bookOne = new Book("B1", "Flowers for Algernon", "Daniel Keyes", 1959, true);

        library.addItem(bookOne);
        library.addItem(bookTwo);

        Movie movieOne = new Movie("M1", "Cindarella Story", "Hillary Duff", 2003, "10", true);
        Movie movieTwo = new Movie("M2", "Total Recall", "Arnold Schwarzneggar", 2015, "3", true);

        library.addItem(movieOne);
        library.addItem(movieTwo);

        User userOne = new User("Joe Smith", "was@sad.xon", "123-231-2341", "1234");
        User userTwo = new User("Iona Book", "great@books.com", "321-423-9021", "tolstoy");

        userOne.setLibraryID("321-7896");
        userTwo.setLibraryID("789-1552");

        library.addUser(userOne);
        library.addUser(userTwo);

        return library;

    }

    private static boolean mainMenu(Library library, Scanner scan, PrintStream ps){
        Boolean running = true;

        while(!logIn(library)){
            //Loop for login
        }

        while(running){
            ps.println("What would you like to do?\n\tList Books   List Movies   Checkout   Return   Quit");
            String response = scan.nextLine();
            if (response.equalsIgnoreCase("list books")){
                library.listItemsByType("B");
            } else if (response.equalsIgnoreCase("list movies")) {
                library.listItemsByType("M");
            }
            else if(response.equalsIgnoreCase("return")){
                libraryFunctions(false, library, ps);
            }
            else if (response.equalsIgnoreCase("checkout")){
                libraryFunctions(true, library, ps);
            }
            else if(response.equalsIgnoreCase("quit")){
                running = false;
            }
            else{
                ps.println("Invalid Menu Option");
            }

        }
        return running;
    }

    public static boolean logIn(Library library){
        Scanner usrInput = new Scanner(System.in);
        printer.printLoginMsg();
        String user = usrInput.nextLine();
        printer.passwordMsg();
        String pass = usrInput.nextLine();
        return library.checkCredentials(user, pass);

    }

    public static void libraryFunctions(Boolean checkOrReturn, Library library, PrintStream ps){
        String functionType = (checkOrReturn) ? "checkout:" : "return:" ;
        ps.println("Type the ID of the item you would like to " + functionType);
        Scanner checkScan = new Scanner(System.in);
        try {
            String response = checkScan.nextLine();
            if (checkOrReturn){
                library.checkoutById(response);
            }
            else {
                library.returnById(response);
            }
        }
        catch (Exception e){
            ps.println("Not a valid ID");

        }

    }

}
