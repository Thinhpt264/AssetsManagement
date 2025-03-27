package com.example.demo.repository;

import com.example.demo.entities.Asset;
import com.example.demo.entities.AssetOffice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
    boolean existsById(Long id);
}
