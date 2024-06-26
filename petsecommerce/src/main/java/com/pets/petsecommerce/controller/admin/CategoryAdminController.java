package com.pets.petsecommerce.controller.admin;

import com.pets.petsecommerce.dto.CategoryDto;
import com.pets.petsecommerce.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/category")
public class CategoryAdminController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String allCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());

        return "admin/category/categories";
    }

    @GetMapping("/create")
    public String createCategoryForm() {
        return "admin/category/create-category";
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute CategoryDto dto) {
        System.out.println(dto);

        return "redirect:/admin/";
    }


}
