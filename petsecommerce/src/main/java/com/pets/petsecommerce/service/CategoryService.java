package com.pets.petsecommerce.service;

import com.pets.petsecommerce.model.entity.product.ProductCategory;
import com.pets.petsecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Optional<ProductCategory> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<ProductCategory> findAll() {
        return categoryRepository.findAll();
    }

    public ProductCategory findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
