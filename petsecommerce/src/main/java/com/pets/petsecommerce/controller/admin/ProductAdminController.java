package com.pets.petsecommerce.controller.admin;

import com.pets.petsecommerce.dto.ProductDto;
import com.pets.petsecommerce.model.entity.product.Product;
import com.pets.petsecommerce.service.CategoryService;
import com.pets.petsecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Optional;

@Controller
@RequestMapping("/admin/product")
public class ProductAdminController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());

        return "admin/product/products";
    }

    // CREATE
    @GetMapping("/create")
    public String createProductForm(Model model) {
        model.addAttribute("productCategories", categoryService.findAll());

        return "admin/product/create-product";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute ProductDto dto) throws ParseException {
        Product product = productService.convertDtoToProduct(dto);
        productService.save(product);

        return "redirect:/admin/";
    }

    // UPDATE
    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable(value = "id") Long id, Model model) {
        Optional<Product> product = productService.findById(id);

        if (product.isEmpty()) {
            System.out.println("produto não existe");
            return "redirect:/admin";
        }

        model.addAttribute("product", product.get());
        model.addAttribute("productCategories", categoryService.findAll());

        return "admin/product/edit-product";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable(value = "id") Long id, ProductDto dto) {
        System.out.println(dto);

        Product product = productService.convertDtoToProduct(dto);
        product.setId(id);
        productService.update(product);

        System.out.println(product);

        return "redirect:/admin/product";
    }

    // REMOVE
    @GetMapping("/remove/{id}")
    public String removeProduct(@PathVariable(value = "id") Long id) {
        productService.deleteById(id);

        return "redirect:/admin/product";
    }

}
