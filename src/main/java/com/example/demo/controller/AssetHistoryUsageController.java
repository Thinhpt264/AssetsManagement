package com.example.demo.controller;

import com.example.demo.dto.AssetHistoryUsageResponse;
import com.example.demo.service.AssetOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/historyUsage")
public class AssetHistoryUsageController {
    @Autowired
    AssetOfficeService service;
    @GetMapping("/{asset_id}/get")
    public ResponseEntity<List<AssetHistoryUsageResponse>> getHistoryUsage(@PathVariable Long asset_id){
        List<AssetHistoryUsageResponse> list=service.getUsageHistory(asset_id);
        return ResponseEntity.ok(list);
    }
}
