package com.revature.dollodartp0.exceptions;

public class IncorrectPasswordException extends RuntimeException {

    public IncorrectPasswordException() {}
    public IncorrectPasswordException(String msg) {
        System.out.println("Incorrect Password Section.");
        // todo: log this
    }
}