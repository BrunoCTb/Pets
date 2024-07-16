package com.pets.petsecommerce.service;

import com.pets.petsecommerce.model.entity.cart.Cart;
import com.pets.petsecommerce.model.entity.cart.CartProduct;
import com.pets.petsecommerce.model.entity.product.Product;
import com.pets.petsecommerce.repository.CartProductRepository;
import com.pets.petsecommerce.repository.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ShoppingCartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartProductRepository cartProductRepository;

    public Cart findCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public Optional<CartProduct> findCartProductById(long productId) {
        return cartProductRepository.findById(productId);
    }

    public Optional<CartProduct> productInCart(Long productId, Long currentUserId) {
        List<CartProduct> allCartProducts = this.getAllCartProducts(currentUserId);

        for (CartProduct p : allCartProducts) {
            if (p.getProduct().getId().equals(productId)) {
                return Optional.of(p);
            }
        }

        return Optional.empty();
    }

    public void updateProductQuantity(CartProduct cartProduct, String operation) {

        cartProduct.setId(cartProduct.getId());
        if (operation.equals("plus")) {
            cartProduct.setQuantity(cartProduct.getQuantity() + 1);
        }else if (operation.equals("sub") && cartProduct.getQuantity() > 0){
            cartProduct.setQuantity(cartProduct.getQuantity() - 1);
        }

        cartProductRepository.save(cartProduct);
    }

    @Transactional
    public void createCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Transactional
    public void createCartProduct(CartProduct cartProduct) {
        cartProductRepository.save(cartProduct);
    }

    @Transactional
    public void deleteCartProductById(Long id) {
        cartProductRepository.deleteById(id);
    }

    public List<CartProduct> getAllCartProducts(Long userId) {
        // achar o carrinho pelo id do user atual
        Cart cartByUserId = this.findCartByUserId(userId);

        // retornar lista vazia, pois ira ver tamanho da lista para checar se ha e quantos no carrinho
        if (cartByUserId == null) {
            return List.of();
        }

        // retornar a lista de produtos do carrinho com referencia ao usuario atual
        return cartProductRepository.findByCartId(cartByUserId.getId());
    }

    // faz uma convercao da lista que é do tipo CartProduct pegando apenas o Product
    public List<Product> CartProductsToProducts(List<CartProduct> cartProducts) {
        return cartProducts.stream()
                .map(CartProduct::getProduct)
                .collect(Collectors.toList());
    }

    public BigDecimal getTotalCartPrice(List<Product> cartProducts) {
        BigDecimal total = BigDecimal.ZERO;
        for (Product i : cartProducts) {
            total = total.add(i.getPrice());
        }

        return total;
    }
        
}
