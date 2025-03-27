package com.example.demo.service;
import com.example.demo.dto.AssetHistoryUsageResponse;
import com.example.demo.entities.AssetOffice;

import java.util.List;

public interface AssetOfficeService {
    List<AssetHistoryUsageResponse> getUsageHistory(Long id);
    AssetOffice createAssetOffice(AssetOffice assetOffice);
    AssetOffice returnAssetOffice(Long assetOfficeId);

}
