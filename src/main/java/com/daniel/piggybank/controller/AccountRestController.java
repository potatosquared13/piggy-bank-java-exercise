package com.daniel.piggybank.controller;

import com.daniel.piggybank.dto.AccountDTO;
import com.daniel.piggybank.request.CreateAccountRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/accounts")
public class AccountRestController {

    @PostMapping
    public AccountDTO createAccount(@RequestBody CreateAccountRequest request) {
        // TODO: Create account
        return new AccountDTO(UUID.randomUUID(), request.iban, request.balance);
    }
}

