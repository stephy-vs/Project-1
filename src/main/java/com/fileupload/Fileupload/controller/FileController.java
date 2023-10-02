//package com.fileupload.Fileupload.controller;
//
//import com.fileupload.Fileupload.playload.FileResponse;
//import com.fileupload.Fileupload.service.FileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.net.HttpCookie;
//
//@RestController
//@RequestMapping("/file")
//public class FileController {
//    @Value("${project-image}")
//    private String path;
//
//    @Autowired
//    private FileService fileService;
//
//    @PostMapping("/upload")
//    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image")MultipartFile image){
//        String fileName= null;
//        try {
//            fileName = this.fileService.uploadImage(path,image);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//
//        }
//
//      return new ResponseEntity<>(new FileResponse(fileName,"Image is Successfully Uploaded"), HttpStatus.OK);
//        //return ResponseEntity.ok().body("Sucessfully");
//    }
//}
