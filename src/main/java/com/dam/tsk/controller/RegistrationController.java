package com.dam.tsk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {



    @GetMapping("/registration")
    public ResponseEntity<String> userRegistration(){
        return new ResponseEntity<>("It is registration controller", HttpStatus.OK);
    }
}

