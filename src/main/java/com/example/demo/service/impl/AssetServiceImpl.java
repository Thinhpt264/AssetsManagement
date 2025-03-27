package com.example.demo.service.impl;

import com.example.demo.dto.AssetOfficeRequest;
import com.example.demo.dto.AssetResponse;
import com.example.demo.entities.Asset;
import com.example.demo.repository.AssetRepository;
import com.example.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssetServiceImpl implements AssetService {
    @Autowired
    private AssetRepository repository;
    @Override
    public List<Asset> getAllAssets() {
        return repository.findAll();
    }

    @Override
    public String updateAsset(Long id, Asset asset) {
        Optional<Asset> optionalAsset =repository.findById(id.intValue());
        if(optionalAsset.isEmpty()){
            return "not found";
        }
        repository.save(asset);
        return "successfully";
    }

    @Override
    public boolean deleteAsset(Long id) {
        Optional<Asset> asset = repository.findById(id.intValue());
        if (asset.isPresent()) {
            repository.delete(asset.get());
            return true;
        }
        return false;
    }

    @Override
    public AssetResponse getActiveWarrantyAssets() {
        LocalDate today = LocalDate.now();


        List<Asset> activeAssets = repository.findByWarrantyExpiryDateGreaterThanEqual(today);

        String message;
        if (activeAssets.isEmpty()) {
            message = "not found assets actively";
        } else {
            message = String.format("found %d asset active (take into account %s)",
                    activeAssets.size(),
                    today.toString());
        }

        return new AssetResponse(message, activeAssets);
    }


    @Override
    public AssetResponse getExpiredWarrantyAssets() {
        LocalDate today = LocalDate.now();

        List<Asset> expiredAssets =  repository.findByWarrantyExpiryDateBefore(today);

        String message;
        if (expiredAssets.isEmpty()) {
            message = "not found assets expired ";
        } else {
            message = String.format("found %d asset expired (take into account %s)",
                    expiredAssets.size(),
                    today.toString());
        }

        return new AssetResponse(message, expiredAssets);
    }

}
