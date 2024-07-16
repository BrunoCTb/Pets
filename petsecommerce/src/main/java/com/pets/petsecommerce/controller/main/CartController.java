package com.pets.petsecommerce.controller.main;

import com.pets.petsecommerce.model.entity.cart.Cart;
import com.pets.petsecommerce.model.entity.cart.CartProduct;
import com.pets.petsecommerce.model.entity.product.Product;
import com.pets.petsecommerce.model.entity.user.User;
import com.pets.petsecommerce.repository.ProductRepository;
import com.pets.petsecommerce.service.ShoppingCartService;
import com.pets.petsecommerce.service.UserService;

import jakarta.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

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
        List<CartProduct> cartProducts = shoppingCartService.getAllCartProducts(userService.getCurrentUser().getId());
        List<Product> products = shoppingCartService.CartProductsToProducts(cartProducts);

        model.addAttribute("cart", cartProducts);
        model.addAttribute("totalCartPrice", shoppingCartService.getTotalCartPrice(products).toString());

        return "main/cart";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Long productId, Model model) {
        User currentUser = userService.getCurrentUser();
        Cart cartByUserId = shoppingCartService.findCartByUserId(currentUser.getId());
        Optional<CartProduct> productInCart = shoppingCartService.productInCart(productId, currentUser.getId());

        if (productInCart.isPresent()) {
            shoppingCartService.updateProductQuantity(productInCart.get(), "plus");

            return "redirect:/carrinho";
        }

        Product productToSave = productRepository.findById(productId).get();

        if (cartByUserId == null) {
            shoppingCartService.createCart(new Cart(currentUser));
            cartByUserId = shoppingCartService.findCartByUserId(currentUser.getId());
        }

        CartProduct newCartProduct = new CartProduct(1, cartByUserId, productToSave);
        shoppingCartService.createCartProduct(newCartProduct);

        shoppingCartService.productInCart(productId, currentUser.getId());

        return "redirect:/";
    }

    @RequestMapping(value = "/remover/{id}", method = RequestMethod.POST)
    public String deleteProduct(@PathVariable("id") Long productId) {
        shoppingCartService.deleteCartProductById(productId);

        return "redirect:/";
    }

    @RequestMapping(value = "/quantidade/{operation}={id}", method = RequestMethod.POST)
    public String changeProductQuantity(@PathVariable("operation") String operation, @PathVariable("id") Long productId) {
        CartProduct cartProduct = shoppingCartService.findCartProductById(productId).get();
        shoppingCartService.updateProductQuantity(cartProduct, operation);

        return "redirect:/";
    }


}
