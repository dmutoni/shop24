package com.example.shop24.repositories;

import com.example.shop24.models.Cargo;
import com.example.shop24.models.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface DetailsRepository extends JpaRepository<Details, UUID> {
    List<Details> findAllDetailsByCargoAndCreatedAtAfterAndCreatedAtBefore(Cargo cargo, LocalDateTime from, LocalDateTime to);

    @Query(nativeQuery = true, value = "SELECT * fr")
    List<Details> findMostConsumed();
}
