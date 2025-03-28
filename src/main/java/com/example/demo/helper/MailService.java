package com.example.demo.helper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendReminderEmail(String to, String assetName, String dueDate) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(to);
        helper.setSubject("Nhắc hạn trả tài sản");
        helper.setText("<h2>Xin chào,</h2>"
                + "<p>Tài sản <strong>" + assetName + "</strong> của bạn có hạn trả vào ngày <strong>" + dueDate + "</strong>.</p>"
                + "<p>Vui lòng kiểm tra và trả tài sản đúng hạn.</p>", true);

        mailSender.send(message);
    }
}
