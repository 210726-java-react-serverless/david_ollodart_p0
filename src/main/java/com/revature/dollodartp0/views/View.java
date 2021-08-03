package com.revature.dollodartp0.views;

import com.revature.dollodartp0.dao.RegistrationCatalogDAO;

import java.io.BufferedReader;

abstract public class View implements ViewInterface{

    protected RegistrationCatalogDAO registrationCatalogDAO;
    protected BufferedReader consoleReader;

    public View(RegistrationCatalogDAO registrationCatalogDAO, BufferedReader consoleReader) {
	    this.registrationCatalogDAO = registrationCatalogDAO;
	    this.consoleReader = consoleReader;
    }
}
