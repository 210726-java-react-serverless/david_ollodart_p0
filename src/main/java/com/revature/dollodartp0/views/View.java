package com.revature.dollodartp0.views;

import com.revature.dollodartp0.dao.RegistrationCatalogDAO;
import com.revature.dollodartp0.model.User;

import java.io.BufferedReader;
import java.io.IOException;

abstract public class View implements ViewInterface{

    protected RegistrationCatalogDAO registrationCatalogDAO;
    protected BufferedReader consoleReader;

    public View(RegistrationCatalogDAO registrationCatalogDAO, BufferedReader consoleReader) {
	    this.registrationCatalogDAO = registrationCatalogDAO;
	    this.consoleReader = consoleReader;
    }

    protected String repeatedAsk(String field) {
        String userInput;
        try {
            System.out.printf("enter %s> ", field);
            return consoleReader.readLine();
        } catch (IOException io) {
            System.out.println("\nsystem error, try again");
            repeatedAsk(field);
        }
        return repeatedAsk(field); // in case not caught by IOException
    }
    protected String repeatedAskForUsername() {
        return repeatedAsk("username");}
    protected String repeatedAskForPassword() {
        return repeatedAsk("password");}
    protected String repeatedAskForPasswordTwice() {
        String entry1 = repeatedAsk("password");
        String entry2 = repeatedAsk("password again");
        if (entry1.equals(entry2)) {return entry1;}
        else {
            System.out.println("try again");
            return repeatedAskForPasswordTwice();}
    }
    protected String repeatedAskForUsernameCheckUnique() {
        String username = repeatedAskForUsername();
        User user = registrationCatalogDAO.getUserbyUsername(username);
        if (user != null) {
            System.out.println("username exists, try again");
            return repeatedAskForUsernameCheckUnique();
        }
        return username;
    }

    protected boolean allGood() {
        System.out.print("all good?[Y/n]> ");
        try {
            String res = consoleReader.readLine();
            if (!res.equals("n")) {
                return true;
            }
            return false;
        } catch (IOException ioe) {
            System.out.println("\nsystem error, try again");
            allGood();
        }
        return false; // unknown exceptions or problems?
    }
}