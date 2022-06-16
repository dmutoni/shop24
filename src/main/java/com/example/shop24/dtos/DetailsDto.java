package com.example.shop24.dtos;

import com.example.shop24.models.Order;

import java.util.UUID;

public class DetailsDto {
    private Order order;

    private UUID cargo;

    private UUID drink;

    private Integer quantity;

    private Double amount;

    public DetailsDto() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public UUID getCargo() {
        return cargo;
    }

    public void setCargo(UUID cargo) {
        this.cargo = cargo;
    }

    public UUID getDrink() {
        return drink;
    }

    public void setDrink(UUID drink) {
        this.drink = drink;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
