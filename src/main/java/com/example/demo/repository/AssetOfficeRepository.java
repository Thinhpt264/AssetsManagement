package com.example.demo.repository;

import com.example.demo.entities.AssetOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AssetOfficeRepository extends JpaRepository<AssetOffice, Long> {
    List<AssetOffice> findAssetOfficeByAssetId(Long id);
    @Query("SELECT a FROM AssetOffice a WHERE a.checkOutDate = :dueDate")
    List<AssetOffice> findAssetsDueSoon(@Param("dueDate") LocalDate dueDate);

}
