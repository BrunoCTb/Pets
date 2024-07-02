package com.pets.petsecommerce.controller.main;

import com.pets.petsecommerce.model.category.ProductAlternativeCategories;
import com.pets.petsecommerce.model.entity.product.Product;
import com.pets.petsecommerce.service.CategoryService;
import com.pets.petsecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean isAuth = auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken);

        String product = "fake product";
        List<String> ps = List.of(product, product, product, product);
        model.addAttribute("products", productService.findAll());

        model.addAttribute("productCategories", categoryService.findAll());

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
