package com.Foodease.FoodeaseApp.dao;

import com.Foodease.FoodeaseApp.POJO.Cart;
import com.Foodease.FoodeaseApp.wrapper.CartWrapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartDao extends JpaRepository <Cart,Integer>{
    List<CartWrapper> getAllCart();
}
