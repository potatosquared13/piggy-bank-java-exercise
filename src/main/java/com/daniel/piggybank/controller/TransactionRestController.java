package com.daniel.piggybank.controller;

import com.daniel.piggybank.dto.AccountDTO;
import com.daniel.piggybank.dto.TransactionDTO;
import com.daniel.piggybank.entity.Transaction;
import com.daniel.piggybank.request.CreateTransactionRequest;
import com.daniel.piggybank.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
@Tag(name = "2. Transaction Operations", description = "Handle transactions between accounts")
public class TransactionRestController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public TransactionDTO createTransaction(@RequestBody CreateTransactionRequest request) {
        final var transaction = transactionService.create(request.amount, request.fromAccountIban, request.toAccountIban);

        return toResponse(transaction);
    }

    @GetMapping
    @RequestMapping("/api/transactions/{transactionId}")
    public TransactionDTO getTransaction(@PathVariable UUID transactionId) {
        final var transaction = transactionService.getById(transactionId);

        return toResponse(transaction);
    }

    private static TransactionDTO toResponse(Transaction transaction) {
        final var fromAccount = transaction.getFromAccount();
        final var toAccount = transaction.getToAccount();

        final var fromAccountDTO = new AccountDTO(fromAccount.getId(), fromAccount.getIban(), fromAccount.getBalance());
        final var toAccountDTO = new AccountDTO(toAccount.getId(), toAccount.getIban(), toAccount.getBalance());

        return new TransactionDTO(transaction.getId(), transaction.getAmount(), fromAccountDTO, toAccountDTO);
    }



}
