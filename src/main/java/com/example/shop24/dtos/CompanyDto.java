package com.example.shop24.dtos;

import com.example.shop24.models.User;

public class CompanyDto {
    private String name;

    private String address;

    private User owner;

    public CompanyDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
