package com.pets.petsecommerce.model.entity.product;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private String color;
    private String size;
    private Boolean offer;
    private String image;
    @OneToOne
    private ProductCategory category;

    public Product(String name, String price, String color, String size, Boolean offer, String image, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.size = size;
        this.offer = offer;
        this.image = image;
        this.category = category;
    }

    public Product(String name, String price, String color, String size, Boolean offer, String image) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.size = size;
        this.offer = offer;
        this.image = image;
    }
}
