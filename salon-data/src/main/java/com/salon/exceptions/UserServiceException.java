package com.salon.exceptions;


public class UserServiceException extends  RuntimeException{

    public UserServiceException(String message) {
        super(message);

    }
}