package com.example.shop24.services;

import com.example.shop24.models.Cargo;
import com.example.shop24.models.Drink;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface DrinkService {
    List<Drink> findAll();
    List<Drink> getConsumedDrinksAndQuantity();
    Drink findById(UUID id) throws Exception;
    List<Cargo> getClosestCargoCompanies(UUID id) throws Exception;
}
