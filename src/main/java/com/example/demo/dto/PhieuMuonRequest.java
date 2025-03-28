package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhieuMuonRequest {
    private Long assetId;
    private String borrower;
    private Date loanDate;
    private Date expectedReturnDate;
}
