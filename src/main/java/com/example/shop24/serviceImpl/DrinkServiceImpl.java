package com.example.shop24.serviceImpl;

import com.example.shop24.exceptions.ResourceNotFoundException;
import com.example.shop24.models.Cargo;
import com.example.shop24.models.Drink;
import com.example.shop24.repositories.DrinkRepository;
import com.example.shop24.services.DrinkService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;

    public DrinkServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }

    @Override
    public List<Drink> getConsumedDrinksAndQuantity() {
        return null;
    }

    @Override
    public Drink findById(UUID id) throws Exception {
        return drinkRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found"));
    }

    @Override
    public List<Cargo> getClosestCargoCompanies(UUID id) throws Exception {
        return null;
    }
}
