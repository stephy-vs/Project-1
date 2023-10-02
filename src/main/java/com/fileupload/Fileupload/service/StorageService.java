package com.fileupload.Fileupload.service;

import com.fileupload.Fileupload.entity.ImageData;
import com.fileupload.Fileupload.repository.StorageRepository;
import com.fileupload.Fileupload.util.ImageUtils;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class StorageService {
    @Autowired
    private StorageRepository storageRepository;
    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = storageRepository.save(ImageData.builder()
                .name(file.getOriginalFilename()).type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData!=null){
            return "FileUploaded Successfully.!!! "+file.getOriginalFilename();
        }
        return null;
    }


    public List<ImageData> getDetails() {
        return storageRepository.findAll();
    }
}
