package com.example.restservice.controllers;

import com.example.restservice.resources.SignUp;
import com.example.restservice.services.DataStorage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class LogInController {

    private final DataStorage dataStorage;
    private static final Logger logger = Logger.getLogger("LogInController.class");

    public LogInController(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @PostMapping("/login")
    public ResponseEntity sendViaResponseEntity(@ModelAttribute SignUp signUp, BindingResult result) {
        if(result.hasErrors()){
            logger.info(result.toString());
        }
        if(dataStorage.userExists(signUp.getUsername(), signUp.getPassword())){
            logger.info("login successful");
            return new ResponseEntity(HttpStatus.OK);
        }else{
            logger.info("login unsuccessful");
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }
}
