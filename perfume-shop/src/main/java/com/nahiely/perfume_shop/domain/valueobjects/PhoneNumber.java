package com.nahiely.perfume_shop.domain.valueobjects;

public class PhoneNumber {
    private final String value;

    public PhoneNumber(String value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Teléfono inválido: " + value);
        }
        this.value = value;
    }

    private boolean isValid(String phone) {
        return phone != null && phone.matches("^\\+?[\\d\\s-]{10,15}$");
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}