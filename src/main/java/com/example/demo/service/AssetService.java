package com.example.demo.service;

import com.example.demo.entities.Asset;

import java.util.List;

public interface AssetService {
    List<Asset> getAllAssets();
    String updateAsset(Long id, Asset asset);
    boolean deleteAsset(Long id);
    List<Asset> searchAssetsByName(String name);
}
