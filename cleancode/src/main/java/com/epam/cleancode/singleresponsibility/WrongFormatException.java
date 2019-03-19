package com.epam.cleancode.singleresponsibility;

class WrongFormatException extends RuntimeException {

    WrongFormatException(String wrongInputException) {
        super(wrongInputException);
    }
}
