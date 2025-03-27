package com.example.demo.dto;

import com.example.demo.entities.Asset;
import com.example.demo.entities.Office;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

public class AssetOfficeRequest {
    private Long assetId;
    private Long officeId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int count;
    private String receiptCode;
    private String status;

    public AssetOfficeRequest(Long assetId, Long officeId, LocalDate checkInDate, LocalDate checkOutDate, int count, String receiptCode, String status) {
        this.assetId = assetId;
        this.officeId = officeId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.count = count;
        this.receiptCode = receiptCode;
        this.status = status;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
