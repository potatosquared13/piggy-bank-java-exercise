package com.daniel.piggybank.request;

import com.daniel.piggybank.types.IBAN;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

import static com.daniel.piggybank.types.IBAN.ibanFrom;

public class CreateTransactionRequest {
    public final BigDecimal amount;
    public final IBAN fromAccountIban;
    public final IBAN toAccountIban;

    public CreateTransactionRequest(BigDecimal amount,
                                    @JsonProperty("from_account") String fromAccountIban,
                                    @JsonProperty("to_account") String toAccountIban) {
        this.amount = amount;
        this.fromAccountIban = ibanFrom(fromAccountIban);
        this.toAccountIban = ibanFrom(toAccountIban);
    }
}
