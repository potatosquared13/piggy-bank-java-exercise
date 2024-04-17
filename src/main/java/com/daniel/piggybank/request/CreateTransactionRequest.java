package com.daniel.piggybank.request;

import com.daniel.piggybank.types.IBAN;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

import static com.daniel.piggybank.types.IBAN.from;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public class CreateTransactionRequest {
    public final BigDecimal amount;

    @Schema(hidden = true)
    public final IBAN fromAccountIban;

    @Schema(hidden = true)
    public final IBAN toAccountIban;

    public CreateTransactionRequest(@JsonProperty("amount")
                                    @Schema(description = "Transaction amount", example = "100.50", requiredMode = REQUIRED)
                                    BigDecimal amount,

                                    @JsonProperty("from_account")
                                    @Schema(description = "IBAN of the account to debit", example = "DE89370400440532013000", requiredMode = REQUIRED)
                                    String fromAccountIban,

                                    @JsonProperty("to_account")
                                    @Schema(description = "IBAN of the account to credit", example = "DE89370400440532013001", requiredMode = REQUIRED)
                                    String toAccountIban) {
        this.amount = amount;
        this.fromAccountIban = from(fromAccountIban);
        this.toAccountIban = from(toAccountIban);
    }
}
