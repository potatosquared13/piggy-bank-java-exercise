package com.daniel.piggybank.types;

import com.daniel.piggybank.exceptions.InvalidFormatException;
import com.daniel.piggybank.exceptions.IbanIsNullException;
import jakarta.persistence.Column;

import java.util.Objects;

public class IBAN {
    private static final String IBAN_FORMAT = "^[A-Z0-9]{22,34}$";

    @Column(name = "iban")
    private final String value;


    // used only by JPA
    public IBAN() {
        this.value = null;
    }

    public IBAN(String value) {
        this.value = validate(value);
    }

    public String getValue() {
        return value;
    }

    public static IBAN from(String value) {
        return new IBAN(value);
    }

    private static String validate(String iban) {
        if (iban == null) throw new IbanIsNullException("IBAN was null.");

        if (!iban.matches(IBAN_FORMAT)) throw new InvalidFormatException("Wrong IBAN format.");

        return iban;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IBAN iban = (IBAN) o;
        return Objects.equals(value, iban.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
