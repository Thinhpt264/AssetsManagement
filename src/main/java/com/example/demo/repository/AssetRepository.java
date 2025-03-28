package com.example.demo.repository;

import com.example.demo.dto.AssetResponse;
import com.example.demo.entities.Asset;
import com.example.demo.entities.AssetOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import java.time.LocalDate;
import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Integer> {


    @Query("SELECT a.status, COUNT(a) FROM Asset a GROUP BY a.status")
    List<Object[]> countAssetsByStatus();

    boolean existsById(Long id);



    List<Asset> findByWarrantyExpiryDateBefore(LocalDate date);
    List<Asset> findByWarrantyExpiryDateGreaterThanEqual(LocalDate date);
    List<Asset> findByNameContainingIgnoreCase(String name);
}
