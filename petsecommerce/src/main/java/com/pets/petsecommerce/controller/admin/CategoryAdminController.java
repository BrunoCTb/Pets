package com.pets.petsecommerce.controller.admin;

import com.pets.petsecommerce.dto.CategoryDto;
import com.pets.petsecommerce.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/categoria")
public class CategoryAdminController {

    @GetMapping("/criar")
    public String createCategoryForm() {
        return "admin/create-category";
    }

    @PostMapping("/criar")
    public String createCategory(@ModelAttribute CategoryDto dto) {
        System.out.println(dto);

        return "redirect:/admin/";
    }


}
