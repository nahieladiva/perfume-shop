package com.nahiely.perfume_shop.domain.entities;

import com.nahiely.perfume_shop.domain.abstracts.Person;
import com.nahiely.perfume_shop.domain.enums.Role;
import com.nahiely.perfume_shop.domain.enums.UserStatus;
import com.nahiely.perfume_shop.domain.valueobjects.Email;
import com.nahiely.perfume_shop.domain.valueobjects.PhoneNumber;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    private String username;
    private String passwordHash;
    private UserStatus status;
    private List<Role> roles;
    private LocalDateTime lastLogin;

    public User(String id, String firstName, String lastName, Email email, PhoneNumber phone,
                String username, String passwordHash, UserStatus status, List<Role> roles) {
        super(id, firstName, lastName, email, phone);
        this.username = username;
        this.passwordHash = passwordHash;
        this.status = status;
        this.roles = new ArrayList<>(roles);
        this.lastLogin = null;
    }

    public String getUsername() { return username; }
    public UserStatus getStatus() { return status; }
    public List<Role> getRoles() { return new ArrayList<>(roles); }

    @Override
    public Role getRole() {
        return roles.isEmpty() ? Role.BUYER : roles.get(0);
    }

    public void activate() {
        this.status = UserStatus.ACTIVE;
        this.updatedAt = LocalDateTime.now();
    }

    public void deactivate() {
        this.status = UserStatus.INACTIVE;
        this.updatedAt = LocalDateTime.now();
    }

    public void suspend() {
        this.status = UserStatus.SUSPENDED;
        this.updatedAt = LocalDateTime.now();
    }

    public boolean hasRole(Role role) {
        return roles.contains(role);
    }

    public void login() {
        this.lastLogin = LocalDateTime.now();
    }
}