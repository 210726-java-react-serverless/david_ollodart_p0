package com.revature.dollodartp0.exceptions;

public class InvalidTimeException extends RuntimeException {

    public InvalidTimeException() {}

    public InvalidTimeException(String msg) {
        System.out.println("Invalid Time Exception."); // todo: log this
    }
}