package com.revature.dollodartp0.views;

import com.revature.dollodartp0.dao.RegistrationCatalogDAO;

import java.io.BufferedReader;

public class RegistrationCatalogFacultyView extends RegistrationCatalogView {

    public RegistrationCatalogFacultyView(RegistrationCatalogDAO registrationCatalogDAO, BufferedReader consoleReader) {
        super(registrationCatalogDAO, consoleReader);
    }

    public void addClassToCatalog(){} // different from "add class" as a student
    public void removeClassFromCatalog(){}
    public void editClassInCatalog(){}


    @Override
    public void render() {

    }
}
