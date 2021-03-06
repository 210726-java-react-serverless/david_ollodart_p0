package com.revature.dollodartp0.model;

import com.revature.dollodartp0.exceptions.InvalidTimeException;

import java.util.LinkedList;

public class Class {

    private String className; 
    private String department;
    private int courseNumber;
    private int startHour;
    private int startMinutes;
    private int endHour;
    private int endMinutes;
    private LinkedList<Day> weekdays;

    public enum Day {
        SUNDAY (0),
		MONDAY (1),
		TUESDAY (2),
		WEDNESDAY (3),
        THURSDAY (4),
		FRIDAY (5),
		SATURDAY (6);

		private final int weekinteger;
		Day(int weekinteger) {
		this.weekinteger = weekinteger;
		}
    }

    public Class(String className){
	    this.className = className;
	    parseClassNameToDepartmentAndCourseNumber(this.className); 
	    // don't want to define a tuple return type which is relatively syntactically involved in Java
    }

    private void parseClassNameToDepartmentAndCourseNumber(String className){
		this.department = className.substring(0, 3);
		this.courseNumber = Integer.parseInt(className.substring(3).trim());
    }

    public void setTimeDuration(int startHour, int startMinutes, int durationHour, int durationMinutes) throws InvalidTimeException {
	    int remMinutes = (startMinutes + durationMinutes) % 60;
	    int endMinutes = 60 * remMinutes;
	    int endHour = startHour + durationHour + (startMinutes + durationMinutes) / 60; // Java does integer division
	    setTime(startHour, startMinutes, endHour, endMinutes);
    }
    public void setTime(int startHour, int startMinutes, int endHour, int endMinutes) throws InvalidTimeException {
	    // input validation
	    if (startMinutes % 15 != 0) {
	    	throw new InvalidTimeException("Start must occur at quarter, half, three quarter, or on the hour");}
	    if (endMinutes % 15 != 0) {
	    	throw new InvalidTimeException("End must occur at quarter, half, three quarter, or on the hour");}
	    if (startHour < 8) {
	    	throw new InvalidTimeException("Start hour must be no less than 08:00");}
	    if (endHour >= 20 && endMinutes > 0) {
	    	throw new InvalidTimeException("End time must be no greater than 20:00");}
	    this.startHour = startHour;
	    this.endMinutes = endMinutes - 10; // end class 10 minutes early for students who have a class right afterward
	    if (this.endMinutes < 0) {
	    	this.endMinutes += 60;
		    this.endHour = endHour - 1;} 
	    else {this.endHour = endHour;}
    }

    private void setDays(String[] weekdays){
	    // use enum to convert string to int
	    // take first three characters and convert to uppercase:
	    // MO, TU, WE, TH, FR, SA, SU
	    // while redundant, user displays are sometimes done as Mon, Tue, Wed, Thu, Fri, Sat, Sun
	    // and even the semi-single character M, T, W, Th, F, Sa, S is used
	    this.weekdays = new LinkedList<>();
	    for (String day : weekdays) {
	    	switch (day) {
			case "Mo": 
				this.weekdays.add(Day.MONDAY);
				break;
			case "Tu": 
				this.weekdays.add(Day.TUESDAY);
				break;
			case "We": 
				this.weekdays.add(Day.WEDNESDAY);
				break;
			case "Th": 
				this.weekdays.add(Day.THURSDAY);
				break;
			case "Fr": 
				this.weekdays.add(Day.FRIDAY);
				break;
			case "Sa": 
				this.weekdays.add(Day.SATURDAY);
				break;
			case "Su": 
				this.weekdays.add(Day.SUNDAY);
				break;
			}
	    }
	// TODO use Collection.sort and enum properties of numeric day of week to sort day List
    }

    public void addInstructor(String instructorName) {}
    public void removeInstructor(String instructorName) {}
    public void addStudent(String studentName){
	// input is "First Last" (problem with console based program is you can't use, e.g., suggestions in a bar)
	// Student name isn't unique, but they will like to search by them and not student ID
	// so call a method asking for more input if the student name isn't unique
     }
    public void removeStudent(String studentName){}
}
