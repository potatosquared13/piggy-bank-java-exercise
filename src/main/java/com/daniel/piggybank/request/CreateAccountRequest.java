package com.daniel.piggybank.request;

import com.daniel.piggybank.types.IBAN;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public class CreateAccountRequest {
    public final IBAN iban;
    public final BigDecimal balance;

    public CreateAccountRequest(@JsonProperty("iban")
                                @Schema(description = "The IBAN of the account", example = "DE89370400440532013000", requiredMode = REQUIRED)
                                IBAN iban,

                                @JsonProperty("balance")
                                @Schema(description = "Initial balance of the account", example = "1000.00", requiredMode = REQUIRED)
                                BigDecimal balance) {
        this.iban = iban;
        this.balance = balance;
    }
}
