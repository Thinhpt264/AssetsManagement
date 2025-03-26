package com.example.demo.controller;

import com.example.demo.dto.AssetResponse;
import com.example.demo.dto.AssetStatusStatsDTO;
import com.example.demo.entities.Asset;
import com.example.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/asset")
public class AssetController {
    @Autowired
    AssetService service;
    @GetMapping("/getAssets")
    public ResponseEntity<AssetResponse> getAssets(){
        List<Asset> assets=service.getAllAssets();
        if(assets==null||assets.isEmpty()){
            AssetResponse response=new AssetResponse("not found", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        AssetResponse response = new AssetResponse("founded", assets);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/updateAsset/{id}")
    public ResponseEntity<String> updateAsset(@PathVariable Long id, @RequestBody Asset asset){
        return new ResponseEntity<>(service.updateAsset(id, asset), HttpStatus.OK);
    }
    @DeleteMapping("/deleteAsset/{id}")
    public ResponseEntity<String> deleteAsset(@PathVariable Long id) {
        boolean isDeleted = service.deleteAsset(id);
        if (!isDeleted) {
            return new ResponseEntity<>("Asset not found or could not be deleted", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Asset deleted successfully", HttpStatus.OK);
    }

    @PostMapping("/createAsset")
    public ResponseEntity<String> createAsset(@RequestBody Asset asset){
        try {
            String result = service.createAsset(asset);
            if(result.equals("Asset saved successfully")){
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>("register failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/statistics")
    public ResponseEntity<?> getAssetStatisticsByStatus() {
        List<AssetStatusStatsDTO> assetStatsList = service.getAssetStatisticsByStatus();
        if (assetStatsList == null || assetStatsList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No asset statistics found");
        }
        return ResponseEntity.ok(assetStatsList);
    }

}
