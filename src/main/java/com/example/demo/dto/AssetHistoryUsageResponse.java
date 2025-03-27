package com.example.demo.dto;

import java.time.LocalDate;

public class AssetHistoryUsageResponse {
    private String officeName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String receiptCode;
    private String status;

    public AssetHistoryUsageResponse(String officeName, LocalDate checkInDate, LocalDate checkOutDate, String receiptCode, String status) {
        this.officeName = officeName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.receiptCode = receiptCode;
        this.status = status;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
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
