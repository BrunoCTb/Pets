package com.pets.petsecommerce.controller.admin;

import com.pets.petsecommerce.dto.ProductDto;
import com.pets.petsecommerce.model.entity.product.Product;
import com.pets.petsecommerce.service.CategoryService;
import com.pets.petsecommerce.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/product")
public class ProductAdminController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String products() {
        return "admin/product/products";
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());

        return "admin/product/show-products";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable(value = "id") Long id) {

        return "test";
    }

    @GetMapping("/create")
    public String createProductForm(Model model) {
        model.addAttribute("productCategories", categoryService.findAll());

        return "admin/product/create-product";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute ProductDto dto) throws ParseException {
        System.out.println(dto);

        Product product = new Product();
        BeanUtils.copyProperties(dto, product);

        product.setPrice(new BigDecimal(dto.getPrice()));
        product.setDiscountPrice(new BigDecimal(dto.getDiscountPrice()));
        product.setPreviousPrice(new BigDecimal(dto.getPreviousPrice()));
        product.setInitialOffer(LocalDate.parse(dto.getInitialOffer()));
        product.setExpirationOffer(LocalDate.parse(dto.getExpirationOffer()));
        product.setCategory(categoryService.findByName(dto.getCategory()));

        System.out.println(product);

        productService.save(product);

        return "redirect:/admin/";
    }

    // update

    // delete

}
