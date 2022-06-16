package com.example.shop24.models;

import com.example.shop24.enums.EStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
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

    private EStatus status = EStatus.PENDING;

    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
//    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonBackReference(value = "orderDetails")
    private final Set<Details> orderDetails = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

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

    public Client getClient() {
        return client;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public Set<Details> getOrderDetails() {
        return orderDetails;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
