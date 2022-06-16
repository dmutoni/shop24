package com.example.shop24.repositories;

import com.example.shop24.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<UUID, Address> {
}
