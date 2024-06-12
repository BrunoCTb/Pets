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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @PostMapping("/register")
    public String createUser(@ModelAttribute @Valid RegisterDto data, Model model) throws IllegalArgumentException {
        String passwordMatchesString = null;

        if (userService.findByEmail(data.getEmail()) != null) {
            model.addAttribute("findUser", "Email já cadastrado!");
            return "register";
        }

        if (!data.getPassword().equals(data.getConfirmPassword())) {
            passwordMatchesString = "As senhas não são iguais!";
            model.addAttribute("passwordMatches", passwordMatchesString);
            return "register";
        }

        Role roleUser = roleService.findById(1L).get();
        String encode = new BCryptPasswordEncoder().encode(data.getPassword());
        User user = new User(data.getFirstName(), data.getLastName(), data.getEmail(),
                encode, data.getTel(), Set.of(roleUser));
//        userService.save(user);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

}
