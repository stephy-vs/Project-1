package com.Foodease.FoodeaseApp.POJO;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@NamedQuery(name="User.findByEmailId",query = "select u from User u where u.email=:email")
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "reg")
public class User implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "contactNumber",nullable = false,length = 10)
    private String contactNumber;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

   @Column(name = "status")
    private String status;

   @Column(name = "role")
   private String role;
}
