package com.daniel.piggybank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Transaction {

    @Id
    @Column(name = "id")
    private final UUID id;

    @Column(name = "amount")
    private final BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "from_account")
    private final Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account")
    private final Account toAccount;

    // used only by JPA
    Transaction() {
        id = null;
        amount = null;
        fromAccount = null;
        toAccount = null;
    }

    public Transaction(BigDecimal amount,
                       Account fromAccount,
                       Account toAccount) {
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(amount, that.amount) && Objects.equals(fromAccount, that.fromAccount) && Objects.equals(toAccount, that.toAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, fromAccount, toAccount);
    }
}
