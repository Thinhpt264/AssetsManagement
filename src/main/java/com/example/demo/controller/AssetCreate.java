package com.example.demo.controller;


import com.example.demo.entities.Asset;
import com.example.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/asset")
public class AssetCreate {

    @Autowired
    AssetService service;
    @PostMapping("/createAsset")
    public ResponseEntity<Object> createAsset(@RequestBody Asset asset) {
        try {
            String result = service.createAsset(asset);
            Map<String, Object> response = new HashMap<>();
            response.put("result", result);

            return new ResponseEntity<>(response,
                    result.equals("Asset saved successfully") ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("result", "Register failed: " + e.getMessage());

            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }


}
