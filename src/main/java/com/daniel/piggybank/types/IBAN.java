package com.daniel.piggybank.types;

import com.daniel.piggybank.exceptions.InvalidFormatException;
import com.daniel.piggybank.exceptions.NullException;

import java.util.Objects;

public class IBAN {
    private static final String IBAN_FORMAT = "^[A-Z0-9]{22,34}$"; // constant

    private final String value;

    public IBAN(String value) throws InvalidFormatException, NullException {
        this.value = validate(value);
    }

    public String getValue() {
        return value;
    }

    private static String validate(String iban) throws InvalidFormatException, NullException {
        if(null == iban) throw new NullException("IBAN was null.");

        if(!iban.matches(IBAN_FORMAT)) throw new InvalidFormatException("Wrong IBAN format.");

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
