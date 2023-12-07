package com.Foodease.FoodeaseApp.serviceImpl;

import com.Foodease.FoodeaseApp.JWT.JwtFilter;
import com.Foodease.FoodeaseApp.POJO.Cart;
import com.Foodease.FoodeaseApp.POJO.Dish;
import com.Foodease.FoodeaseApp.constant.RestaurantConstants;
import com.Foodease.FoodeaseApp.dao.CartDao;
import com.Foodease.FoodeaseApp.service.CartService;
import com.Foodease.FoodeaseApp.utils.RestaurantUtils;
import com.Foodease.FoodeaseApp.wrapper.CartWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
public class CartServiceImpl implements CartService {

   @Autowired
    JwtFilter jwtFilter;

   @Autowired
    CartDao cartDao;
    @Override
    public ResponseEntity<String> addCartDish(Map<String, String> requestMap) {
        log.info("inside addCartDish");
        try {
            if (jwtFilter.isUser()){
                if (validateCartMap(requestMap,false)){
                    cartDao.save(getCartFromMap(requestMap,false));
                    return RestaurantUtils.getResponseEntity("Cart Added Successfully",HttpStatus.OK);
                }
                return RestaurantUtils.getResponseEntity(RestaurantConstants.Invalid_Data,HttpStatus.BAD_REQUEST);
            }else {
                return RestaurantUtils.getResponseEntity(RestaurantConstants.Unauthorized_Access,HttpStatus.UNAUTHORIZED);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return RestaurantUtils.getResponseEntity(RestaurantConstants.Something_Went_Wrong, HttpStatus.INTERNAL_SERVER_ERROR);
    }




    private boolean validateCartMap(Map<String, String> requestMap, boolean validateId) {
        if (requestMap.containsKey("qty")){
            if (requestMap.containsKey("id") && validateId){
                return true;
            }else if (!validateId){
                return true;
            }
        }
        return false;
    }

    private Cart getCartFromMap(Map<String, String> requestMap, boolean isAdd) {
        Dish dish1 = new Dish();
        dish1.setId(Integer.parseInt(requestMap.get("dish_id")));

        Cart cart = new Cart();

        if (isAdd){
            cart.setId(Integer.parseInt(requestMap.get("id")));
        }
        cart.setDish(dish1);
        cart.setQty(Integer.parseInt(requestMap.get("qty")));
        return cart;
    }

    @Override
    public ResponseEntity<List<CartWrapper>> getAllCart() {

        try {
            return new ResponseEntity<>(cartDao.getAllCart(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
