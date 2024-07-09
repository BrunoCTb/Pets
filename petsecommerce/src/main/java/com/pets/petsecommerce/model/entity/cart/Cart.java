package com.pets.petsecommerce.model.entity.cart;

import com.pets.petsecommerce.model.entity.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    public Cart(User user) {
        this.user = user;
    }


}
