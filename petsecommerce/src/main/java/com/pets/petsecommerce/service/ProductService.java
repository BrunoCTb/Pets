package com.pets.petsecommerce.service;

import com.pets.petsecommerce.dto.ProductDto;
import com.pets.petsecommerce.model.entity.product.Product;
import com.pets.petsecommerce.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryService categoryService;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void update(Product updatedProduct) {
    }

    public Product convertDtoToProduct(ProductDto dto) {
        Product product = new Product();
        BeanUtils.copyProperties(dto, product);

        product.setPrice(new BigDecimal(dto.getPrice()));
        product.setDiscountPrice(new BigDecimal(dto.getDiscountPrice()));
        product.setPreviousPrice(new BigDecimal(dto.getPreviousPrice()));
        product.setInitialOffer(LocalDate.parse(dto.getInitialOffer()));
        product.setExpirationOffer(LocalDate.parse(dto.getExpirationOffer()));
        product.setCategory(categoryService.findByName(dto.getCategory()));

        return product;
    }
}
