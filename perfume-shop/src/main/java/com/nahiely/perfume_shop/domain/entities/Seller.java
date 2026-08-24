package com.nahiely.perfume_shop.domain.entities;

import com.nahiely.perfume_shop.domain.enums.Role;
import com.nahiely.perfume_shop.domain.enums.UserStatus;
import com.nahiely.perfume_shop.domain.valueobjects.Email;
import com.nahiely.perfume_shop.domain.valueobjects.PhoneNumber;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Seller extends User {
    private String storeName;
    private String storeDescription;
    private boolean verified;
    private List<String> products;
    private int salesCount;

    public Seller(String id, String firstName, String lastName, Email email, PhoneNumber phone,
                  String username, String passwordHash, String storeName, String storeDescription) {
        super(id, firstName, lastName, email, phone, username, passwordHash,
              UserStatus.PENDING_VERIFICATION, List.of(Role.SELLER));
        this.storeName = storeName;
        this.storeDescription = storeDescription;
        this.verified = false;
        this.products = new ArrayList<>();
        this.salesCount = 0;
    }

    public String getStoreName() { return storeName; }
    public String getStoreDescription() { return storeDescription; }
    public boolean isVerified() { return verified; }
    public List<String> getProducts() { return new ArrayList<>(products); }
    public int getSalesCount() { return salesCount; }

    public void addProduct(String productId) {
        if (!products.contains(productId)) {
            products.add(productId);
            this.updatedAt = LocalDateTime.now();
        }
    }

    public void removeProduct(String productId) {
        products.remove(productId);
        this.updatedAt = LocalDateTime.now();
    }

    public void recordSale() {
        this.salesCount++;
        this.updatedAt = LocalDateTime.now();
    }

    public void verifyStore() {
        this.verified = true;
        this.updatedAt = LocalDateTime.now();
    }
}