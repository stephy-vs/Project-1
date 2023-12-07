package com.Foodease.FoodeaseApp.rest;

import com.Foodease.FoodeaseApp.POJO.Cart;
import com.Foodease.FoodeaseApp.wrapper.CartWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/cart")
public interface CartRest {
    @PostMapping(path = "/cartadd")
    ResponseEntity<String> addCartDish(@RequestBody Map<String,String> requestMap);

    @GetMapping(path = "/getcart")
    ResponseEntity<List<CartWrapper>> getAllCart();
}
