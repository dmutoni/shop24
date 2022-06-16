package com.example.shop24.models;

import com.example.shop24.enums.EStatus;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "order")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private  Cargo cargo;

    private Double amount;

    private Integer quantity;

    private EStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order() {
    }

    public UUID getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public EStatus getStatus() {
        return status;
    }

    public User getClient() {
        return client;
    }


    public Cargo getCargo() {
        return cargo;
    }
}
