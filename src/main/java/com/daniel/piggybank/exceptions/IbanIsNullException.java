package com.daniel.piggybank.exceptions;

public class IbanIsNullException extends RuntimeException {
    public IbanIsNullException(String message) {
        super(message);
    }
}
