package com.fileupload.Fileupload.controller;

import com.fileupload.Fileupload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@RestController
@RequestMapping(path = "/fileS")
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping(path = "/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("image")MultipartFile file,
                                        @RequestParam("userID") Integer userID)throws IOException{
        String uploadImage = fileService.uploadImage(file,userID);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }
}
