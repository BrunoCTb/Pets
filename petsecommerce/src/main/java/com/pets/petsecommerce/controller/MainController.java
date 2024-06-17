package com.pets.petsecommerce.controller;

import com.pets.petsecommerce.model.entity.product.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MainController {

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        Product product = new Product("cachorro pelucia 1", "2.85", "branco", "pequeno", false, "no image");
        List<Product> ps = List.of(product, product, product, product);

         model.addAttribute("products", ps);

        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
