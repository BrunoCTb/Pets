package com.pets.petsecommerce.repository;

import com.pets.petsecommerce.model.entity.product.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<ProductCategory, Long> {
    ProductCategory findByName(String name);
}
