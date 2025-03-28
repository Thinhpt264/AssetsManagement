package com.example.demo.repository;

import com.example.demo.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    Optional<Warehouse> findByAssetId(Long assetId);




}