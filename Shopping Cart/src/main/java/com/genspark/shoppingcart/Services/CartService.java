package com.genspark.shoppingcart.Services;

import com.genspark.shoppingcart.Dao.CartDao;
import com.genspark.shoppingcart.Dao.ProductDao;
import com.genspark.shoppingcart.Entity.Cart;
import com.genspark.shoppingcart.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CartService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CartDao cartDao;

    public Set<Product> getCartItems(int id) {
        return getCart(id).getItems();
    }

    public void setCartItems(int cartId, Set<Product> items) {
        cartDao.save(new Cart(cartId, items));
    }

    public Cart getCart(int id) {
        return cartDao.findById(id).get();
    }

    public void addToCart(int id, Product product) {
        Cart cart = getCart(id);
        cart.addItem(product);
        cartDao.save(cart);
    }

    public void removeFromCart(int id, int productId) {
        Cart cart = getCart(id);
        cart.removeItem(productId);
        cartDao.save(cart);
    }

    public void deleteCart(int id) {
        cartDao.deleteById(id);
    }

    public void createCart(int id) {
        cartDao.save(new Cart(id));
    }
}
