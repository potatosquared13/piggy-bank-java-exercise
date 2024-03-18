package com.daniel.piggybank.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CreateAccountRequest {
    public final String iban;
    public final BigDecimal balance;

    public CreateAccountRequest(@JsonProperty("iban") String iban,
                                @JsonProperty("balance") BigDecimal balance) {
        this.iban = iban;
        this.balance = balance;
    }
}
