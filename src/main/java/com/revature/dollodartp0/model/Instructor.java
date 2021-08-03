package com.revature.dollodartp0.model;

import com.revature.exceptions.IncorrectPasswordException;

public class Instructor extends User throws IncorrectPasswordException {

    // instance reference variables
    private String department;
    private String title; // professor, T.A., ... 

    // setters
    public void setDepartment(String department) {this.department = department;}
    public void setTitle(String title) {this.title = title;}

    // getters
    public String getDepartment() {return department;}
    public String getTitle() {return title;}

    // constructor
    public Student(String username, String password){
        this.username = username;
        this.password = password;
    }
}
