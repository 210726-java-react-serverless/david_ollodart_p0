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
            System.out.println("\ntry again");
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
}