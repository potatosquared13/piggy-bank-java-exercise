package com.daniel.piggybank.entity;

import com.daniel.piggybank.exceptions.InsufficientBalanceException;
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
    private BigDecimal balance;

    // Used only by JPA
    Account() {
        id = null;
        iban = null;
        balance = null;
    }

    public Account(IBAN iban, BigDecimal balance) {
        this.id = UUID.randomUUID();
        // TODO: null check on iban
        this.iban = iban;
        // TODO: exception check if balance is < 0
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public IBAN getIban() {
        return iban;
    }

    public BigDecimal getBalance() {
        return balance;
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

    public void debit(BigDecimal amount) {
        final var newBalance = this.balance.subtract(amount);
        final var newBalanceIsLessThanZero = newBalance.compareTo(BigDecimal.ZERO) < 0;
        if(newBalanceIsLessThanZero) {
            throw new InsufficientBalanceException();
        }

        this.balance = newBalance;
    }

    public void credit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }
}
