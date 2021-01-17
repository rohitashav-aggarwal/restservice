package com.example.restservice.controllers;

import com.example.restservice.resources.Contact;
import com.example.restservice.services.ContactViaEmail;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class ContactController {
    private final ContactViaEmail contactViaEmail;
    private static final Logger logger = Logger.getLogger("ContactController.class");

    public ContactController(ContactViaEmail contactViaEmail) {
        this.contactViaEmail = contactViaEmail;
    }

    @PostMapping("/contact")
    public void getContactDetails(@ModelAttribute Contact contact, BindingResult result){
        if(result.hasErrors()){
            logger.info(result.toString());
        }
        logger.info(contact.getMessage() + " " + contact.getName() + " " + contact.getEmail());

        // add validation on email

        // grab data and forward as an email.
        contactViaEmail.sendEmail(contact.getName(), contact.getEmail(), contact.getMessage());

        // return statement for client
    }
}
