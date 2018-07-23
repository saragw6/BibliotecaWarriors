package com.twu.biblioteca;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String name;
    private String email;
    private String phone;
    private String pass;
    private String libraryID;

    public User(String name, String email, String phone, String pass) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
    }

    public String getName(){
        return name;
    }

    public void setLibraryID(String id){
        this.libraryID = id;
    }

    public String getLibraryID(){
        return libraryID;
    }

    public Boolean setEmail(String s) {
        String pattern = "\\w*@\\w\\S*\\.\\w*\\S";
        if (s.matches(pattern)){
            email = s;
            return true;
        }
        return false;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean setPhone(String s){
        String pattern = "\\d{3}-\\d{3}-\\d{4}";
        if (s.matches(pattern)){
            phone = s;
            return true;
        }
        return false;
    }

    public String getPhone(){
        return this.phone;
    }

    public String getPassword(){
        return this.pass;
    }

    public Boolean checkPassword(String isPassword){
        return isPassword.equals(this.getPassword());
    }
}
