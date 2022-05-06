package com.genspark.shoppingcart.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    //set of all products saved
    @OneToMany()
    private Set<Product> items = new HashSet<>();

    @Column(name = "total_price")
    private float totalPrice = 0;

    public Cart() {
    }

    public Cart(int cartId) {
        this.cartId = cartId;
    }

    public Cart(int cartId, Set<Product> items) {
        this.cartId = cartId;
        this.items = items;
    }

    public Set<Product> getItems() {
        return items;
    }

    public void addItem(Product item) {
        items.add(item);
        updatePrice();
    }

    public void removeItem(int productId) {
        Optional<Product> product = items.stream().filter(p -> p.getId() == productId).findFirst();
        product.ifPresent(items::remove);
        updatePrice();
    }

    public void updatePrice() {
        for (Product item : items)
            totalPrice += item.getPrice();
    }

}
