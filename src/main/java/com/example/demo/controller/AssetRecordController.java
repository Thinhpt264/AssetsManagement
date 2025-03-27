package com.example.demo.controller;


import com.example.demo.dto.AssetResponse;
import com.example.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/asset")
public class AssetRecordController {
    @Autowired
    AssetService service;

    @GetMapping("/warranty/active")
    public ResponseEntity<AssetResponse> getExpiringWarrantyAssets() {
        AssetResponse response = service.getActiveWarrantyAssets();

        if (response.getAssets() == null || response.getAssets().isEmpty()) {
            return new ResponseEntity<>(
                    new AssetResponse("No active warranty assets found", null),
                    HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                new AssetResponse("Found active warranty assets", response.getAssets()),
                HttpStatus.OK
        );
    }
    @GetMapping("/warranty/expired")
    public ResponseEntity<AssetResponse> getExpiredWarrantyAssets() {
        AssetResponse response = service.getExpiredWarrantyAssets();

        if (response.getAssets() == null || response.getAssets().isEmpty()) {
            return new ResponseEntity<>(
                    new AssetResponse("No expired warranty assets found", null),
                    HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                new AssetResponse("Found expired warranty assets", response.getAssets()),
                HttpStatus.OK
        );
    }
}
