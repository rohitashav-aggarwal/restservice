package com.example.restservice.controllers;

import com.example.restservice.resources.SignUp;
import com.example.restservice.services.DataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.logging.Logger;

@RestController
public class SignUpController {

    private final DataStorage dataStorage;
    private static final Logger logger = Logger.getLogger("SignUpController.class");

    public SignUpController(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @PostMapping("/signup")
    public void signUpUser(@ModelAttribute SignUp signUp, BindingResult result) throws IOException {
        if(result.hasErrors()){
            logger.info(result.toString());
        }
        dataStorage.writeToFile(signUp.getUsername(), signUp.getPassword());
    }
}
