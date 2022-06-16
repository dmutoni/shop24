package com.example.shop24.services;

import com.example.shop24.models.Cargo;
import com.example.shop24.models.User;
import com.example.shop24.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface UserService {
    List<User> findAll();
    User findById(UUID id) throws Exception;
    List<Cargo> getClosestCargoCompanies(UUID id) throws Exception;
}
