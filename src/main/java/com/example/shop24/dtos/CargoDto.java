package com.example.shop24.dtos;

import java.util.UUID;

public class CargoDto {
    private UUID company;
    private Integer quantity;
    private Double totalCost;

    public CargoDto() {
    }

    public UUID getCompany() {
        return company;
    }

    public void setCompany(UUID company) {
        this.company = company;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
