package com.fileupload.Fileupload.repository;

import com.fileupload.Fileupload.entity.FileData;
import com.fileupload.Fileupload.entity.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<FileData,Integer> {
//    Optional<UsersModel> findByID(Integer userID);
//    Optional<FileData> findByName(String fileName);
}
