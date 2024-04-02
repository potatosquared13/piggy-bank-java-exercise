package com.daniel.piggybank.dto;

import com.daniel.piggybank.types.IBAN;

import java.math.BigDecimal;
import java.util.UUID;

public class AccountDTO { //Data Transfer Object
    public final UUID id;
    public final String iban;
    public final BigDecimal balance;

    public AccountDTO(UUID id, IBAN iban, BigDecimal balance) {
        this.id = id;
        this.iban = iban.getValue();
        this.balance = balance;
    }
}
