package com.pets.petsecommerce.model.entity.cart;

import com.pets.petsecommerce.model.entity.product.Product;
import com.pets.petsecommerce.model.entity.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate;
    private BigDecimal totalAmount;

    @ManyToOne
    private User user;

    @OneToMany
    private List<OrderProduct> items;





}
