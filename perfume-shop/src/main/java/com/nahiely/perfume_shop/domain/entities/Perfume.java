package com.nahiely.perfume_shop.domain.entities;

import com.nahiely.perfume_shop.domain.enums.*;
import com.nahiely.perfume_shop.domain.valueobjects.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Perfume {
    private String id;
    private String name;
    private Brand brand;
    private String description;
    private OlfactoryNotes olfactoryNotes;
    private FragranceFamily fragranceFamily;
    private Gender gender;
    private Concentration concentration;
    private Money price;
    private Volume volume;
    private int stock;
    private int releaseYear;
    private ProductStatus status;
    private List<String> images;
    private double averageRating;
    private int reviewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Perfume(String id, String name, Brand brand, String description,
                   OlfactoryNotes olfactoryNotes, FragranceFamily fragranceFamily,
                   Gender gender, Concentration concentration, Money price,
                   Volume volume, int stock, int releaseYear) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.olfactoryNotes = olfactoryNotes;
        this.fragranceFamily = fragranceFamily;
        this.gender = gender;
        this.concentration = concentration;
        this.price = price;
        this.volume = volume;
        this.stock = stock;
        this.releaseYear = releaseYear;
        this.status = ProductStatus.PENDING_REVIEW;
        this.images = new ArrayList<>();
        this.averageRating = 0.0;
        this.reviewCount = 0;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Brand getBrand() { return brand; }
    public Money getPrice() { return price; }
    public int getStock() { return stock; }
    public ProductStatus getStatus() { return status; }

    public void updateStock(int newStock) {
        if (newStock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        this.stock = newStock;
        if (this.stock == 0) {
            this.status = ProductStatus.OUT_OF_STOCK;
        }
        this.updatedAt = LocalDateTime.now();
    }

    public void addReview(int rating) {
        this.averageRating = (this.averageRating * this.reviewCount + rating) / (this.reviewCount + 1);
        this.reviewCount++;
        this.updatedAt = LocalDateTime.now();
    }

    public boolean isAvailable() {
        return status == ProductStatus.ACTIVE && stock > 0;
    }

    public void activate() {
        this.status = ProductStatus.ACTIVE;
        this.updatedAt = LocalDateTime.now();
    }
}