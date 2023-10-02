package com.fileupload.Fileupload.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="uimg")
@Data
public class UsersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;
    private String email;
}
