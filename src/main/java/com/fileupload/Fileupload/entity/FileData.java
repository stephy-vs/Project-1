package com.fileupload.Fileupload.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "filetable")
@Builder
public class FileData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "imagedata",length = 10000)
    private byte[] imagedata;

    @ManyToOne
    @JoinColumn(name = "uId")
    private UsersModel usersModel;

}
