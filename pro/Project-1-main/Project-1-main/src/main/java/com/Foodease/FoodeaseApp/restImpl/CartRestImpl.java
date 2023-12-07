package com.Foodease.FoodeaseApp.restImpl;

import com.Foodease.FoodeaseApp.constant.RestaurantConstants;
import com.Foodease.FoodeaseApp.rest.CartRest;
import com.Foodease.FoodeaseApp.service.CartService;
import com.Foodease.FoodeaseApp.utils.RestaurantUtils;
import com.Foodease.FoodeaseApp.wrapper.CartWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CartRestImpl implements CartRest {

    @Autowired
    CartService cartService;
    @Override
    public ResponseEntity<String> addCartDish(Map<String, String> requestMap) {
        try {
            return cartService.addCartDish(requestMap);

        }catch (Exception e){
            e.printStackTrace();
        }
        return RestaurantUtils.getResponseEntity(RestaurantConstants.Something_Went_Wrong, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<CartWrapper>> getAllCart() {
        try {
            return cartService.getAllCart();

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
