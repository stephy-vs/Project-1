package com.fileupload.Fileupload.service;

import com.fileupload.Fileupload.entity.FileData;
import com.fileupload.Fileupload.entity.ImageData;
import com.fileupload.Fileupload.entity.UsersModel;
import com.fileupload.Fileupload.repository.FileRepository;
import com.fileupload.Fileupload.repository.UsersRepository;
import com.fileupload.Fileupload.util.ImageUtils;
import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    UsersRepository usersRepository;
    public String uploadImage(MultipartFile file, Integer userId) throws IOException {

        UsersModel usersModel1 = usersRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User id Not Found"+userId));


        FileData fileData =fileRepository.save(FileData.builder()
                        .usersModel(usersModel1)
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imagedata(ImageUtils.compressImage(file.getBytes())).build());


        if (fileData!=null){
            return "File Upload Successfully"+file.getOriginalFilename();
        }

        return null;

    }
}
