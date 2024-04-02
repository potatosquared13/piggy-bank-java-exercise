package com.daniel.piggybank.controller;

import com.daniel.piggybank.request.CreateTransactionRequest;
import com.daniel.piggybank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
public class TransactionRestController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public void createTransaction(@RequestBody CreateTransactionRequest request) {
        transactionService.create(request.amount, request.fromAccountIban, request.toAccountIban);
    }

    @GetMapping
    @RequestMapping("/api/transactions/{transactionId}")
    public void getTransaction(@PathVariable UUID transactionId) {
        // TODO: Finish later
    }

}
