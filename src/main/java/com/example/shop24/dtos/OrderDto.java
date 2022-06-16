package com.example.shop24.dtos;

import com.example.shop24.enums.EStatus;

import java.util.UUID;

public class OrderDto {
    private UUID cargo;

    private Double amount;

    private Integer quantity;

    private EStatus status;

    private UUID client;

    public OrderDto() {
    }

    public UUID getCargo() {
        return cargo;
    }

    public void setCargo(UUID cargo) {
        this.cargo = cargo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public UUID getClient() {
        return client;
    }

    public void setClient(UUID client) {
        this.client = client;
    }
}
