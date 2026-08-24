package com.nahiely.perfume_shop.domain.entities;

import java.time.LocalDateTime;

public class Brand {
    private String id;
    private String name;
    private String description;
    private int yearFounded;
    private String country;
    private String website;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Brand(String id, String name, String description, int yearFounded, String country) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.yearFounded = yearFounded;
        this.country = country;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getYearFounded() { return yearFounded; }
    public String getCountry() { return country; }
    public String getWebsite() { return website; }

    public void setName(String name) {
        this.name = name;
        this.updatedAt = LocalDateTime.now();
    }

    public void setWebsite(String website) {
        this.website = website;
        this.updatedAt = LocalDateTime.now();
    }

    public int getAge() {
        return LocalDateTime.now().getYear() - yearFounded;
    }
}