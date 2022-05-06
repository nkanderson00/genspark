package com.genspark.shoppingcart.Entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne()
    private Cart cart;

    public Cart getCart(int id) {
        return cart;
    }
}