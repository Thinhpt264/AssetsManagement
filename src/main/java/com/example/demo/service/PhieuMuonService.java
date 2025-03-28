package com.example.demo.service;

import com.example.demo.dto.PhieuMuonRequest;
import com.example.demo.dto.PhieuMuonResponse;

public interface PhieuMuonService {
    PhieuMuonResponse createPhieuMuon(PhieuMuonRequest request);
    PhieuMuonResponse updatePhieuMuonStatus(Long id, String status);
}
