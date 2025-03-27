package com.example.demo.repository;

import com.example.demo.dto.AssetStatisticsByDepartmentController;
import com.example.demo.entities.Asset;
import com.example.demo.entities.AssetOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
    boolean existsById(Long id);
    @Query("SELECT new com.example.demo.dto.AssetStatisticsByDepartmentController(o.id, o.name, COUNT(a.id), SUM(ao.count)) " +
            "FROM Office o " +
            "LEFT JOIN AssetOffice ao ON o.id = ao.office.id " +
            "LEFT JOIN Asset a ON ao.asset.id = a.id " +
            "GROUP BY o.id, o.name " +
            "ORDER BY SUM(ao.count) DESC")
    List<AssetStatisticsByDepartmentController> getAssetStatisticsByDepartment();

}
