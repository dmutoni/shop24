package com.example.shop24.serviceImpl;

import com.example.shop24.exceptions.ResourceNotFoundException;
import com.example.shop24.models.Cargo;
import com.example.shop24.models.Details;
import com.example.shop24.repositories.CargoRepository;
import com.example.shop24.repositories.DetailsRepository;
import com.example.shop24.services.CargoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;
    private final DetailsRepository detailsRepository;

    public CargoServiceImpl(CargoRepository cargoRepository, DetailsRepository detailsRepository) {
        this.cargoRepository = cargoRepository;
        this.detailsRepository = detailsRepository;
    }


    @Override
    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }

    @Override
    public Cargo findById(UUID id) throws ResourceNotFoundException {
        return cargoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found"));
    }

    @Override
    public List<Details> getBySpecificRange(UUID id, LocalDateTime start, LocalDateTime to) throws ResourceNotFoundException {
        Cargo cargo = findById(id);
        return detailsRepository.findAllDetailsByCargoAndCreatedAtAfterAndCreatedAtBefore(cargo,start,to);
    }
}
