package com.daniel.piggybank.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.UUID;

public class TransactionDTO {


    @Schema(description = "The unique identifier of the transaction", example = "d290f1ee-6c54-4b01-90e6-d701748f0851")
    public final UUID id;

    @Schema(description = "The amount transferred in the transaction", example = "150.50")
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
