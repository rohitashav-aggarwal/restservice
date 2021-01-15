package com.example.restservice.controllers;

import com.example.restservice.resources.Contact;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class ContactController {
    private static final Logger logger = Logger.getLogger("ContactController.class");

    @PostMapping("/contact")
    public void getContactDetails(@ModelAttribute Contact contact, BindingResult result){
        if(result.hasErrors()){
            logger.info(result.toString());
        }
        logger.info(contact.getMessage() + " " + contact.getName() + " " + contact.getEmail());

        // add validation on email and message
        // grab data and forward as an email.
    }
}
