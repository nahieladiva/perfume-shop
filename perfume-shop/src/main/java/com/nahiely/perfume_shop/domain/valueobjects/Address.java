package com.nahiely.perfume_shop.domain.valueobjects;

public class Address {
    private final String street;
    private final String city;
    private final String state;
    private final String postalCode;
    private final String country;
    private final String apartment;

    public Address(String street, String city, String state, String postalCode, String country) {
        this(street, city, state, postalCode, country, null);
    }

    public Address(String street, String city, String state, String postalCode, String country, String apartment) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.apartment = apartment;
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getPostalCode() { return postalCode; }
    public String getCountry() { return country; }
    public String getApartment() { return apartment; }

    public String getFullAddress() {
        String address = street + ", " + city + ", " + state;
        if (apartment != null) {
            address += ", Apt " + apartment;
        }
        address += ", " + postalCode + ", " + country;
        return address;
    }

    @Override
    public String toString() {
        return getFullAddress();
    }
}