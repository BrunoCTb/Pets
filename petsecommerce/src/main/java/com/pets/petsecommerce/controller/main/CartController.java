package com.pets.petsecommerce.controller.main;

import com.pets.petsecommerce.model.entity.cart.Cart;
import com.pets.petsecommerce.model.entity.cart.CartProduct;
import com.pets.petsecommerce.model.entity.product.Product;
import com.pets.petsecommerce.model.entity.user.User;
import com.pets.petsecommerce.repository.ProductRepository;
import com.pets.petsecommerce.service.ShoppingCartService;
import com.pets.petsecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/carrinho")
public class CartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    UserService userService;

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public String cartPage(Model model) {

        List<Product> cartProducts = shoppingCartService.getAllCartProducts(userService.getCurrentUser().getId());

        model.addAttribute("cartProducts", cartProducts);

        return "main/cart";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Long productId, Model model) {
        // encontrar o usuario logado atual e encontrar o carrinho pelo id do user atual
        User currentUser = userService.getCurrentUser();
        Cart cartByUserId = shoppingCartService.findCartByUserId(currentUser.getId());
        Product productToSave = productRepository.findById(productId).get();

        // verificar se o carrinho (cart) existe
        // caso nao exista: criar o carrinho
        if (cartByUserId == null) {
            shoppingCartService.createCart(new Cart(currentUser));
        }

        // caso exista: adicionar o produto no carrinho (cart product)
        CartProduct newCartProduct = new CartProduct(1, cartByUserId, productToSave);
        shoppingCartService.createCartProduct(newCartProduct);

        return "redirect:/";
    }


}
