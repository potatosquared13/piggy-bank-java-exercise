package com.daniel.piggybank.service;

import com.daniel.piggybank.exceptions.AccountIdNotFoundException;
import com.daniel.piggybank.repository.AccountRepository;
import com.daniel.piggybank.repository.TransactionRepository;
import com.daniel.piggybank.entity.Transaction;
import com.daniel.piggybank.types.IBAN;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(AccountRepository accountRepository,
                              TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }


    @Transactional
    public Transaction create(BigDecimal amount, IBAN fromAccountIban, IBAN toAccountIban) {
        final var fromAccount = accountRepository.findByIban(fromAccountIban.getValue())
                .orElseThrow(() -> new AccountIdNotFoundException("Iban not found"));
        final var toAccount = accountRepository.findByIban(toAccountIban.getValue())
                .orElseThrow(() -> new AccountIdNotFoundException("Iban not found"));

        fromAccount.debit(amount);
        toAccount.credit(amount);

        final var transaction = new Transaction(amount, fromAccount, toAccount);
        return transactionRepository.save(transaction);
    }
}
