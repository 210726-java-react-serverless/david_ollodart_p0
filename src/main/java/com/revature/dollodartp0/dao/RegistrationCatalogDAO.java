package com.revature.dollodartp0.dao;
import java.util.TreeSet;

public class RegistrationCatalogDAO{

    public RegistrationCatalogDAO() {
        //MongoDB mongoDB = new MongoDB();
    } // constructor using backend object

    public TreeSet<Class> getClasses(String className) {
            // TreeSet (TODO: comparator or Class compare method for sorting query result)
    }

    public void addClass(String className) {
            // "add new classes to the registration catalog"
            // check that the class doesn't exist (using value equality)
            // if it doesn't, then create a class
    }

    public TreeSet<Class> getClassesByStudent(String studentName) {
            // used for student view (display all classes I am a part of)
    }

    public getUserByUsername(String username) {
        //
    }

}
