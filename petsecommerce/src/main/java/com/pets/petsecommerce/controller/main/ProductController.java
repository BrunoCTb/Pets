package com.pets.petsecommerce.controller.main;

import com.pets.petsecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/id={id}")
    public String productPageBuy(@PathVariable("id") Long productId, Model model) {
        model.addAttribute("product", productService.findById(productId).get());

        return "main/product-page-buy";
    }

    @GetMapping("/comprar")
    public String productBuyStage1() {

        
        return "main/test";
    }


}
