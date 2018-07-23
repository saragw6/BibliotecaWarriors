package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Library {
    private ArrayList<LibraryItem> catalog;
    private ArrayList<User> userList;
    private Printer printer;
    private String currentUser = null;

    public Library(ArrayList<LibraryItem> catalog, PrintStream printStream, BufferedReader bufferedRead) {
        this.catalog = catalog;
        this.printer = new Printer(printStream);
        userList = new ArrayList<>();
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public void addUser(User user){
        userList.add(user);
    }

    public void addItem(LibraryItem item){
        catalog.add(item);
    }

    public void listItems(){
        if(catalog.isEmpty()) System.out.print("");
        else {
            for(int i = 0; i < catalog.size(); i++){
                if (catalog.get(i).isAvailable()) {
                    printer.printDetails(catalog.get(i));
                }
            }
        }
    }

    public ArrayList<LibraryItem> getCatalog() {
        return this.catalog;
    }

    public void checkoutById(String id) {
        String itemType = id.startsWith("B") ? "book" : "movie";
        for (LibraryItem item : this.catalog) {
            if (item.getID().equals(id) && item.isAvailable()) {
                printer.printCheckoutMsg(true, itemType);
                return;
            }
        }

        printer.printCheckoutMsg(false, itemType);

    }


    public void returnById(String id){
        String itemType = id.startsWith("B") ? "book" : "movie";
        for (LibraryItem item : this.catalog) {
            if (item.getID().equals(id) && !item.isAvailable()) {
                printer.printReturnMsg(true, itemType);
                return;
            }
        }

        printer.printReturnMsg(false, itemType);

    }



}
