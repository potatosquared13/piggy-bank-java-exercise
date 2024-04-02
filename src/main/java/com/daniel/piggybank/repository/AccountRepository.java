package com.daniel.piggybank.repository;

import com.daniel.piggybank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query("SELECT a FROM Account a WHERE a.iban.value = ?1")
    Optional<Account> findByIban(String iban);
}
