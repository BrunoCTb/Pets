package com.pets.petsecommerce.controller;

import com.pets.petsecommerce.dto.RegisterDto;
import com.pets.petsecommerce.model.entity.Role;
import com.pets.petsecommerce.model.entity.User;
import com.pets.petsecommerce.service.RoleService;
import com.pets.petsecommerce.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class RegisterController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @PostMapping("/register")
    public String createUser(@RequestBody RegisterDto data) throws IllegalArgumentException {
        if (userService.findByUsernameOrEmail(data.username(), data.email()) != null) {
            throw new IllegalArgumentException("Nome de usuário ou email já existente!");
        }

        Role roleUser = roleService.findById(1L).get();
        User user = new User(data.username(), data.email(), data.password(), Set.of(roleUser));
        userService.save(user);

        return data.toString();
    }



}
