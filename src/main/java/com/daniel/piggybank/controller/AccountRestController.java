package com.daniel.piggybank.controller;

import com.daniel.piggybank.dto.AccountDTO;
import com.daniel.piggybank.exceptions.AccountIdNotFoundException;
import com.daniel.piggybank.request.CreateAccountRequest;
import com.daniel.piggybank.service.AccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.SimpleTimeZone;
import java.util.UUID;

@RestController
@RequestMapping("api/accounts")
@Tag(name = "1. Account Operations", description = "Operations related to bank accounts")
public class AccountRestController {

    private final AccountService accountService;

    @Autowired
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public AccountDTO createAccount(@RequestBody CreateAccountRequest request) {
        final var account = accountService.create(request.iban, request.balance);
        return new AccountDTO(account.getId(), account.getIban(), account.getBalance());
    }

    // TODO: Throw 404 if account not found
    @GetMapping("/{accountId}")
    public AccountDTO getAccount(@PathVariable UUID accountId) throws AccountIdNotFoundException {
        final var account = accountService.getbyId(accountId);
        System.out.println(account);
        if(account == null) {
            throw new AccountIdNotFoundException(("Account with ID " + accountId + " not found."));
        }
        return new AccountDTO(account.getId(), account.getIban(), account.getBalance());
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable UUID accountId) {
        accountService.deleteById(accountId);
        return ResponseEntity.ok("{\"status\":\"200\",\"message\":\"OK\"}");
    }

    // TODO: Return 404 (not 500) if account not found
    @ExceptionHandler(AccountIdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleAccountIdNotFoundException(AccountIdNotFoundException e) {
        System.out.println("AccountIdNotFoundException handled: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(AccountIdNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleAccountIdDuplicateException(AccountIdNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}