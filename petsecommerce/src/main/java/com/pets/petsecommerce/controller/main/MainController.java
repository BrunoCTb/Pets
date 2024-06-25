package com.pets.petsecommerce.controller.main;

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

        String product = "fake product";
        List<String> ps = List.of(product, product, product, product);

         model.addAttribute("products", ps);

        return "main/home";
    }

    @GetMapping("/login")
    public String login() {
        return "main/login";
    }


    @GetMapping("/test")
    public String test() {
        return "main/test";
    }

}
