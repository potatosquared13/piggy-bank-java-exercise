package com.daniel.piggybank.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class TransactionDTO {
    public final UUID id;
    public final BigDecimal amount;
    public final AccountDTO fromAccount;
    public final AccountDTO toAccount;

    // FIXME: Pass Transaction Entity as argument.
    public TransactionDTO(UUID id,
                          BigDecimal amount,
                          AccountDTO fromAccount,
                          AccountDTO toAccount) {
        this.id = id;
        this.amount = amount;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }
}
