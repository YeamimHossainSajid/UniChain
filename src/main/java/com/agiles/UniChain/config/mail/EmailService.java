package com.agiles.UniChain.config.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOtpEmail(String toEmail, String otp) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(toEmail);
            helper.setSubject("UniChain: Your OTP Code for Registration");

            String emailContent = "<html>" +
                    "<body style='font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px;'>" +
                    "<h2 style='color: #2c3e50; text-align: center;'>Welcome to UniChain!</h2>" +
                    "<p style='font-size: 16px; color: #34495e;'>Thank you for choosing UniChain, your all-in-one university platform. With UniChain, you can easily manage all aspects of your university life, from academic details to campus services. We're excited to have you as part of our community!</p>" +
                    "<p style='font-size: 16px; color: #34495e;'>To complete your registration, please use the One-Time Password (OTP) below:</p>" +
                    "<h3 style='font-size: 32px; color: #2980b9; font-weight: bold; text-align: center;'>"
                    + otp + "</h3>" +
                    "<p style='font-size: 16px; color: #34495e;'>This OTP is valid for 5 minutes, and it's required to verify your account. If you did not request this, please ignore this email or contact support.</p>" +
                    "<br>" +
                    "<p style='font-size: 16px; color: #34495e;'>Best regards,</p>" +
                    "<p style='font-size: 16px; color: #34495e;'>The UniChain Team</p>" +
                    "<footer style='font-size: 12px; color: #95a5a6; text-align: center;'>" +
                    "UniChain | Empowering Students with Seamless University Management</footer>" +
                    "</body>" +
                    "</html>";


            helper.setText(emailContent, true);  // Set HTML content
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }
}


