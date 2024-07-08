package com.pets.petsecommerce.service;

import com.pets.petsecommerce.model.entity.cart.Cart;
import com.pets.petsecommerce.model.entity.cart.CartProduct;
import com.pets.petsecommerce.model.entity.product.Product;
import com.pets.petsecommerce.repository.CartProductRepository;
import com.pets.petsecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartProductRepository cartProductRepository;

    public Cart findCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public void createCart(Cart cart) {
        cartRepository.save(cart);
    }

    public void createCartProduct(CartProduct cartProduct) {
        cartProductRepository.save(cartProduct);
    }

    public List<Product> getAllCartProducts(Long userId) {
        // achar o carrinho pelo id do user atual
        Cart cartByUserId = this.findCartByUserId(userId);


        // retornar lista vazia, pois ira ver tamanho da lista para checar se ha e quantos no carrinho
        if (cartByUserId == null) {
            return List.of();
        }

        // retornar a lista de produtos do carrinho com referencia ao usuario atual
        List<CartProduct> cartItems = cartProductRepository.findByCartId(cartByUserId.getId());

        // retorna a lista com stream mapeando para pegar cada produto
        return cartItems.stream()
                .map(CartProduct::getProduct)
                .collect(Collectors.toList());
    }

}
