package com.dam.tsk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @GetMapping("/user-login")
    public ResponseEntity<String> userLogin(){
        return new ResponseEntity<>("It is user login controller", HttpStatus.OK);
    }
}

