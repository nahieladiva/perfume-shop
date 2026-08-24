package com.nahiely.perfume_shop.domain.entities;

import com.nahiely.perfume_shop.domain.enums.Role;
import com.nahiely.perfume_shop.domain.enums.UserStatus;
import com.nahiely.perfume_shop.domain.valueobjects.Email;
import com.nahiely.perfume_shop.domain.valueobjects.PhoneNumber;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private int adminLevel;
    private List<String> permissions;

    public Admin(String id, String firstName, String lastName, Email email, PhoneNumber phone,
                 String username, String passwordHash) {
        super(id, firstName, lastName, email, phone, username, passwordHash,
              UserStatus.ACTIVE, List.of(Role.ADMIN));
        this.adminLevel = 1;
        this.permissions = new ArrayList<>();
        this.permissions.add("VIEW_USERS");
        this.permissions.add("MANAGE_USERS");
    }

    public int getAdminLevel() { return adminLevel; }
    public List<String> getPermissions() { return new ArrayList<>(permissions); }

    public void addPermission(String permission) {
        if (!permissions.contains(permission)) {
            permissions.add(permission);
            this.updatedAt = LocalDateTime.now();
        }
    }

    public boolean hasPermission(String permission) {
        return permissions.contains(permission);
    }

    public void suspendUser(User user) {
        user.suspend();
    }

    public void activateUser(User user) {
        user.activate();
    }
}