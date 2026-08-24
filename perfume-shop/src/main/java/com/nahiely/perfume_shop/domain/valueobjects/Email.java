package com.nahiely.perfume_shop.domain.valueobjects;

public class Email {
    private final String value;

    public Email(String value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Email inválido: " + value);
        }
        this.value = value;
    }

    private boolean isValid(String email) {
        return email != null && email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}