package com.example.restservice.controllers;

import com.example.restservice.resources.User;
import com.example.restservice.services.AuthService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.logging.Logger;

@RestController
public class SignUpController {

    private final AuthService authService;
    private static final Logger logger = Logger.getLogger("SignUpController.class");

    public SignUpController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public void signUpUser(@ModelAttribute User user, BindingResult result) throws IOException {
        if(result.hasErrors()){
            logger.info(result.toString());
        }
        authService.writeToFile(user.getUsername(), user.getPassword());
    }
}
