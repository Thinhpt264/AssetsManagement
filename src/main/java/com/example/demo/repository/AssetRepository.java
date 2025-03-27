package com.example.demo.repository;

import com.example.demo.entities.Asset;
import com.example.demo.entities.AssetOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Integer> {


    @Query("SELECT a.status, COUNT(a) FROM Asset a GROUP BY a.status")
    List<Object[]> countAssetsByStatus();

    boolean existsById(Long id);

}
