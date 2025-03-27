package com.example.demo.mapper;

import com.example.demo.dto.AssetOfficeRequest;
import com.example.demo.entities.Asset;
import com.example.demo.entities.AssetOffice;
import com.example.demo.entities.Office;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssetOfficeMapper {
    @Autowired
    AssetRepository assetRepository;
    @Autowired
    OfficeRepository officeRepository;

    public AssetOffice mapToEntity(AssetOfficeRequest request) {
        return getAssetOffice(request, assetRepository, officeRepository);
    }

    public static AssetOffice getAssetOffice(AssetOfficeRequest request, AssetRepository assetRepository, OfficeRepository officeRepository) {
        Asset asset = assetRepository.findById(request.getAssetId().intValue())
                .orElseThrow(() -> new RuntimeException("Asset id" + request.getAssetId()));

        Office office = officeRepository.findById(request.getOfficeId())
                .orElseThrow(() -> new RuntimeException("Office id " + request.getOfficeId()));

        AssetOffice assetOffice = new AssetOffice();
        assetOffice.setAsset(asset);
        assetOffice.setOffice(office);
        assetOffice.setCheckInDate(request.getCheckInDate());
        assetOffice.setCheckOutDate(request.getCheckOutDate());
        assetOffice.setCount(request.getCount());
        assetOffice.setReceiptCode(request.getReceiptCode());
        assetOffice.setStatus(request.getStatus());

        return assetOffice;
    }
}