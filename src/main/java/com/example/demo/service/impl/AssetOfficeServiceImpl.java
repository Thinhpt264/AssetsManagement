package com.example.demo.service.impl;

import com.example.demo.dto.AssetHistoryUsageResponse;
import com.example.demo.entities.AssetOffice;
import com.example.demo.repository.AssetOfficeRepository;
import com.example.demo.service.AssetOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetOfficeServiceImpl implements AssetOfficeService {
    @Autowired
    AssetOfficeRepository repository;
    @Override
    public List<AssetHistoryUsageResponse> getUsageHistory(Long id) {
        List<AssetOffice> assetOffices=repository.findAssetOfficeByAssetId(id);
        return assetOffices.stream().map(a->new AssetHistoryUsageResponse(
                a.getOffice().getName(),
                a.getCheckInDate(),
                a.getCheckOutDate(),
                a.getReceiptCode(),
                a.getStatus()
        )).collect(Collectors.toList());
    }
}
