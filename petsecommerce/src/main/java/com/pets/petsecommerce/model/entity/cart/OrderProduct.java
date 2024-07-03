package com.pets.petsecommerce.model.entity.cart;

import com.pets.petsecommerce.model.entity.product.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderProduct {

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
