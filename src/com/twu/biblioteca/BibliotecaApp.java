package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static boolean isRunning;

    public static void main(String[] args) {

        welcomeMessage();

        Scanner userInput = new Scanner(System.in);
        PrintStream stream = new PrintStream(System.out);
        Library library = new Library(new ArrayList<Book>(), stream, new BufferedReader(new InputStreamReader(System.in)));
        isRunning = mainMenu(library, userInput, stream);

    }

    public static void welcomeMessage(){
        System.out.println("Welcome to Biblioteca!");
    }

    private static boolean mainMenu(Library library, Scanner scan, PrintStream ps){
        Boolean running = true;
        while(running){
            ps.println("What would you like to do?\n List Books   Quit");
            String response = scan.nextLine();

            if (response.equalsIgnoreCase("list books")){
                library.listBooks();
            }
            else if(response.equalsIgnoreCase("quit")){
                running = false;
            }
            else{
                ps.println("Invaild Menu Option");
            }
        }
        return running;
    }
}
