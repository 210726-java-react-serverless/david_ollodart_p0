package com.revature.dollodartp0;

import com.revature.dollodartp0.dao.RegistrationCatalogDAO;
import com.revature.dollodartp0.views.RegistrationCatalogFacultyView;
import com.revature.dollodartp0.views.RegistrationCatalogStudentView;
import com.revature.dollodartp0.views.View;
import com.revature.dollodartp0.views.LoginView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ProjectZeroApp{
    /**
     You will be building a console-based student management application.
     */
    
    public static String currentRoute;
	// not necessarily good practice, but don't want to dependency inject the App State
    // which is the one most global thing of anything, into every view in order to give it a callback
    private final HashMap<String, View> views = new HashMap<>();

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
		RegistrationCatalogDAO registerCatalogDAO = new RegistrationCatalogDAO();
		View loginview = new LoginView(registerCatalogDAO, consoleReader);
		View currentScreen = loginview;

		ProjectZeroApp appState = new ProjectZeroApp();

		appState.views.put(routingTable.LOGIN.route, loginview);
		// technically this object creation could be deferred until it is known whether it is faculty or student
		// but this is at the moment designed as eager loading
		appState.views.put(routingTable.FACULTY_VIEW.route,
				new RegistrationCatalogFacultyView(registerCatalogDAO, consoleReader));
		appState.views.put(routingTable.STUDENT_VIEW.route,
				new RegistrationCatalogStudentView(registerCatalogDAO, consoleReader));

		// the views render method must complete
		// no need for concurrency and therefore threads between views
		// since only one view is displayed at a time
		while (true) {
 	    	try {appState.switchScreen(currentRoute);}
	    catch (Exception e) {e.printStackTrace();}
		}
    }

    private void switchScreen(String route){
    	views.get(route).render();
    }

}
