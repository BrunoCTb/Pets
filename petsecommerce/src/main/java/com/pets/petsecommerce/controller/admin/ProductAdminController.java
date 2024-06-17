package com.pets.petsecommerce.controller.admin;

import com.pets.petsecommerce.dto.ProductDto;
import com.pets.petsecommerce.model.entity.product.Product;
import com.pets.petsecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/produto")
public class ProductAdminController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public String getAllProducts() {
        return "test";
    }

    @GetMapping("/get/{id}")
    public String getAllProducts(@RequestParam Long id) {
        return "test";
    }

    @GetMapping("/criar")
    public String createProductForm() {
        return "admin/create-product";
    }

    @PostMapping("/criar")
    public String createProduct(@ModelAttribute ProductDto dto) {
        System.out.println(dto);

        return "redirect:/admin/";
    }

    // update

    // delete

}
