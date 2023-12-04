package com.fileupload.Fileupload.controller;

import com.fileupload.Fileupload.entity.FileData;
import com.fileupload.Fileupload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    @GetMapping("/get")
    public List<FileData>getDetails(){
        return fileService.getDetails();
    }

//    public ResponseEntity<?> downloadFile(@PathVariable String fileName){
//        byte[] imageData = fileService.downloadFile(fileName);
//        return  ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/png")).body(imageData);
//    }
}
