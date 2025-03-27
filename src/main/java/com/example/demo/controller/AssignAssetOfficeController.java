package com.example.demo.controller;

import com.example.demo.dto.AssetOfficeRequest;
import com.example.demo.entities.AssetOffice;
import com.example.demo.mapper.AssetOfficeMapper;
import com.example.demo.service.AssetOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/assign")
public class AssignAssetOfficeController {
    @Autowired
    AssetOfficeService service;
    @Autowired
    AssetOfficeMapper assetOfficeMapper;

    @PostMapping("/add")
    public ResponseEntity<AssetOffice> addAssetOffice(@RequestBody AssetOfficeRequest request) {
        AssetOffice assetOffice = assetOfficeMapper.mapToEntity(request);
        AssetOffice savedAssetOffice = service.createAssetOffice(assetOffice);
        return ResponseEntity.ok(savedAssetOffice);
    }
}
