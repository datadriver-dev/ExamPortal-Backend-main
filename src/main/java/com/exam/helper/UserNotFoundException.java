package com.exam.helper;

public class UserNotFoundException extends Exception {

	//private String message;
    public UserNotFoundException() {
        super("User does not exist in database");
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
