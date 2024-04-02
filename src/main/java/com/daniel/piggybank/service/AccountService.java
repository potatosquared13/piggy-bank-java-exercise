package com.daniel.piggybank.service;

import com.daniel.piggybank.entity.Account;
import com.daniel.piggybank.exceptions.AccountIdNotFoundException;
import com.daniel.piggybank.repository.AccountRepository;
import com.daniel.piggybank.types.IBAN;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;
import java.util.UUID;

// MySQL
// PostersSQL
// Oracle
// AWS <- Red Shift (Discount Oracle)

// Creates an account
@Service  //Business Logic Layer
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account create(IBAN iban, BigDecimal balance) {
        final var account = new Account(iban, balance);
        // CRUD = Create, Read, Update, Delete
        return accountRepository.save(account);
    }

    public Account getbyId(UUID accountId) {
       return accountRepository.getReferenceById(accountId);
    }

    @Transactional
    public void deleteById(UUID accountId) {
        accountRepository.deleteById(accountId);
    }
}