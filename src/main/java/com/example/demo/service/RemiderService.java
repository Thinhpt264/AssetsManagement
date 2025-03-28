package com.example.demo.service;

import com.example.demo.entities.AssetOffice;
import com.example.demo.helper.MailService;
import com.example.demo.repository.AssetOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class RemiderService {

    @Autowired
    private AssetOfficeRepository assetOfficeRepository;

    @Autowired
    private MailService mailService;

    @Scheduled(cron = "0 0 8 * * ?") // Chạy lúc 8:00 AM mỗi ngày
    public void checkDueDatesAndSendReminders() {
        LocalDate dueDate = LocalDate.now().plusDays(3); // Ngày sắp hết hạn

        List<AssetOffice> assetsDueSoon = assetOfficeRepository.findAssetsDueSoon(dueDate);

        for (AssetOffice asset : assetsDueSoon) {
            try {
                mailService.sendReminderEmail(asset.getOffice().getContact(),
                        asset.getAsset().getName(),
                        asset.getCheckOutDate().toString());
            } catch (Exception e) {
                System.err.println("Lỗi gửi email: " + e.getMessage());
            }
        }
    }
}

