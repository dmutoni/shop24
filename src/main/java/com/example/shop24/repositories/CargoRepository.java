package com.example.shop24.repositories;

import com.example.shop24.models.Cargo;
import com.example.shop24.models.Details;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CargoRepository extends JpaRepository<Cargo, UUID> {
    List<Cargo> findAllByLatitudeLessThanAndLatitudeGreaterThanAndLongitudeLessThanAndLongitudeGreaterThan(Double north, Double south, Double west, Double east);
}
