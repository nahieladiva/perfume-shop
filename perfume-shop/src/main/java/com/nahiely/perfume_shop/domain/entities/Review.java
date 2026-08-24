package com.nahiely.perfume_shop.domain.entities;

import java.time.LocalDateTime;

public class Review {
    private String id;
    private User user;
    private Perfume perfume;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Review(String id, User user, Perfume perfume, int rating, String comment) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("La calificación debe ser entre 1 y 5");
        }
        this.id = id;
        this.user = user;
        this.perfume = perfume;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public User getUser() { return user; }
    public Perfume getPerfume() { return perfume; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }

    public void updateReview(int rating, String comment) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("La calificación debe ser entre 1 y 5");
        }
        this.rating = rating;
        this.comment = comment;
        this.updatedAt = LocalDateTime.now();
    }
}