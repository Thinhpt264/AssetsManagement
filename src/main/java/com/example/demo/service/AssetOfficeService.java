package com.example.demo.service;

import com.example.demo.dto.AssetHistoryUsageResponse;

import java.util.List;

public interface AssetOfficeService {
    List<AssetHistoryUsageResponse> getUsageHistory(Long id);
}
