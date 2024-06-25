package com.pets.petsecommerce.controller.main;

import com.pets.petsecommerce.model.entity.user.User;
import com.pets.petsecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    public UserService userService;

    @GetMapping("/users")
    public List<User> showUsers() {
        return userService.findAll();
    }
}
