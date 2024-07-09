package com.daniel.piggybank.dto;

import com.daniel.piggybank.types.IBAN;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.UUID;

public class AccountDTO {

    @Schema(description = "The unique identifier of the account", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    public final UUID id;

    @Schema(description = "The IBAN of the account", example = "DE89370400440532013000")
    public final String iban;

    @Schema(description = "The current balance of the account", example = "2500.75")
    public final BigDecimal balance;

    public AccountDTO(UUID id, IBAN iban, BigDecimal balance) {
        this.id = id;
        this.iban = iban.getValue();
        this.balance = balance;
    }
}
