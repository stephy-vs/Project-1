package com.Foodease.FoodeaseApp.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data

public class CartWrapper {
    Integer id;
    Integer qty;
    Integer dishId;
    String dishName;
    String dishDescription;
    BigDecimal price;

    public CartWrapper() {

    }

    public CartWrapper(Integer id, Integer qty, Integer dishId, String dishName, String dishDescription, BigDecimal price) {
        this.id = id;
        this.qty = qty;
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishDescription = dishDescription;
        this.price = price;
    }
}
