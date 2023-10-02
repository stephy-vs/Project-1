//package com.fileupload.Fileupload.service;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//@Service
//public class FileServiceImpl implements FileService{
//    @Override
//    public String uploadImage(String path, MultipartFile file) throws IOException {
//        String name = file.getOriginalFilename();
//
//        String filePath=path+ File.separator+name;
//        File file1 =new File(path);
//        if (!file1.exists()){
//            file1.mkdir();
//        }
//
//        //file copy
//        Files.copy(file.getInputStream(), Paths.get(filePath));
//
//
//
//        return name;
//    }
//}
