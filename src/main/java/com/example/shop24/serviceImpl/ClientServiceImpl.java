package com.example.shop24.serviceImpl;

import com.example.shop24.exceptions.ResourceNotFoundException;
import com.example.shop24.models.Cargo;
import com.example.shop24.models.Client;
import com.example.shop24.repositories.CargoRepository;
import com.example.shop24.repositories.UserRepository;
import com.example.shop24.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final UserRepository userRepository;
    private final CargoRepository cargoRepository;

    public ClientServiceImpl(UserRepository userRepository, CargoRepository cargoRepository) {
        this.userRepository = userRepository;
        this.cargoRepository = cargoRepository;
    }

    @Override
    public List<Client> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Client findById(UUID id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found"));
    }

    @Override
    public List<Cargo> getClosestCargoCompanies(UUID id) throws Exception {
        Client client = findById(id);

        Double north  = client.getLatitude()+0.03;
        Double south =  client.getLatitude()-0.03;
        Double west =  client.getLongitude()-0.03;
        Double east =  client.getLongitude()+0.03;

        return cargoRepository.findAllByLatitudeLessThanAndLatitudeGreaterThanAndLongitudeLessThanAndLongitudeGreaterThan(north, south, west, east);
    }
}
