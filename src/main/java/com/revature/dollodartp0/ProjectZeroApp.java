package com.revature.dollodartp0;

import com.revature.dollodartp0.views.View;
import com.revature.dollodartp0.dao.RegisterCatalogDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProjectZeroApp{
    /**
     You will be building a console-based student management application.
     */
    
    public static View currentView;
    // not necessarily good practice, but don't want to dependency inject the App State
    // which is the one most global thing of anything, into every view in order to give it a callback
    private final Map<String, View> views = Map<>();

    // this is statically available routingTable so any view can lead to any other view
    public static enum routingTable {
    	LOGIN ("/login"),
		FACULTY_VIEW ("/faculty-view"),
		STUDENT_VIEW ("/student-view");

		private final String route;
		routingTable(String route) {
		this.route = route;
	}
    }

    public static void main(String[] args){
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		RegisterCatalogDAO registerCatalogDAO = new RegisterCatalogDAO();
		loginview = new LoginView(consoleReader, registerCatalogDAO);
		currentScreen = loginview;
		views.add(loginview);
		// technically this object creation could be deferred until it is known whether it is faculty or student
		// but this is at the moment designed as eager loading
		views.add(new RegistrationCatalogFacultyView(consoleReader, registerCatalogDAO));
		views.add(new RegistrationCatalogStudentView(consoleReader, registerCatalogDAO));

		ProjectZeroApp appState = new ProjectZeroApp();
		// the views render method must complete
		// no need for concurrency and therefore threads between views
		// since only one view is displayed at a time
		while (true) {
 	    	try {ProjectZeroApp(currentRoute);}
	    catch (Exception e) {e.printStackTrace();}
		}
    }

    private void switchScreen(String route){
    	view.get(route).render();
    }

}
