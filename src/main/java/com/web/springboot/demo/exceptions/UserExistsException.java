package com.web.springboot.demo.exceptions;

public class UserExistsException extends Exception {
    public UserExistsException(String message){
        super(message);
    }
}
