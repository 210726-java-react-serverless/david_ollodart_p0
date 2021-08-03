package com.revature.dollodartp0.views;

import com.revature.dollodartp0.ProjectZeroApp;
import com.revature.dollodartp0.dao.RegistrationCatalogDAO;
import com.revature.dollodartp0.model.User;

import java.io.BufferedReader;

public class LoginView extends View{

    public LoginView(RegistrationCatalogDAO registrationCatalogDAO, BufferedReader consoleReader) {
        super(registrationCatalogDAO, consoleReader);
    }

    @Override
    public void render() {
        String username = repeatedAskForUsername();
        String password = repeatedAskForPassword();
        User user = registrationCatalogDAO.getUserByUsernamePassword(username, password);
        if (user == null) {
            System.out.println("user isn't in database, try again (1) or register (2)");
            String userInput = repeatedAsk("route");
            if (userInput.trim().equals("1")) {
                ProjectZeroApp.currentRoute = ProjectZeroApp.routingTable.LOGIN.route;}
            else {
                ProjectZeroApp.currentRoute = ProjectZeroApp.routingTable.REGISTER.route;}
        } else {
            System.out.println("successfully logged in");
            // ProjectZeroApp.currentUser = user;
        }
    }
}
