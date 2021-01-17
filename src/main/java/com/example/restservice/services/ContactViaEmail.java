package com.example.restservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class ContactViaEmail {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(String name, String email, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email);
        message.setTo("softdev414@gmail.com");
        message.setSubject("Online Shopping Platform Request from: " + name);
        message.setText(text);
        emailSender.send(message);
    }
}
