package com.pets.petsecommerce.controller.admin;

import com.pets.petsecommerce.model.entity.user.User;
import com.pets.petsecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping({"/", "/home", ""})
    public String home() {
        return "admin/home";
    }

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @GetMapping("/users/all")
    public String user(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/users";
    }

}
