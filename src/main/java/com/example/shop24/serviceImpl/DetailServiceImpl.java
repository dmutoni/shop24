package com.example.shop24.serviceImpl;

import com.example.shop24.dtos.DetailsDto;
import com.example.shop24.models.Details;
import com.example.shop24.models.Drink;
import com.example.shop24.models.Order;
import com.example.shop24.repositories.DetailsRepository;
import com.example.shop24.services.DetailsService;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements DetailsService {
    private final DetailsRepository detailsRepository;
    private final DrinkServiceImpl drinkService;

    public DetailServiceImpl(DetailsRepository detailsRepository, DrinkServiceImpl drinkService) {
        this.detailsRepository = detailsRepository;
        this.drinkService = drinkService;
    }

    @Override
    public Details saveDetails(DetailsDto dto, Order order) throws Exception {
        Details details = new Details();
        Drink drink = drinkService.findById(dto.getDrink());
        details.setAmount(dto.getAmount());
        details.setQuantity(dto.getQuantity());
        details.setDrink(drink);
        details.setOrder(order);
        return detailsRepository.save(details);
    }
}
