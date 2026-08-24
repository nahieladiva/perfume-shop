package com.nahiely.perfume_shop.domain.entities;

import com.nahiely.perfume_shop.domain.enums.Role;
import com.nahiely.perfume_shop.domain.enums.UserStatus;
import com.nahiely.perfume_shop.domain.valueobjects.Email;
import com.nahiely.perfume_shop.domain.valueobjects.PhoneNumber;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Buyer extends User {
    private int points;
    private LocalDateTime memberSince;
    private List<String> wishlist;

    public Buyer(String id, String firstName, String lastName, Email email, PhoneNumber phone,
                 String username, String passwordHash) {
        super(id, firstName, lastName, email, phone, username, passwordHash,
              UserStatus.PENDING_VERIFICATION, List.of(Role.BUYER));
        this.points = 0;
        this.memberSince = LocalDateTime.now();
        this.wishlist = new ArrayList<>();
    }

    public int getPoints() { return points; }
    public LocalDateTime getMemberSince() { return memberSince; }
    public List<String> getWishlist() { return new ArrayList<>(wishlist); }

    public void addToWishlist(String perfumeId) {
        if (!wishlist.contains(perfumeId)) {
            wishlist.add(perfumeId);
            this.updatedAt = LocalDateTime.now();
        }
    }

    public void removeFromWishlist(String perfumeId) {
        wishlist.remove(perfumeId);
        this.updatedAt = LocalDateTime.now();
    }

    public void addPurchase(String orderId) {
        this.points += 10;
        this.updatedAt = LocalDateTime.now();
    }

    public boolean redeemPoints(int points) {
        if (points > this.points) return false;
        this.points -= points;
        this.updatedAt = LocalDateTime.now();
        return true;
    }
}