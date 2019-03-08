package com.epam.cleancode.comments;

public class InvalidInputException extends RuntimeException{

    private final String message;

    InvalidInputException(String invalidInputException) {
        super();
        message = invalidInputException;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
