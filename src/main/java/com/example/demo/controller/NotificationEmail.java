package com.example.demo.controller;

import com.example.demo.dto.MailRequestDTO;
import com.example.demo.helper.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/assets")
public class NotificationEmail {

    @Autowired
    private MailService mailService;


    @PostMapping(value = "/sendmailReturnRemiders")
    public ResponseEntity<Map<String, String>> sendMailReturnRemiders(@RequestBody MailRequestDTO mailRequestDTO) {
        Map<String, String> response = new HashMap<>();
        try {
            mailService.sendReminderEmail(mailRequestDTO.getEmail(), mailRequestDTO.getSubject(), mailRequestDTO.getMessage());
            response.put("result", "send mail done");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("result", "send mail failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}


