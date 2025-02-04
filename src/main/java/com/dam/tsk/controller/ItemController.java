package com.dam.tsk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {


    @GetMapping("/item")
    public ResponseEntity<String> getItem(){
        return new ResponseEntity<>("It is item controller", HttpStatus.OK);
    }
}

