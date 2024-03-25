package com.daniel.piggybank.service;

import com.daniel.piggybank.entity.Account;
import com.daniel.piggybank.repository.AccountRepository;
import com.daniel.piggybank.types.IBAN;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


// Creates an account
@Service  //Business Logic Layer
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account createAccount(IBAN iban, BigDecimal balance) {
        final var account = new Account(iban, balance);

        

        return account;
    }
}