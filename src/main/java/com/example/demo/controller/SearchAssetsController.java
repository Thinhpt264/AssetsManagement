package com.example.demo.controller;

import com.example.demo.dto.AssetResponse;
import com.example.demo.entities.Asset;
import com.example.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/asset")
public class SearchAssetsController {
    @Autowired
    AssetService service;

    @GetMapping("/search")
    public ResponseEntity<AssetResponse> searchAssets(@RequestParam String name) {
        List<Asset> assets = service.searchAssetsByName(name);
        if (assets == null || assets.isEmpty()) {
            return new ResponseEntity<>(new AssetResponse("not found", null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new AssetResponse("founded", assets), HttpStatus.OK);
    }

}
