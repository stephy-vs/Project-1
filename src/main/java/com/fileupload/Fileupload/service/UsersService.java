package com.fileupload.Fileupload.service;

import com.fileupload.Fileupload.entity.UsersModel;
import com.fileupload.Fileupload.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository=usersRepository;
    }

    public UsersModel registerUser(String login,String password,String email){
        if (login==null&&password==null){
            return null;
        }else{
            if (usersRepository.findFirstByLogin(login).isPresent()){
                System.out.println("Duplicate Login");
                return null;
            }
            UsersModel usersModel = new UsersModel();
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            return usersRepository.save(usersModel);
        }
    }

    public UsersModel authenticate(String login, String password){
        return usersRepository.findByLoginAndPassword(login,password).orElse(null);
    }

    public UsersModel findByID(Integer userId){
        return usersRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found Exception"+userId));
    }


}
