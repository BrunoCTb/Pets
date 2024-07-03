package com.pets.petsecommerce.repository;

import com.pets.petsecommerce.model.entity.cart.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {

    List<CartProduct> findByCartId(Long cartId);
}
