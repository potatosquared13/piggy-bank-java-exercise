package com.daniel.piggybank.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class AccountIdNotFoundException extends RuntimeException {
    public AccountIdNotFoundException(String message) {
        super(message);
    }
}
