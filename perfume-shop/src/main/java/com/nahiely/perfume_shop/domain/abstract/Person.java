package com.nahiely.perfume_shop.domain.abstracts;

import com.nahiely.perfume_shop.domain.enums.Role;
import com.nahiely.perfume_shop.domain.valueobjects.Email;
import com.nahiely.perfume_shop.domain.valueobjects.PhoneNumber;
import java.time.LocalDateTime;

public abstract class Person {
    protected String id;
    protected String firstName;
    protected String lastName;
    protected Email email;
    protected PhoneNumber phone;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public Person(String id, String firstName, String lastName, Email email, PhoneNumber phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Email getEmail() { return email; }
    public PhoneNumber getPhone() { return phone; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public abstract Role getRole();
}