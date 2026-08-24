package com.nahiely.perfume_shop.domain.entities;

public class OrderItem {
    private Perfume perfume;
    private int quantity;

    public OrderItem(Perfume perfume, int quantity) {
        this.perfume = perfume;
        this.quantity = quantity;
    }

    public Perfume getPerfume() { return perfume; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        this.quantity = quantity;
    }
}