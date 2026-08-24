package com.nahiely.perfume_shop.domain.entities;

import com.nahiely.perfume_shop.domain.enums.OrderStatus;
import com.nahiely.perfume_shop.domain.enums.PaymentMethod;
import com.nahiely.perfume_shop.domain.valueobjects.Address;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private User user;
    private Address shippingAddress;
    private PaymentMethod paymentMethod;
    private List<OrderItem> items;
    private OrderStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Order(String id, User user, Address shippingAddress, PaymentMethod paymentMethod) {
        this.id = id;
        this.user = user;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.items = new ArrayList<>();
        this.status = OrderStatus.PENDING;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public User getUser() { return user; }
    public OrderStatus getStatus() { return status; }
    public List<OrderItem> getItems() { return new ArrayList<>(items); }

    public void addItem(Perfume perfume, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        if (quantity > perfume.getStock()) {
            throw new IllegalArgumentException("Stock insuficiente");
        }
        items.add(new OrderItem(perfume, quantity));
        perfume.updateStock(perfume.getStock() - quantity);
        this.updatedAt = LocalDateTime.now();
    }

    public void confirm() {
        if (status != OrderStatus.PENDING) {
            throw new IllegalStateException("Solo pedidos pendientes pueden confirmarse");
        }
        this.status = OrderStatus.CONFIRMED;
        this.updatedAt = LocalDateTime.now();
    }

    public void process() {
        if (status != OrderStatus.CONFIRMED) {
            throw new IllegalStateException("Solo pedidos confirmados pueden procesarse");
        }
        this.status = OrderStatus.PROCESSING;
        this.updatedAt = LocalDateTime.now();
    }

    public void ship() {
        if (status != OrderStatus.PROCESSING) {
            throw new IllegalStateException("Solo pedidos en procesamiento pueden enviarse");
        }
        this.status = OrderStatus.SHIPPED;
        this.updatedAt = LocalDateTime.now();
    }

    public void deliver() {
        if (status != OrderStatus.SHIPPED) {
            throw new IllegalStateException("Solo pedidos enviados pueden entregarse");
        }
        this.status = OrderStatus.DELIVERED;
        this.updatedAt = LocalDateTime.now();
    }

    public void cancel() {
        if (status == OrderStatus.DELIVERED) {
            throw new IllegalStateException("Pedidos entregados no pueden cancelarse");
        }
        this.status = OrderStatus.CANCELLED;
        this.updatedAt = LocalDateTime.now();
    }
}