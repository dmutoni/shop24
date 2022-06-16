package com.example.shop24.services;

import com.example.shop24.exceptions.ResourceNotFoundException;
import com.example.shop24.models.Cargo;
import com.example.shop24.models.Details;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface CargoService {
    List<Cargo> findAll();
    Cargo findById(UUID id) throws ResourceNotFoundException;
    List<Details> getBySpecificRange(UUID id, LocalDateTime startDate, LocalDateTime endDate) throws ResourceNotFoundException;
}
