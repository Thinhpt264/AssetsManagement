package com.example.demo.controller;


import com.example.demo.dto.AssetStatusStatsDTO;
import com.example.demo.entities.Asset;
import com.example.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/asset")
public class AssetStatistics{

    @Autowired
    AssetService service;
    @GetMapping("/statistics")
    public ResponseEntity<?> getAssetStatisticsByStatus() {
        List<AssetStatusStatsDTO> assetStatsList = service.getAssetStatisticsByStatus();
        if (assetStatsList == null || assetStatsList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No asset statistics found");
        }
        return ResponseEntity.ok(assetStatsList);
    }
}
