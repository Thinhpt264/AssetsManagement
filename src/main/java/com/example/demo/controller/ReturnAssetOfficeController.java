package com.example.demo.controller;


import com.example.demo.dto.AssetOfficeRequest;
import com.example.demo.entities.AssetOffice;
import com.example.demo.mapper.AssetOfficeMapper;
import com.example.demo.service.AssetOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/assign")
public class ReturnAssetOfficeController {
    @Autowired
    AssetOfficeService service;
    @Autowired
    AssetOfficeMapper assetOfficeMapper;
    @PostMapping("/{id}/return")
    public ResponseEntity<AssetOffice> returnAssetOffice(@PathVariable Long id) {

        AssetOffice returnedAssetOffice = service.returnAssetOffice(id);
        return ResponseEntity.ok(returnedAssetOffice);
    }
}

