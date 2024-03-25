package com.daniel.piggybank.controller;

import com.daniel.piggybank.dto.AccountDTO;
import com.daniel.piggybank.entity.Account;
import com.daniel.piggybank.request.CreateAccountRequest;
import com.daniel.piggybank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/accounts")
public class AccountRestController {

    private final AccountService accountService;

    @Autowired   // Wire controllers together. only used on spring managed beans
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public AccountDTO createAccount(@RequestBody CreateAccountRequest request) {
        final var account = accountService.createAccount(request.iban, request.balance);
        return new AccountDTO(account.getId(), account.getIban(), account.getBalance());
    }
}