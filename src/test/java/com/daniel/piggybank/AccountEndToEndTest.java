package com.daniel.piggybank;

import com.daniel.piggybank.dto.AccountDTO;
import com.daniel.piggybank.entity.Account;
import com.daniel.piggybank.repository.AccountRepository;
import com.daniel.piggybank.request.CreateAccountRequest;
import com.daniel.piggybank.types.IBAN;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountEndToEndTest {

    @LocalServerPort
    private int port;

    @Autowired
    private AccountRepository accountRepository;

    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
    }

    @Transactional
    @Test
    void createsAnAccount() {
        final var request = new CreateAccountRequest(IBAN.from("DE371643746183472637423"), ZERO);

        webTestClient.post().uri("/api/accounts")
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk()
                .expectBody(AccountDTO.class)
                .consumeWith(response -> {
                    final var account = response.getResponseBody();
                    assertNotNull(account);
                    final var persistedAccount = accountRepository.getReferenceById(account.id);
                    assertEquals(request.iban, persistedAccount.getIban());
                    assertEquals(0, request.balance.compareTo(persistedAccount.getBalance()));
                });
    }
}
