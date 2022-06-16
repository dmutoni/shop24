package com.example.shop24.repositories;

import com.example.shop24.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DrinkRepository extends JpaRepository<Drink, UUID> {
}
