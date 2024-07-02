package com.pets.petsecommerce.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carrinho")
public class CartController {

// Autowired cart service

    @GetMapping
    public String cartPage(Model model) {
        // show products in cart db
//        model.addAttribute("cartProducts", ...)

        return "main/cart";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Long productId, Model model) {
        System.out.println(productId);

        // add to cart logic



        return "redirect:/carrinho";
    }


}
