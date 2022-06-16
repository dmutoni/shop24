package com.example.shop24.dtos;

import java.util.List;
import java.util.UUID;

public class CargoDto extends AddressDto{
    private Integer quantity;
    private Double totalCost;
    private List<DetailsDto> details;

    public CargoDto() {
    }

    public List<DetailsDto> getDetails() {
        return details;
    }

    public void setDetails(List<DetailsDto> details) {
        this.details = details;
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
