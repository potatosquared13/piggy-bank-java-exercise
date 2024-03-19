package com.daniel.piggybank.types;

import com.daniel.piggybank.exceptions.InvalidFormatException;
import com.daniel.piggybank.exceptions.NullException;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.jupiter.api.Assertions.*;

class IBANTest {
    // happy path

    @Test
    void createsAValidIban() {
        assertDoesNotThrow(() -> {
            var expectedIban = "DE4667383109227384852214";
            var iban = new IBAN(expectedIban);
            assertEquals(expectedIban, iban.getValue());
        });
    }

    @Test
    void doesNotAllowIncorrectIbanFormat() {
        assertThrows(InvalidFormatException.class, () -> new IBAN("DE8373$718729182763"));
    }

    @Test
    void doesNotAllowNullIban() {
        assertThrows(NullException.class, () -> new IBAN(null));
    }
}