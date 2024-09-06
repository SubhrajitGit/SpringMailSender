package com.subhrajit.springbootemail.controller;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping("/send-email")
    public String sendEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("subhrajitdash43@gmail.com");
            message.setTo("swaindibyajyoti8117@gmail.com");
            message.setSubject("Request For Getting a Valuable Things From You");
            message.setText("Madam Are You a magician?Beacause Whenever i see you everything around me disappeared");
            mailSender.send(message);
        } catch (MailException e) {
            throw new RuntimeException(e);
        }
        return "Message Sent";
    }

    @RequestMapping("/send-email-with-attachment")
    public String sendEmailWithAttachment() {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("subhrajitdash43@gmail.com");
            helper.setTo("swaindibyajyoti8117@gmail.com");
            helper.setSubject("Request For Getting a Valuable Things From You");
            helper.setText("Madam Ji Galti Ho GAyi MAaf Kardo");
            helper.addAttachment("pexels-pincalo-15030608.jpg", new File("C:\\Users\\likun\\Downloads\\pexels-pincalo-15030608.jpg"));
            mailSender.send(message);
        } catch (MailException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "Message Sent";
    }
}
