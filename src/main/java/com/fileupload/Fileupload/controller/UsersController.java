package com.fileupload.Fileupload.controller;

import com.fileupload.Fileupload.entity.UsersModel;
import com.fileupload.Fileupload.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class UsersController {
    @Autowired
    UsersService usersService;
    @PostMapping("/register")
    public boolean register(@RequestBody UsersModel usersModel){
        UsersModel registeredUser =usersService.registerUser(usersModel.getLogin()
                ,usersModel.getPassword(),usersModel.getEmail());
        return registeredUser==null;
    }

    @PostMapping("/login")
    public String login(@RequestBody UsersModel usersModel){
        UsersModel authenticated = usersService.authenticate(usersModel.getLogin(), usersModel.getPassword());
        if (authenticated!=null){
            return "Login Successfully!!!...";
        }else {
            return "Error Page!!!...";
        }
    }



}
