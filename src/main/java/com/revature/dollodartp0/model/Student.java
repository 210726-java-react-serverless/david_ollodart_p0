package com.revature.dollodartp0.model;

import com.revature.exceptions.IncorrectPasswordException;

public class Student extends User throws IncorrectPasswordException {

    // instance reference variables
    private int year; // 1, 2, 3, 4, or 4+ year
    private String major;
    private String minor;

    // setters
    public void setYear(int year) {this.year = year;}
    public void setMajor(String major) {this.major = major;}
    public void setMinor(String minor) {this.minor = minor;}

    // getters
    public String getMajor() {return major;}
    public String getMinor() {return minor;}
    public int getYear() {return year;}

    // constructor
    public Student(String username, String password){
        this.username = username;
        this.password = password;
        // check if this student is already registered somewhere?
    }
}
