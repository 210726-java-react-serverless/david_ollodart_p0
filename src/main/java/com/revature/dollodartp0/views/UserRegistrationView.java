package com.revature.dollodartp0.views;

import com.revature.dollodartp0.dao.RegistrationCatalogDAO;

import java.io.BufferedReader;

public class UserRegistrationView extends View {
    UserRegistrationView(RegistrationCatalogDAO registrationCatalogDAO, BufferedReader consoleReader) {
        super(registrationCatalogDAO, consoleReader);
    }
    public void render() {}
}
