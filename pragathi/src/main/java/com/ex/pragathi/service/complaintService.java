package com.ex.pragathi.service;

import com.ex.pragathi.entity.Complaint;
import com.ex.pragathi.repo.complaintRepo;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class complaintService {
    @Autowired
    public JavaMailSender mailSender ;
    @Autowired
    public complaintRepo repo;

    public Complaint sendNotification(Complaint complaint) {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            String[] recipients = {
                    "jayadeepdhanisetti@gmail.com",
                    "vudibhaskar45@gmail.com",
                    "prasannalakshmibh08@gmail.com",
                    "supriyavasamsetti85@gmail.com",
            };

            helper.setTo(recipients);
            helper.setSubject("🚨 New College Complaint Received");

            String htmlContent =
                    "<!DOCTYPE html>" +
                            "<html>" +
                            "<head>" +
                            "  <style>" +
                            "    body { font-family: Arial, sans-serif; background-color: #f4f6f8; padding: 20px; }" +
                            "    .container { background-color: #ffffff; padding: 20px; border-radius: 8px; max-width: 600px; margin: auto; box-shadow: 0 4px 10px rgba(0,0,0,0.1); }" +
                            "    .header { background-color: #b71c1c; color: white; padding: 15px; text-align: center; border-radius: 8px 8px 0 0; }" +
                            "    .content { padding: 20px; }" +
                            "    .label { font-weight: bold; color: #333; }" +
                            "    .complaint { background-color: #fce4ec; padding: 15px; border-left: 5px solid #b71c1c; margin-top: 10px; }" +
                            "    .footer { text-align: center; font-size: 12px; color: #777; margin-top: 20px; }" +
                            "  </style>" +
                            "</head>" +
                            "<body>" +
                            "  <div class='container'>" +
                            "    <div class='header'>" +
                            "      <h2>New Complaint Notification</h2>" +
                            "    </div>" +
                            "    <div class='content'>" +
                            "      <p><span class='label'>Department:</span> " + complaint.getName() + "</p>" +
                            "      <p><span class='label'>Complaint Details:</span></p>" +
                            "      <div class='complaint'>" +
                            "        " + complaint.getComplaintNote() +
                            "      </div>" +
                            "      <p>Please review this complaint and take necessary action.</p>" +
                            "    </div>" +
                            "    <div class='footer'>" +
                            "      © 2025 College Complaint Management System" +
                            "    </div>" +
                            "  </div>" +
                            "</body>" +
                            "</html>";

            helper.setText(htmlContent, true); // true = HTML email

            mailSender.send(message);
            repo.save(complaint);

            return complaint;

        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

}
