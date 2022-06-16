package com.example.shop24.repositories;

import com.example.shop24.models.Details;
import com.example.shop24.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DetailsRepository extends JpaRepository<UUID, Details> {
}
