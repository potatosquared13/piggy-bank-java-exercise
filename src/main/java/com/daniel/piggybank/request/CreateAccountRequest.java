package com.daniel.piggybank.request;

import com.daniel.piggybank.types.IBAN;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CreateAccountRequest {
    public final IBAN iban;
    public final BigDecimal balance;

    public CreateAccountRequest(@JsonProperty("iban") IBAN iban,
                                @JsonProperty("balance") BigDecimal balance) {
        this.iban = iban;
        this.balance = balance;
    }
}
