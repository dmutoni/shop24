package com.example.shop24.controllers;

import com.example.shop24.dtos.ResponseDto;
import com.example.shop24.models.Client;
import com.example.shop24.models.Drink;
import com.example.shop24.serviceImpl.DrinkServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Controller
@RestController("/drinks")
public class DrinkController {
    private final DrinkServiceImpl drinkService;

    public DrinkController(DrinkServiceImpl drinkService) {
        this.drinkService = drinkService;
    }
    @GetMapping("/all")
    public ResponseEntity<ResponseDto> getAll() {
        List<Drink> drinks = drinkService.findAll();
        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK, "Successfully fetched drinks", drinks), HttpStatus.OK);
    }
    @GetMapping("/:id")
    public ResponseEntity<ResponseDto> getById(@PathVariable UUID id) throws Exception {
        Drink drink = drinkService.findById(id);
        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK, "Successfully fetched drinks", drink), HttpStatus.OK);
    }

}
