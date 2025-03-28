package com.example.demo.service.impl;

import com.example.demo.dto.PhieuMuonRequest;
import com.example.demo.dto.PhieuMuonResponse;
import com.example.demo.entities.Asset;
import com.example.demo.entities.PhieuMuon;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.PhieuMuonRepository;
import com.example.demo.service.PhieuMuonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhieuMuonServiceImpl implements PhieuMuonService {
    @Autowired
    private PhieuMuonRepository phieuMuonRepository;

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public PhieuMuonResponse createPhieuMuon(PhieuMuonRequest request) {
        Optional<Asset> assetOpt = assetRepository.findById(request.getAssetId().intValue());

        if (assetOpt.isEmpty()) {
            return new PhieuMuonResponse("Asset not found");
        }

        // Kiểm tra thông tin bắt buộc
        if (request.getBorrower() == null || request.getBorrower().isEmpty()) {
            return new PhieuMuonResponse("Borrower information is required");
        }
        if (request.getLoanDate() == null || request.getExpectedReturnDate() == null) {
            return new PhieuMuonResponse("Loan date and expected return date are required");
        }

        PhieuMuon phieuMuon = new PhieuMuon();
        phieuMuon.setAsset(assetOpt.get());
        phieuMuon.setBorrower(request.getBorrower());
        phieuMuon.setLoanDate(request.getLoanDate());
        phieuMuon.setExpectedReturnDate(request.getExpectedReturnDate());
        phieuMuon.setStatus("pending");

        phieuMuonRepository.save(phieuMuon);
        return new PhieuMuonResponse("Loan request created successfully");
    }

    @Override
    public PhieuMuonResponse updatePhieuMuonStatus(Long id, String status) {
        Optional<PhieuMuon> phieuMuonOpt = phieuMuonRepository.findById(id);
        if (phieuMuonOpt.isEmpty()) {
            return new PhieuMuonResponse("Loan request not found");
        }

        // Kiểm tra trạng thái hợp lệ
        List<String> validStatuses = List.of("returned", "overdue", "lost", "damaged");
        if (!validStatuses.contains(status)) {
            return new PhieuMuonResponse("Invalid status value");
        }

        PhieuMuon phieuMuon = phieuMuonOpt.get();
        phieuMuon.setStatus(status);
        phieuMuonRepository.save(phieuMuon);
        return new PhieuMuonResponse("Loan status updated successfully");
    }
}
