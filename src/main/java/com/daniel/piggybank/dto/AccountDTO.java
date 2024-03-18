package com.daniel.piggybank.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class AccountDTO { //Data Transfer Object
    public final UUID id;

    // TODO: make iban into a type
    public final String iban;
    public final BigDecimal balance;

    public AccountDTO(UUID id, String iban, BigDecimal balance) {
        this.id = id;
        this.iban = iban;
        this.balance = balance;
    }
}
