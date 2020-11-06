package com.thoughtworks.capacity.gtb.mvc.exception;

public class UsernameOrPasswordWrongException extends RuntimeException{

    public UsernameOrPasswordWrongException(String message) {
        super(message);
    }
}
