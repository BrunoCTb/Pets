package com.pets.petsecommerce.model.entity.cart;

import com.pets.petsecommerce.model.entity.user.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;


}
