package com.pets.petsecommerce.model.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private List<String> color;
    private List<String> size;
    private String image;
    private BigDecimal defaultPrice;

    @ManyToOne
    private Sale sale;

    @ManyToOne
    private ProductCategory category;

    public Product(String name, List<String> color, List<String> size, String image, BigDecimal defaultPrice, Sale sale, ProductCategory category) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.image = image;
        this.defaultPrice = defaultPrice;
        this.sale = sale;
        this.category = category;
    }


}
