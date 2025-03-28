package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssetStatusStatsDTO {
    private String status;
    private Long count;
}
