package com.example.shop24.controllers;

import com.example.shop24.dtos.ResponseDto;
import com.example.shop24.models.Cargo;
import com.example.shop24.models.Details;
import com.example.shop24.serviceImpl.CargoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@RestController("/orders")
public class CargoController {
    private final CargoServiceImpl cargoService;

    public CargoController(CargoServiceImpl cargoService) {
        this.cargoService = cargoService;
    }
    @GetMapping("/all")
    public ResponseEntity<ResponseDto> getAll() {
        List<Cargo> cargo = cargoService.findAll();
        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK, "Successfully fetched cargos", cargo), HttpStatus.OK);
    }
    @GetMapping("/:id")
    public ResponseEntity<ResponseDto> getById(@PathVariable UUID id) throws Exception {
        Cargo cargo = cargoService.findById(id);
        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK, "Successfully fetched cargos", cargo), HttpStatus.OK);
    }
    @GetMapping("/:id")
    public ResponseEntity<ResponseDto> getOrdersInSpecificRange(@PathVariable UUID id, LocalDateTime from, LocalDateTime to) throws Exception {
        List<Details> details = cargoService.getBySpecificRange(id, from, to);
        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK, "Successfully fetched cargos", details), HttpStatus.OK);
    }
}
