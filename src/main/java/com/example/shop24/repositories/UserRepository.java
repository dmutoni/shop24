package com.example.shop24.repositories;

import com.example.shop24.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Client, UUID> {

}
