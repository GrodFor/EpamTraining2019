package com.epam.cleancode.singleresponsibility;

class WrongFormatException extends RuntimeException {

    private final String message;

    WrongFormatException(String wrongInputException) {
        super();
        message = wrongInputException;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
