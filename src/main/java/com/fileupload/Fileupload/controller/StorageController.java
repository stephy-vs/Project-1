package com.fileupload.Fileupload.controller;

import com.fileupload.Fileupload.entity.ImageData;
import com.fileupload.Fileupload.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/dbimg")
public class StorageController {
    @Autowired
    private StorageService storageService;
    @PostMapping("/upimg")
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = storageService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);

    }

    @GetMapping("/dowimg")
    public List<ImageData>getDetails(){
        return storageService.getDetails();
    }




}
