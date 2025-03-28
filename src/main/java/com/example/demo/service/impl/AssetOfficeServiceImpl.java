package com.example.demo.service.impl;

import com.example.demo.entities.*;
import com.example.demo.repository.*;
import com.example.demo.service.AssetOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.AssetHistoryUsageResponse;
import com.example.demo.entities.AssetOffice;
import com.example.demo.repository.AssetOfficeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class AssetOfficeServiceImpl implements AssetOfficeService {
    @Autowired
    AssetOfficeRepository repository;
    @Autowired
    AssetRepository assetRepository;
    @Autowired
    OfficeRepository officeRepository;
    @Autowired
    WarehouseRepository warehouseRepository;


    @Override
    public AssetOffice createAssetOffice(AssetOffice assetOffice) {
        if (assetOffice.getAsset() == null || assetOffice.getOffice() == null) {
            throw new RuntimeException("nullll");
        }
        Asset asset = assetRepository.findById(assetOffice.getAsset().getId().intValue())
                .orElseThrow(() -> new RuntimeException("Asset id: " + assetOffice.getAsset().getId()));
        Office office = officeRepository.findById(assetOffice.getOffice().getId())
                .orElseThrow(() -> new RuntimeException("Office id: " + assetOffice.getOffice().getId()));
        assetOffice.setAsset(asset);
        assetOffice.setOffice(office);
        return repository.save(assetOffice);
    }

    @Override
    public AssetOffice returnAssetOffice(Long assetOfficeId) {
        AssetOffice assetOffice = repository.findById(assetOfficeId)
                .orElseThrow(() -> new RuntimeException("AssetOffice not found with id: " + assetOfficeId));


        if (!"In Use".equals(assetOffice.getStatus())) {
            throw new RuntimeException("Asset is not currently assigned or already returned");
        }


        assetOffice.setCheckOutDate(LocalDate.now());
        assetOffice.setStatus("Returned");



        Asset asset = assetOffice.getAsset();
        asset.setStatus("Available");
        assetRepository.save(asset);

        Warehouse warehouse = warehouseRepository.findByAssetId(asset.getId())
                .orElseThrow(() -> new RuntimeException("Warehouse record not found for asset id: " + asset.getId()));

        warehouse.setAvailable(warehouse.getAvailable() + assetOffice.getCount());
        warehouseRepository.save(warehouse);


        return repository.save(assetOffice);
    }

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

