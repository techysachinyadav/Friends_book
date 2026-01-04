package com.FriendsBook.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class ServerTest {
    @GetMapping

    public ResponseEntity<String> serverTesting(){
        return new ResponseEntity<>("hello dipanshu ...", HttpStatusCode.valueOf(200));
    }

}
