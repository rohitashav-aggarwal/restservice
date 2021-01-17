package com.example.restservice.controllers;

import com.example.restservice.resources.User;
import com.example.restservice.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class LogInController {

    private final AuthService authService;
    private static final Logger logger = Logger.getLogger("LogInController.class");

    public LogInController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity sendViaResponseEntity(@ModelAttribute User user, BindingResult result) {
        if(result.hasErrors()){
            logger.info(result.toString());
        }
        if(authService.userExists(user.getUsername(), user.getPassword())){
            logger.info("login successful");
            return new ResponseEntity(HttpStatus.OK);
        }else{
            logger.info("login unsuccessful");
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }
}
