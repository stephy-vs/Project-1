package com.Foodease.FoodeaseApp.service;

import com.Foodease.FoodeaseApp.wrapper.CartWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface CartService {
    ResponseEntity<String>addCartDish(Map<String,String> requestMap);

    ResponseEntity<List<CartWrapper>> getAllCart();
}
