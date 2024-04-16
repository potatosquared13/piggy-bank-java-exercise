package com.daniel.piggybank.service;

import com.daniel.piggybank.entity.Account;
import com.daniel.piggybank.repository.AccountRepository;
import com.daniel.piggybank.types.IBAN;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account create(IBAN iban, BigDecimal balance) {
        final var account = new Account(iban, balance);
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