package com.example.demo.repository;

import com.example.demo.entities.AssetOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AssetOfficeRepository extends JpaRepository<AssetOffice, Long> {
    List<AssetOffice> findAssetOfficeByAssetId(Long id);
}
