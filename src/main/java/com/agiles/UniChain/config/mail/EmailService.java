package com.agiles.UniChain.config.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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


            helper.setText(emailContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }


    }


    public void sendAnnouncementEmail(String toEmail, String announcement) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(toEmail);
            helper.setSubject("🚍 UniChain Bus Service Announcement");

            String emailContent = "<html>" +
                    "<body style='font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px;'>" +
                    "<div style='max-width: 600px; margin: auto; background: #ffffff; padding: 20px; border-radius: 10px; " +
                    "box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);'>" +
                    "<h2 style='color: #2c3e50; text-align: center;'>🚍 Important Bus Service Update</h2>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>" +
                    announcement + "</p>" +
                    "<div style='text-align: center; margin-top: 20px;'>" +
                    "<a href='https://unichain-ac-bd.web.app/bus-routes' style='background-color: #2980b9; color: #ffffff; padding: 12px 20px; " +
                    "text-decoration: none; font-weight: bold; border-radius: 5px; display: inline-block;'>Check Updates</a>" +
                    "</div>" +
                    "<br>" +
                    "<p style='font-size: 14px; color: #95a5a6; text-align: center;'>Stay updated with UniChain for all university services.</p>" +
                    "</div>" +
                    "</body>" +
                    "</html>";

            helper.setText(emailContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    public void sendUpcomingEventEmail(String toEmail, String eventTitle, String eventDescription, String eventDate) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(toEmail);
            helper.setSubject("🎉 Exciting Upcoming Event: " + eventTitle);


            String emailContent = "<html>" +
                    "<body style='font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px;'>" +
                    "<div style='max-width: 600px; margin: auto; background: #ffffff; padding: 20px; border-radius: 10px; " +
                    "box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);'>" +
                    "<h2 style='color: #2c3e50; text-align: center;'>🎉 Exciting News! " + eventTitle + " is Coming Soon!</h2>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>We are thrilled to announce an upcoming event that you won’t want to miss!</p>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>Event: <strong>" + eventTitle + "</strong></p>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>Description: " + eventDescription + "</p>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>Date: <strong>" + eventDate + "</strong></p>" +
                    "<div style='text-align: center; margin-top: 20px;'>" +
                    "<a href='https://unichain-ac-bd.web.app/event' style='background-color: #2980b9; color: #ffffff; padding: 12px 20px; " +
                    "text-decoration: none; font-weight: bold; border-radius: 5px; display: inline-block;'>RSVP Now</a>" +
                    "</div>" +
                    "<br>" +
                    "<p style='font-size: 14px; color: #95a5a6; text-align: center;'>Don’t miss out on this exciting opportunity! We can’t wait to see you there!</p>" +
                    "</div>" +
                    "</body>" +
                    "</html>";

            helper.setText(emailContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }


    public void sendUpcomingExamScheduleEmail(String toEmail, String examTitle, Long examDate, LocalDate localDate) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(toEmail);
            helper.setSubject("📅 Upcoming Exam: " + examTitle);


            String formattedExamDate = localDate.toString();


            String emailContent = "<html>" +
                    "<body style='font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px;'>" +
                    "<div style='max-width: 600px; margin: auto; background: #ffffff; padding: 20px; border-radius: 10px; " +
                    "box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);'>" +
                    "<h2 style='color: #2c3e50; text-align: center;'>📅 Upcoming Exam: " + examTitle + "</h2>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>We are excited to inform you about your upcoming exam. Make sure you’re prepared!</p>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>Exam: <strong>" + examTitle + "</strong></p>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>Date: <strong>" + formattedExamDate + "</strong></p>" +
                    "<div style='text-align: center; margin-top: 20px;'>" +
                    "<a href='https://unichain-ac-bd.web.app/exam-schedule' style='background-color: #2980b9; color: #ffffff; padding: 12px 20px; " +
                    "text-decoration: none; font-weight: bold; border-radius: 5px; display: inline-block;'>View Full Schedule</a>" +
                    "</div>" +
                    "<br>" +
                    "<p style='font-size: 14px; color: #95a5a6; text-align: center;'>Prepare well and best of luck! We’re cheering for you!</p>" +
                    "</div>" +
                    "</body>" +
                    "</html>";

            helper.setText(emailContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }




}


