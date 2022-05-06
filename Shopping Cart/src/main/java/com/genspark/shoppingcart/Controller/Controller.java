package com.genspark.shoppingcart.Controller;

import com.genspark.shoppingcart.Entity.Cart;
import com.genspark.shoppingcart.Entity.Product;
import com.genspark.shoppingcart.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
public class Controller {

    @Autowired
    private CartService cartService;


    @GetMapping("/cart/{id}")
    public Cart getCart(@PathVariable("id") int id) {
        return cartService.getCart(id);
    }

    @PostMapping("/cart/{id}")
    public void createCart(@PathVariable("id") int id) {
        cartService.createCart(id);
    }

    @GetMapping("/cart/{id}/items")
    public Set<Product> getCartItems(@PathVariable("id") int id) {
        return cartService.getCartItems(id);
    }

    @PutMapping("/cart/{id}")
    public void addToCart(@PathVariable("id") int id, @RequestBody Product product) {
        cartService.addToCart(id, product);
    }

    @DeleteMapping("/cart/{id}/items/{productId}")
    public void removeFromCart(@PathVariable("id") int id, @PathVariable("productId") int productId) {
        cartService.removeFromCart(id, productId);
    }

    @DeleteMapping("/cart/{id}")
    public void deleteCart(@PathVariable("id") int id) {
        cartService.deleteCart(id);
    }
}



