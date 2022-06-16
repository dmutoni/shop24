package com.example.shop24.serviceImpl;

import com.example.shop24.exceptions.ResourceNotFoundException;
import com.example.shop24.models.Cargo;
import com.example.shop24.models.User;
import com.example.shop24.repositories.CargoRepository;
import com.example.shop24.repositories.UserRepository;
import com.example.shop24.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CargoRepository cargoRepository;

    public UserServiceImpl(UserRepository userRepository, CargoRepository cargoRepository) {
        this.userRepository = userRepository;
        this.cargoRepository = cargoRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(UUID id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<Cargo> getClosestCargoCompanies(UUID id) throws Exception {
        User user = findById(id);

        Double north  = user.getLatitude()+0.03;
        Double south =  user.getLatitude()-0.03;
        Double west =  user.getLongitude()-0.03;
        Double east =  user.getLongitude()+0.03;

        return cargoRepository.findAllByLatitudeLessThanAndLatitudeGreaterThanAndLongitudeLessThanAndLongitudeGreaterThan(north, south, west, east);
    }
}
