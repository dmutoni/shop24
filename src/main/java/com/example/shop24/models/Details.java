package com.example.shop24.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "cargo")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Details {
    @Id
    @Column(name = "id", nullable = false)
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "drink_id")
    private Drink drink;

    private Integer quantity;

    private Double amount;

    public Details() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setDrink(Drink drink) {
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

    public Drink getDrink() {
        return drink;
    }


    public Cargo getCargo() {
        return cargo;
    }

    public Order getOrder() {
        return order;
    }
}
