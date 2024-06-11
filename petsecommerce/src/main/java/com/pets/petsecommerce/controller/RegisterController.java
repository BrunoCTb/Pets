package com.pets.petsecommerce.controller;

import com.pets.petsecommerce.dto.RegisterDto;
import com.pets.petsecommerce.model.entity.user.Role;
import com.pets.petsecommerce.model.entity.user.User;
import com.pets.petsecommerce.service.RoleService;
import com.pets.petsecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @PostMapping("/register")
    public String createUser(@ModelAttribute @Valid RegisterDto data) throws IllegalArgumentException {
        if (userService.findByEmail(data.getEmail()) != null) {
            return "register";
        }

        Role roleUser = roleService.findById(1L).get();
        String encode = new BCryptPasswordEncoder().encode(data.getPassword());
        User user = new User(data.getFirstName(), data.getLastName(), data.getEmail(),
                data.getPassword(), data.getTel(), Set.of(roleUser));
        userService.save(user);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

}
