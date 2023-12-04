package com.fileupload.Fileupload.repository;

import com.fileupload.Fileupload.entity.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel,Integer> {


    Optional<UsersModel> findByLoginAndPassword(String login, String password);
    Optional<UsersModel> findFirstByLogin(String login);

    Optional<UsersModel> findById(Integer id);




}
