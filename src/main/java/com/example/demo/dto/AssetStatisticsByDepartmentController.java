package com.example.demo.dto;

public class AssetStatisticsByDepartmentController {
    private Long departmentId;
    private String departmentName;
    private Long totalAssets;
    private Long totalQuantity;

    public AssetStatisticsByDepartmentController(Long departmentId, String departmentName, Long totalAssets, Long totalQuantity) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.totalAssets = totalAssets;
        this.totalQuantity = totalQuantity;
    }

    public Long getDepartmentId() { return departmentId; }
    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public Long getTotalAssets() { return totalAssets; }
    public void setTotalAssets(Long totalAssets) { this.totalAssets = totalAssets; }

    public Long getTotalQuantity() { return totalQuantity; }
    public void setTotalQuantity(Long totalQuantity) { this.totalQuantity = totalQuantity; }
}

