package com.pets.petsecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/users")
    public String getUsers() {
        return "users..";
    }

    @GetMapping({"/", "/index", ""})
    public String index() {
        return "users..";
    }


}
