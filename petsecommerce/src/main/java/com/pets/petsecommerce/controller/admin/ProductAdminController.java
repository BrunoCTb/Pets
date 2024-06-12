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
@RequestMapping("/product")
public class ProductAdminController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Product> getAllProducts(@RequestParam Long id) {
        return productService.findById(id);
    }

    @PostMapping("/create")
    public HttpStatus createProduct(@ModelAttribute ProductDto dto) {
        return HttpStatus.CREATED;
    }

    // update

    // delete

}
