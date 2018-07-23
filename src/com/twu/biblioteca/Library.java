package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Library {
    private ArrayList<LibraryItem> catalog;
    private Printer printer;

    public Library(ArrayList<LibraryItem> catalog, PrintStream printStream, BufferedReader bufferedRead) {
        this.catalog = catalog;
        this.printer = new Printer(printStream);
    }

    public void addBook(Book book){
        catalog.add(book);
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
            }
        }

        printer.printCheckoutMsg(false, itemType);

    }

    public void returnById(String id){
        String itemType = id.startsWith("B") ? "book" : "movie";
        for (LibraryItem item : this.catalog) {
            if (item.getID().equals(id) && item.isAvailable()) {
                printer.printReturnMsg(true, itemType);
            }
        }

        printer.printReturnMsg(false, itemType);

    }



}
