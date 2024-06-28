package com.pets.petsecommerce.model.entity.cart;

import com.pets.petsecommerce.model.entity.product.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private BigDecimal price;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;


}
