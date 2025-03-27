package com.example.demo.controller;

import com.example.demo.dto.AssetStatisticsByDepartmentController;
import com.example.demo.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/asset")
public class AssetByDepartmentController {

    @Autowired
    private AssetRepository assetRepository;

    public AssetByDepartmentController(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }


    @GetMapping("/statistics")
    public List<AssetStatisticsByDepartmentController> getAssetStatisticsByDepartment() {
        return assetRepository.getAssetStatisticsByDepartment();
    }
}

