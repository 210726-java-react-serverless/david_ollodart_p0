package com.revature.dollodartp0.views;

import com.revature.dollodartp0.dao.RegistrationCatalogDAO;

import java.io.BufferedReader;

import com.revature.dollodartp0.views.View;

public abstract class RegistrationCatalogView extends View {

    public RegistrationCatalogView(RegistrationCatalogDAO registrationCatalogDAO, BufferedReader consoleReader) {
        super(registrationCatalogDAO, consoleReader);
    }

    public void viewRegistrationCatalog() {}
    // both instructors and students will want to view the Registration catalog
    public void viewRegisteredClasses() {}
    // both instructors and students will want to view the classes they are registered for
}
