package com.daniel.piggybank.entity;

import com.daniel.piggybank.types.IBAN;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private final UUID id;

    @Embedded
    private final IBAN iban;

    @Column(name = "balance")
    private final BigDecimal balance;

    // Used only by JPA
    Account() {
            
    }

    public Account(UUID id, IBAN iban, BigDecimal balance) {
        this.id = id;
        this.iban = iban;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(iban, account.iban) && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iban, balance);
    }
}
