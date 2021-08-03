package com.revature.dollodartp0.views;

import com.revature.dollodartp0.ProjectZeroApp;
import com.revature.dollodartp0.dao.RegistrationCatalogDAO;
import com.revature.dollodartp0.model.User;

import java.io.BufferedReader;

public class UserRegistrationView extends View {
    UserRegistrationView(RegistrationCatalogDAO registrationCatalogDAO, BufferedReader consoleReader) {
        super(registrationCatalogDAO, consoleReader);
    }
    public void render() {
        String username = repeatedAskForUsernameCheckUnique();
        String password = repeatedAskForPasswordTwice();
        String firstName = repeatedAsk("first name");
        String lastName = repeatedAsk("last name");
        // String email = repeatedAsk("email");
        if (!allGood()) {render();}
        User user = new User(username, password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        registrationCatalogDAO.addUser(user);
        System.out.println("Successfully added user: " + user.toString());
        ProjectZeroApp.currentRoute = ProjectZeroApp.routingTable.LOGIN.route;
    }
}
