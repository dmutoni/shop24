package com.example.shop24.services;

import com.example.shop24.models.Cargo;
import com.example.shop24.models.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ClientService {
    List<Client> findAll();
    Client findById(UUID id) throws Exception;
    List<Cargo> getClosestCargoCompanies(UUID id) throws Exception;
}
