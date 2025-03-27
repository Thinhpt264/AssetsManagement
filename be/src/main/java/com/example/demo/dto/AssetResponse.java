package com.example.demo.dto;

import com.example.demo.entities.Asset;

import java.util.List;

public class AssetResponse {
    private String message;
    private List<Asset> assets;

    public AssetResponse(String message, List<Asset> assets) {
        this.message = message;
        this.assets = assets;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }
}
