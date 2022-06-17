package com.example.shop24.repositories;

import com.example.shop24.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, UUID> {
}
