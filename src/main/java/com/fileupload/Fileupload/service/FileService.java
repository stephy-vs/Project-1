package com.fileupload.Fileupload.service;

import com.fileupload.Fileupload.entity.FileData;
import com.fileupload.Fileupload.entity.ImageData;
import com.fileupload.Fileupload.entity.UsersModel;
import com.fileupload.Fileupload.repository.FileRepository;
import com.fileupload.Fileupload.repository.UsersRepository;
import com.fileupload.Fileupload.util.ImageUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Slf4j
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

    public List<FileData> getDetails() {
        return fileRepository.findAll();
    }

//    public byte[] downloadFile(String fileName) {
//        log.info("Inside download File");
//        Optional<FileData> dbImageData = fileRepository.findByName(fileName);
//        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImagedata());
//        return images;
//    }
}
