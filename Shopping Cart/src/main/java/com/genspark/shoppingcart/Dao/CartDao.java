package com.genspark.shoppingcart.Dao;

import com.genspark.shoppingcart.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {}