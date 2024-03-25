package com.daniel.piggybank.service;

import com.daniel.piggybank.entity.Account;
import com.daniel.piggybank.types.IBAN;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


// Creates an account
@Service  //Business Logic Layer
public class AccountService {
    @Transactional
    public Account createAccount(IBAN iban, BigDecimal balance) {
        final var account = new Account(iban, balance);
        // SQL commands inserted automatically
        return account;
    }
}