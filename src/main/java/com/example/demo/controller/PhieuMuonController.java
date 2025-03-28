package com.example.demo.controller;

import com.example.demo.dto.PhieuMuonRequest;
import com.example.demo.dto.PhieuMuonResponse;
import com.example.demo.service.PhieuMuonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/phieu-muon")
public class PhieuMuonController {
    @Autowired
    private PhieuMuonService phieuMuonService;

    @PostMapping("/create")
    public ResponseEntity<PhieuMuonResponse> createPhieuMuon(@RequestBody PhieuMuonRequest request) {
        PhieuMuonResponse response = phieuMuonService.createPhieuMuon(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<PhieuMuonResponse> updatePhieuMuonStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        PhieuMuonResponse response = phieuMuonService.updatePhieuMuonStatus(id, status);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
