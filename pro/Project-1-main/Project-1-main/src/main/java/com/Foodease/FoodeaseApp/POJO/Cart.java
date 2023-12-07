package com.Foodease.FoodeaseApp.POJO;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
@NamedQuery(name = "Cart.getAllCart",query = "select new com.Foodease.FoodeaseApp.wrapper.CartWrapper(c.id, c.qty, c.dish.id, c.dish.name, c.dish.description, c.dish.price) from Cart c")
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "cartTable")
public class Cart implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "dish_id",nullable = false)
    private Dish dish;

    @Column(name = "qty")
    private Integer qty;

}
