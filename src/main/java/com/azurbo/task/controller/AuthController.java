package com.azurbo.task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/security")
public class AuthController {

    //Guest page
    @GetMapping(value= "/guest")
    public ResponseEntity<String> guest() {
        System.out.println("This is the guest page.");
        return new ResponseEntity<>("Guest page!", HttpStatus.OK);
    }

    //Admin page
    @GetMapping(value= "/admin")
    public ResponseEntity<String> admin() {
        System.out.println("This is the administration page.");
        return new ResponseEntity<>("Secure/admin page!", HttpStatus.OK);
    }
}