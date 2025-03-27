package com.example.demo.controller;

import com.example.demo.dto.AssetResponse;
import com.example.demo.dto.AssetStatusStatsDTO;
import com.example.demo.entities.Asset;
import com.example.demo.service.AssetService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/asset")
public class AssetController {
    @Autowired
    AssetService service;

    // Các phương thức hiện tại không thay đổi

    @GetMapping("/getAssets")
    public ResponseEntity<AssetResponse> getAssets() {
        List<Asset> assets = service.getAllAssets();
        if (assets == null || assets.isEmpty()) {
            AssetResponse response = new AssetResponse("not found", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        AssetResponse response = new AssetResponse("founded", assets);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/updateAsset/{id}")
    public ResponseEntity<String> updateAsset(@PathVariable Long id, @RequestBody Asset asset) {
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


    // Thêm phương thức xuất báo cáo tài sản ra file Excel
    @GetMapping("/exportToExcel")
    public ResponseEntity<byte[]> exportAssetsToExcel() throws IOException {
        List<Asset> assets = service.getAllAssets();
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Assets");

        // Tạo header cho file Excel
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Tên Tài Sản");
        headerRow.createCell(2).setCellValue("Loại");
        headerRow.createCell(3).setCellValue("Giá");
        headerRow.createCell(4).setCellValue("Trạng Thái");

        // Điền dữ liệu vào các hàng trong Excel
        int rowNum = 1;
        for (Asset asset : assets) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(asset.getId());
            row.createCell(1).setCellValue(asset.getName());
            row.createCell(2).setCellValue(asset.getType());
            row.createCell(3).setCellValue(asset.getPrice());
            row.createCell(4).setCellValue(asset.getStatus());
        }

        // Chuyển file Excel vào bộ nhớ và trả về dưới dạng byte array
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        workbook.write(bos);
        byte[] excelFile = bos.toByteArray();

        // Thiết lập header cho HTTP response và trả về file Excel
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=assets_report.xlsx");
        return new ResponseEntity<>(excelFile, headers, HttpStatus.OK);
    }
}
