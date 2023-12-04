package com.fileupload.Fileupload.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="regtbl")
@Data
public class UsersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;
}
